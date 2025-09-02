# Jarvis

## Overview
Jarvis is a Java-based application featuring custom annotation processing for expiration logic. It includes utility libraries for date and time operations.

## Technologies Used
- Java
- Maven

## Prerequisites
- Java JDK 8 or higher
- Maven 3.x
- IntelliJ IDEA 2025.2.1 (recommended)

## Setup

1. **Clone the repository** - `git clone https://github.com/HexaLaboratories/jarvis.git`
2. **Navigate to the project directory** - `cd jarvis`
3. **Build the project** - `mvn clean install`

## Running the Application

- **From the command line:** - `mvn exec:java`
- **From IntelliJ IDEA:**
    - Open the project.
    - Right-click the main class and select `Run`.

## Testing

- Run all tests: mvn test

## Project Structure

- `src/main/java/org/hexa/jarvis/annotationProcessors/ExpirationProcessor.java`  
  Annotation processor for handling expiration logic.
- `src/main/java/org/hexa/jarvis/annotations/Expiration.java`  
  Custom annotation for expiration.
- `src/main/java/org/hexa/jarvis/libs/DateTimeUtils.java`  
  Utility class for date and time operations.
- `src/test/java/`  
  Unit tests.
- `pom.xml`  
  Maven configuration.

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Open a pull request

## Contact
- For questions or support, please open an issue on GitHub.
- Email: [rsrohitsingh931@gmail.com](mailto:rsrohitsingh931@gmail.com)
- LinkedIn: [Rohit Singh](https://www.linkedin.com/in/rsrohitsingh/)
