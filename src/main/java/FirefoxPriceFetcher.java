import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class FirefoxPriceFetcher {

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            String[] urls = {
                    "https://www.mediamarkt.com.tr/tr/product/_apple-iphone-15-pro-max-256-gb-akilli-telefon-siyah-titanium-mu773tua-1232476.html",
                    "https://www.troyestore.com/apple-iphone-15-pro-max-256gb-siyah-titanyum-mu773tua_213948",
                    "https://www.hepsiburada.com/iphone-15-pro-max-256-gb-p-HBCV00004XA8G6"
            };

            String[] selectors = {
                    "span[data-test='branded-price-whole-value']",  // MediaMarkt
                    "span.one-price.size-24.font-weight-500",       // Troyestore
                    "div.rNEcFrF82c7bJGqQHxht"                      // Hepsiburada
            };

            List<Double> prices = new ArrayList<>();

            for (int i = 0; i < urls.length; i++) {
                driver.get(urls[i]);

                WebElement priceElement = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selectors[i]))
                );

                String priceText = priceElement.getText().replaceAll("[^\\d,]", "").replace(",", ".");
                if (priceText.isEmpty()) {
                    System.err.println("Failed to extract price from " + urls[i]);
                    continue;
                }

                try {
                    double price = Double.parseDouble(priceText);
                    prices.add(price);
                    System.out.println(getSiteName(urls[i]) + " Price: " + formatPrice(price));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid price format at " + urls[i] + ": " + priceText);
                }
            }

            if (!prices.isEmpty()) {
                double minPrice = Collections.min(prices);
                double maxPrice = Collections.max(prices);
                double avgPrice = prices.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

                System.out.println("\nSummary:");
                System.out.println("Cheapest Price: " + formatPrice(minPrice));
                System.out.println("Most Expensive Price: " + formatPrice(maxPrice));
                System.out.println("Average Price: " + formatPrice(avgPrice));
            }
        } finally {
            driver.quit();
        }
    }

    private static String getSiteName(String url) {
        if (url.contains("mediamarkt")) return "MediaMarkt";
        if (url.contains("troyestore")) return "Troyestore";
        if (url.contains("hepsiburada")) return "Hepsiburada";
        return "Unknown";
    }

    private static String formatPrice(double price) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat formatter = new DecimalFormat("₺###,###.00", symbols);
        return formatter.format(price);
    }
}
