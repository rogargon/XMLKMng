@echo off
set LIBSHOME=..\lib
set LIBS=%LIBSHOME%\SiRPAC.jar;%LIBSHOME%\xml4j.jar;%LIBSHOME%\SiLRI.jar
java -cp .;%LIBS% edu.unika.aifb.rdfie.SiLRI -rdf research-ontology-schema.xml -rdf archiveRDF.xml %1 base.rule 