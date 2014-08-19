@echo off
set LIBSHOME=lib
set LIBS=%LIBSHOME%\xerces.jar;%LIBSHOME%\xml4j.jar;%LIBSHOME%\xml_swing11.jar;%LIBSHOME%\xalan.jar;%LIBSHOME%\bsf.jar;%LIBSHOME%\icebrowserlitebean.jar
set CORBAHOME=corba
set VISIBROKERLIBS=%CORBAHOME%\VBJCOSNM.JAR;%CORBAHOME%\VBJORB.JAR;%CORBAHOME%\VBJAPP.JAR;%CORBAHOME%\VBJTOOLS.JAR

java -cp xmlkmngSrv.jar;%LIBS%;%VISIBROKERLIBS% kxml.XML_KServer


