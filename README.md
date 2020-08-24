# Banking Assignment [![Build Status](https://travis-ci.com/swatarianess/banking_assignment.svg?branch=master)](https://travis-ci.com/swatarianess/banking_assignment)
Example of a banking web-application using spring-boot.

## How to use:
Create a new customer:
`localhost:8083\customer\register`
* parameters:
  * `name` - First name of the customer
  * `surname` - Surname of the customer
  * `balance` - Initial opening balance of the customer

Retrieving customer information:
`localhost:8083\customer\{customerID}`

Retrieving all customers:
`localhost:8083\customer\all`
