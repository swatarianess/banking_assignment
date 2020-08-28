# Banking Assignment [![Build Status](https://travis-ci.com/swatarianess/banking_assignment.svg?branch=master)](https://travis-ci.com/swatarianess/banking_assignment)[![codecov](https://codecov.io/gh/swatarianess/banking_assignment/branch/master/graph/badge.svg)](https://codecov.io/gh/swatarianess/banking_assignment)[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=swatarianess_banking_assignment&metric=alert_status)](https://sonarcloud.io/dashboard?id=swatarianess_banking_assignment)


Example of a banking web-application using spring-boot.

# Requirements:
* Gradle
* Java 8+

# How to Setup:
To start the Spring-boot server run the command in terminal/console:
<pre><code> ./gradlew bootRun </code></pre>

# How to interact with the application:
## Accounts
**Create a new account:**

POST-Request ~ `localhost:8083\accounts\`
* json file elements:
  * `accountID` (Required) - The customerID to open with the new account
  * `name` (Required) - First name of the customer
  * `surname` (optional) - Surname of the customer
  * `balance` (optional) - Initial opening balance of the customer

Retrieving Account information:

GET-Request ~ `localhost:8083\accounts\`
* parameters:
  * `accountID` (Required) - The customerID of the account holder
  
Retrieving all customers:
GET-Request ~ `localhost:8083\accounts\`

## Transactions
Create a new transaction:

POST-Request  ~ `localhost:8083\transactions\`
* json file elements:
  * `accountID` (Required) - The customerID to open with the new account
  * `name` (Required) - First name of the customer
  * `surname` (optional) - Surname of the customer
  * `balance` (optional) - Initial opening balance of the customer

**Retrieving transaction information:**
GET-Request  ~ `localhost:8083\transactions\{transactionID}`
* parameters:
  * `accountID` (Required) - The customerID of the account holder
  
**Retrieving all transactions:**
GET-Request ~ `localhost:8083\transactions\`
