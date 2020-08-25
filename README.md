# Banking Assignment [![Build Status](https://travis-ci.com/swatarianess/banking_assignment.svg?branch=master)](https://travis-ci.com/swatarianess/banking_assignment)
Example of a banking web-application using spring-boot.

## How to use:
Create a new customer:
`localhost:8083\customer\register`
* parameters:
  * `accountID` (Required) - The customerID to open with the new account
  * `name` (Required) - First name of the customer
  * `surname` (optional) - Surname of the customer
  * `balance` (optional) - Initial opening balance of the customer

Retrieving customer information:
`localhost:8083\customer\{customerID}`

Retrieving all customers:
`localhost:8083\customer\all`
