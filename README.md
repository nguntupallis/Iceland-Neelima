# Iceland-Neelima

Pre-requisites
1. Java - jdk-8u191-windows-x64.exe
2. Java - jdk-11.0.1_windows-x64_bin.exe
3. Eclipse IDE - eclipse-inst-win64.exe
4. Selenium Java Libraries - selenium-java-3.141.59.zip
5. Chromedriver.exe
6. Maven - apache-maven-3.6.0-bin.tar.gz

Running the tests
1. Extract the zip file from Git
2. Launch Eclipse and from the file menu select Import -> General -> Existing Projects into Workspace and point to the extracted zip folder
3. In the Project Explorer, expand src\test\java -> feature and double-click SearchRequirements.feature 
4. Right-click and from the context menu, select Run As -> 1 Cucumber Feature, the test scenarios should execute and Console should display the test results
5. In the Project Explorer, expand src\test\java -> gluecode and double-click StepDefinition.java. This contains the logic for executing the scenarios
6. In the Project Explorer, expand src\test\java -> pages and double-click MainPage.java. This contains the list of elements in the Iceland page
7. In the Project Explorer, expand src\test\java -> runner and double-click Runner.java. This contains the logic for the cucumber test runner



