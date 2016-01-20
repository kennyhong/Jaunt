This database file is designed to be used with HSQLDB 1.8, the same version
distributed with the sample project. It is recommended that you use this
version.

Use the RunHSQLDB.bat script to view the database contents locally on your
desktop computer. Note that the script file is just text - HSQLDB saves your
database as a sequence of SQL statements, and re-executes them when opening the
database - so you can view and edit the database as a text file too.

The actual database file that will be copied to (and used by) your Android app
is located in the "assets/db" folder. Any edits that you make here must be
copied into that assets folder before your app will see them. The Android app
then copies this file into its local (writable) storage on first launch. In
order to see an updated database in your app, you must first either delete the
app from the Launcher on the device/emulator (which deletes its data), or use
DDMS to navigate to the data file location on the device and delete the script
file there (which will force it to be re-copied on next launch).
