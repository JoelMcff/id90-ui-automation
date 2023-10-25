## Framework
The main technologies used are:
- Maven (3.9.4) - Java (jdk-15)
- Cucumber - Gherkin
- Serenity Screenplay BDD


## Suite

### Command line
The features are located under the _src/test/resources/features_ directory. <br />
To run the project, use the following command in the terminal:

```
mvn clean verify -Denvironment=qa
```
This command will run all the features/scenarios under the tag specified as default in the CucumberTestRunner class. <br />
<br>


Or, if you need to run specific scenarios, the command is as follows.

```
mvn clean verify -D"cucumber.filter.tags= @login" -Denvironment=qa
```  
<br>

The **-D"cucumber.filter.tags= @login"** is what we use to run the scenarios under the specified tag or tags. <br />
The following command will run all the scenarios under the tags @successful-login or @show-password-login:

```
-D"cucumber.filter.tags= @successful-login or @show-password-login"
```
<br>

The **-Denvironment**  refers to the environments hosted in the serenity.conf file. _src/test/resources/serenity.conf_ <br />
This allows having different attributes (e.g.: webdriver.base.url) based on the environment in which we need to run the tests.<br />
The following example will execute the tests and generate reports for the 'dev' environment:
```
-Denvironment=dev
```


## Reports

The reports can be accessed after the test run by navigating to the following path: <br />
_target/site/serenity/index.html_.<br />
Once you open the index file, you can choose the browser in which to view the reports.

## Acceptance Criteria for Login Feature

### Scenario 1: Successful Login

- **Given:** I am on the home page.
- **When:** I enter valid credentials.
- **And:** I click the login button.
- **Then:** I should be redirected to the dashboard page.

### Scenario 2: Unsuccessful Login (Incorrect Credentials)

- **Given:** I am on the home page.
- **When:** I enter invalid credentials.
- **And:** I click the login button.
- **Then:** I should see an alert indicating that the login was unsuccessful.

### Scenario 3: Credentials Invalid Combinations
(This is an outline scenario, used as example for different way of doing it, and it will run one time per examples on the examples table)
- **Given:** I am on the home page.
- **When:** I enter the invalid combination credentials.
- **And:** I click the login button
- **Then:** I should see an alert

### Scenario 4: Unsuccessful Login (Empty Fields)

- **Given:** I am on the home page.
- **When:** I click the login button without entering any credentials.
- **Then:** I should see error messages indicating that the following fields are empty: 
'Company,' 'Email or Employee Number,' and 'Password'.

### Scenario 5: Show and Hide password

- **Given:** I am on the home page.
- **When:** I enter valid credentials.
- **And:** I see the password field is hiding the password
- **And:** I click the show password button.
- **Then:** I should see the password field now shows what was typed.

### Scenario 6: Dashboard Viw

- **Given:** I am on the home page.
- **When:** I enter valid credentials.
- **And:** I click the login button
- **Then:** I should see the dashboard page displayed correctly (We can add the elements that we consider necessary.)


