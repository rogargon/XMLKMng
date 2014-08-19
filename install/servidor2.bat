@echo off
SET BASIC_LIBS = 
SET BROKER_HOME = 
SET VISIBROKER_LIBS = 

java -cp xmlkmngSrv.jar;lib\xerces.jar;lib\xml4j.jar;lib\xml_swing11.jar;lib\icebrowserlitebean.jar;lib\xalan.jar;lib\bsf.jar;corba\VBJAPP.JAR;corba\VBJCOSNM.JAR;corba\VBJORB.JAR;corba\VBJTOOLS.JAR kxml.XML_KServer


