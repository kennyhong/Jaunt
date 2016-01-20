@echo off

call SetClasspath

REM The following lines will restore the original database from the original script
REM The sample project doesn't require this, but yours might

REM cd database
REM call RestoreDB.bat
REM cd ..

@echo on

java junit.textui.TestRunner comp3350.tests.RunIntegrationTests 1> IntegrationTests.txt