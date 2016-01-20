Packages and major source code files:
-------------------------------------

comp3350.jaunt.application
- Main.java
- Services.java				
comp3350.jaunt.business
- AccessSaveData.java 		
- AccessStoryPoints.java 	
comp3350.jaunt.objects
- Save.java 				
- StoryPoint.java			
comp3350.jaunt.persistence
- DataAccess.java			
- DataAccessObject.java		
comp3350.jaunt.presentation
- ActivityGame.java
- ActivityGameOver.java
- ActivityGlossary.java
- ActivityHome.java
- DialogSettings.java
- Messages.java
comp3350.tests
- RunAcceptanceTests.java
- RunIntegrationTests.java
- RunUnitTests.java
comp3350.tests.acceptance
- RunAcceptanceTests.java
- GlossaryTest.java
- SaveGameTest.java
- SettingsTest.java
- StoryGameTest.java
comp3350.tests.business
- AccessSaveDataTest.java
- AccessStoryPointsTest.java
- BusinessTests.java
comp3350.tests.integration
- BusinessPersistenceSeamTest.java
- DataAccessHSQLDBTest.java
- IntegrationTests.java
comp3350.tests.objects
- ObjectTests.java
- StoryPointTest.java
- SaveTest.java
comp3350.tests.persistence
- DataAccessTest.java
- DataAccessStub.java
- PersistenceTests.java

	For iteration 3 some new features were added as well as many bug fixes. 
	- All tests have been completed and passed. 
	- We have added a glossary page to see all the points you are able to access within the game.
	- Any bugs related to music when playing the game has been fixed. 
	- Saving the game has been fixed where the save did not overwrite when there was already a save file in the database.
	- Adding night mode settings
	- Beautified the final product.
	
	The MediaPlayer error is caused by a problem with android itself, the media player does not check if it is using video or music
	and therefore reminds you that there is no subtitle controller set even though it does not make sense to for music.
	