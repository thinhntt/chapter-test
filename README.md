# README #
### What is this repository for? ###

* Testng and Allure for report

### How do I get set up? ###

* Docker
* Java 8 (recommend)
* Maven
* Chrome 96
* Allure report

### Project structure ###
1. Java source: src/main/java/com/thinh/nguyen
2. Test source: src/test/java/com/thinh/nguyen
3. Resource folder:
- test suite xml: src/test/resources/suite
- chrome driver (windows): src/test/resources/chromedriver.exe

### Commandline to run test ###

* Local
1. Open terminal on project
2. Run cmd "mvn clean test -P local-windows"

* Docker
1. Open terminal on project

### Result ###
Tests run: 7, Failures: 1, Errors: 0, Skipped: 0

Note: A failure or additional scenario in testcase 2 for invalid email without suffix domain: amknow@know