@echo off

REM This file sets the common classpath shared between the compile and run
REM batch files.

@echo on

set CLASSPATH=.;bin\classes;lib\junit.jar;lib\hsqldb.jar;lib\robotium-solo-5.3.1.jar;lib\android-support-v4.jar
