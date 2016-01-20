@echo off

REM
REM This script requires that the "javac" command be on the system command path.
REM This can be accomplished by removing the "REM" from the path statement below
REM and modifying it to include "C:\Program Files\Java\jdk1.7.0_60\bin" (or whatever
REM your path is).
REM
REM Alternatively, you could add the path to "javac" to the PATH Environment variable: 
REM   Settings-->Control Panel-->System-->Advanced-->Environment Variables-->Path
REM

path "C:\Program Files\Java\jdk1.8.0_45\bin";%PATH%

REM create classes folder if it does not already exist

if not exist bin md bin
if not exist bin\classes md bin\classes

REM clean all .class files out of the bin directory

cd bin\classes
erase /S /Q *.class
cd ..\..

call SetClasspath

@echo on

javac -d bin\classes -cp %classpath% src\comp3350\jaunt\objects\*.java src\comp3350\jaunt\persistence\*.java src\comp3350\jaunt\application\*.java src\comp3350\jaunt\business\*.java
pause

javac -d bin\classes -cp %classpath% src\comp3350\tests\objects\*.java src\comp3350\tests\business\*.java src\comp3350\tests\persistence\*.java src\comp3350\tests\integration\*.java src\comp3350\tests\RunUnitTests.java src\comp3350\tests\RunIntegrationTests.java

 pause