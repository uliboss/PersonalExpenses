# Personal Expenses Web Application

Personal expenses web application based on Spring Boot, Spring data JPA, Maven and H2 in-memory database.


## Contents

1. [Features](#features)
2. [Requirements](#requirements)
3. [How to run the application](#how-to-run-the-application)
4. [POST query example](#post-query-example)


## Features

* Based on Spring boot, Spring data JPA, Maven and H2 in-memory database
* Has following API:
  * `POST` http query — adds expense entry to the list. Endpoint accepts JSON with the following data: `date, amount, currency, product` 
  * `GET` http query — shows the list of all expenses `grouped and sorted by date`
  * `DELETE` http query — removes all expenses for specified date, where: `date` - is the date for which all expenses should be removed
  * `GET` http query — shows the list of total amount of spent money converted and calculated to specified currency by online converter and presents it in specified currency, where `base` - is the currency in which total amount of expenses should be presented
  * Input validation of `currency` and `amount` fields
  * Spring MVC with Service layer and DTO pattern
  * Unit tests


## Requirements

For building and running the application you need:
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)


## How to run the application

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.info.personalexpensesapp` class from your IDE.

Alternatively, you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

For HTTP queries you can use [Postman](https://www.postman.com/downloads/).


## POST query example:
```
{
"date": "2020-11-02",
"amount": "30",
"currency": "UAH",
"product": "Oranges"
}
```



