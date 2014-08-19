@echo off
set LIBSHOME=..\lib
set LIBS=%LIBSHOME%\SiRPAC.jar;%LIBSHOME%\xml4j.jar;%LIBSHOME%\SiLRI.jar
javaw -cp .;%LIBS% kxml.search.Searcher
exit