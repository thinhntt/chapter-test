# README #
### What is this repository for? ###

* Testng and Allure for report

### How do I get set up? ###

* Windows
* Docker
* Java 8 (recommend)
* Maven
* Chrome 96

### Project structure ###
1. Java source: src/main/java/com/thinh/nguyen
2. Test source: src/test/java/com/thinh/nguyen
3. Resource folder:
- test suite xml: src/test/resources/suite
- chrome driver (windows): src/test/resources/chromedriver.exe

### Step to run chapter test ###

* Local windows: Open windows terminal and run commandlines
1. git clone https://github.com/thinhntt/chapter-test.git
2. cd chapter-test
3. mvn clean test -P local-windows

### Result ###
Tests run: 7, Failures: 1, Errors: 0, Skipped: 0

Bug : A failure of additional scenario in testcase 2 for invalid email without suffix domain (didn't show error message): amknow@know 
