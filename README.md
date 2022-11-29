
#E2E Insurance Sample Project

___

## Overview:
This is a sample testing framework with Selenium
and TestNG. The test included in the project was to simply 
choose a desired destination, dates of travel and to verify that
we indeed arrive at the desired end URL. 

All Selenium methods are wrapped in the Base Page and automatically
include a default explicit wait for 10 seconds. The user has
the ability to change this per page object by changing the "timeout"
field using a Setter. 

Although it is not completely necessary for this exercise, 
in the CalendarPage class I have demostrated how one may use method
chaining in order to perform a few functions at once. 

I have chosen to use the Factory design pattern to manage the drivers
used in the project. Even though I am only performing one test using 
Chrome, this framework is already scalable for the possibility
of testing other browsers. 