## Setup Instructions

#### 1. Clone the project.

    cd ~/git
    git clone git@github.com:hacker-works/fsh.dirty-code.wst.01.git
    cd fsh.dirty-code.wst.01
    git pull --all
    git checkout feature/dirty-code

#### 2. Start the Java server.

    cd ~/git/fsh.dirty-code.wst.01/server
    mvn clean compile
    mvn -Djetty.port=8680 jetty:run

#### 3. Import the project into Eclipse or IntelliJ, or any editor or IDE you're used working with.

**NOTE:** If something is not working as expected, or gives compile or configuration issues, you should fix it. 

#### 4. Start hacking! 

> **WARNING:** What you're about to see is a very dirty and messy piece of code. This is intentionally prepared this way. This is not the hacker's way! We have a clean version of this code to prove it. 

## Test Objectives

The objective of this work sample test is to clean this dirty code:

* resolve all code issues you can find
* apply coding and design principles and maxims such as DRY and SOLID
* identify and resolve design issues
* resolve anything that you find wrong with this code 
* **BIG** bonus points for adding tests
* we expect from you to keep in touch during your work on the test sample and we will be happy to answer any questions you might have
* pay attention to the comments in the code - you're not expected to work on the sections marked with *IGNORE*. On the other hand the sections marked with *TODO* are important part of the test
* we expect we would be able to run your solution and be able to execute the following REST calls: 
  * GET - ```order/{shopper-id}``` to create/retriece an order for a shopper
  * GET - ```order/{shopper-id}/price``` to get the total price of an order
  * PUT - ```order/{shopper-id}``` to place a shoe pair to an order

Keep in mind, we're not imposing any restrictions on keeping the functionality, method interfaces, dependencies, etc. Feel free to upgrade to Java 8 and update the project dependencies and configuration as you wish. 

Be creative! Take your time.
