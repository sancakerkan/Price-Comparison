# Price-Comparison
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction
The Price-Comparison project is a Java-based application that uses Selenium WebDriver to fetch and compare prices of the same product from different e-commerce websites. The goal is to find the cheapest, average, and most expensive prices among the specified websites.

## Features
- **Cross-Browser Support:** The project supports both Chrome and Firefox.
- **Real-Time Price Fetching:** Uses Selenium WebDriver to dynamically fetch prices.
- **Price Comparison:** Calculates and displays the cheapest, average, and most expensive prices.
- **Easy to Configure:** URLs can be easily modified to target different products or websites.

## Installation

### Prerequisites
- Java Development Kit (JDK) 8 or later
- Maven
- Chrome and Firefox browsers installed

### Cloning the Repository
1. Clone the repository:
    ```bash
    git clone <repository-url>
    cd Price-Comparison
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

## Usage

### Running the Application

1. **Using IntelliJ IDEA:**
    - Open the project in IntelliJ IDEA.
    - Navigate to the `src/main/java` directory.
    - Right-click on the `ChromePriceFetcher.java` or `FirefoxPriceFetcher.java` file.
    - Select `Run 'ChromePriceFetcher.main()'` or `Run 'FirefoxPriceFetcher.main()'`.

2. **Using Eclipse:**
    - Open the project in Eclipse.
    - Navigate to the `src/main/java` directory.
    - Right-click on the `ChromePriceFetcher.java` or `FirefoxPriceFetcher.java` file.
    - Select `Run As` > `Java Application`.

## Contributing
Contributions are welcome! Please follow these steps to contribute:
1. Fork the repository.
2. Create a new feature branch.
3. Commit your changes.
4. Push to the branch.
5. Open a pull request.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
