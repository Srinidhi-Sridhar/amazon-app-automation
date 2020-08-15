Appium Frame Work Description

Have used Page Object Model FW to achieve the required results.


utilityfunctions: LogManager,Page,AppiumManager ,Automation Constants. 

Appium Manager : Used to start Appium Server on local machine depending up on the platform and Desired capabilities mentioned in the androidTestData .properties 
LogManager:Wrapper methods to achieve logging 

Page: common methods for click ,send keys , scroll to a text , take screenshot etc
ReadProperties :Reading data from property file globalProperties.properties: consists of all the required test data such as user name ,password .


extent Reporting:Class that used to start and stop extent reporting 
log4j:is ued to achieve the logging 
testNg.xml:Used to specify which test that needs to be run


Pages :Include all the Page objects that will encounter during test

