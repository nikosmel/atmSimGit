# atmSimGit

## Backend Developer Test – ATM Simulation			

The application has been written in Java.

Command line App

JDK 1.8.0

Junit 4 for testing 

Maven

### Instructions on how to build and run the application.

This test was developed in mac os and Intellij IDEA was used.

To run the application you can download the atmSim.jar file and run the application using terminal.
Navigate to the downloads folder and run “java -jar atmSim.jar” .

The application has started ... 

The next message has appeared and wait for the user input .

“Please insert the number of the available 20 notes : “ 

“Please insert the number of the available 50 notes : “

After that the ATM has initialised and it’s ready for the next actions.

-------------  ATM SIMULATOR -------- 

Select option:
 1. Cash withdrawal
 2. View available notes
 3. Exit

…

In case you need to build the application again:

-checkout the project 

-open source folder as maven project

-edit run/debug configurations and run or build the application .

### About the code .
In order to complete the assignment i tried to keep the source code as simple as possible.
The application has the main services (AtmService,InputService and WithdrawService)
that implement the core functionality as is the initialisation of the Atm and the functions 
that get the inputs from the user and execute the desired options.
Services are independent of the available notes in case it is needed to add or remove extra note types.
Model package contains the Atm class which follows the singleton pattern in order
to initialise the atm once and the NoteEnum that helps to keep code more generic.
This project was developed following the Test Driven Development approach 
and in the test package you can find the corresponding test classes.
Test classes cover the most of the main functions but not all of them.
This project could implement more utilities like adding a database to manage 
the atm properties so as to make changes using transactions and more tools like 
log4j logger to keep logs, but i decided that it wasn’t necessary at this time.



If more details are required,feel free to contact me.

email : meletiou.nikos1@gmail.com	
phone : 6982067745  



