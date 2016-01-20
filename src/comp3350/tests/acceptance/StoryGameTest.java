package comp3350.tests.acceptance;

import junit.framework.Assert;

import com.robotium.solo.Solo;

import comp3350.jaunt.presentation.ActivityHome;
import android.test.ActivityInstrumentationTestCase2;

public class StoryGameTest extends ActivityInstrumentationTestCase2<ActivityHome>
{
	private Solo solo;
	
	public StoryGameTest()
	{
		super(ActivityHome.class);
	}
	
	public void setUp() throws Exception
	{
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	@Override
	public void tearDown() throws Exception
	{
		solo.finishOpenedActivities();
	}
	
	public void testPath1()
	{
		solo.waitForActivity("ActivityHome");
		solo.clickOnButton("New Game");
		solo.waitForActivity("ActivityGame");
		solo.assertCurrentActivity("Expected activity ActivityGame", "ActivityGame");
		
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("You are in the busy streets of Osbourne, what do you do?"));
		Assert.assertEquals(true, solo.searchText("Go to the Bar"));
		Assert.assertEquals(true, solo.searchText("Get food"));
		
		solo.clickOnButton("Get food");
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe"));
		Assert.assertEquals(true, solo.searchText("You order crepe to celebrate your first day off in weeks."));
		Assert.assertEquals(true, solo.searchText("Eat in"));
		Assert.assertEquals(true, solo.searchText("Take out"));
		
		solo.clickOnButton("Eat in");
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Counter"));
		Assert.assertEquals(true, solo.searchText("You decide to eat in and enjoy the view of a beautiful woman"));
		Assert.assertEquals(true, solo.searchText("Talk to Girl"));
		Assert.assertEquals(true, solo.searchText("Ignore the girl"));
		
		solo.clickOnButton("Talk to Girl");
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Girl"));
		Assert.assertEquals(true, solo.searchText("Game Over: You meet a lady and decide to chat with her, you get turned down"));
		Assert.assertEquals(true, solo.searchText("Game Over."));
		
		solo.clickOnButton("Game Over.");
		solo.assertCurrentActivity("Expected activity ActivityGameOver", "ActivityGameOver");
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe"));
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Counter"));
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Girl"));
		Assert.assertEquals(true, solo.searchText("Return to Home Page"));
		Assert.assertEquals(true, solo.searchText("Restart Game"));
		
		solo.clickOnButton("Restart Game");
		solo.waitForActivity("ActivityGame");
		solo.assertCurrentActivity("Expected activity ActivityGame", "ActivityGame");
		
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("You are in the busy streets of Osbourne, what do you do?"));
		Assert.assertEquals(true, solo.searchText("Go to the Bar"));
		Assert.assertEquals(true, solo.searchText("Get food"));
		
		solo.clickOnButton("Get food");
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe"));
		Assert.assertEquals(true, solo.searchText("You order crepe to celebrate your first day off in weeks."));
		Assert.assertEquals(true, solo.searchText("Eat in"));
		Assert.assertEquals(true, solo.searchText("Take out"));
		
		solo.clickOnButton("Eat in");
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Counter"));
		Assert.assertEquals(true, solo.searchText("You decide to eat in and enjoy the view of a beautiful woman"));
		Assert.assertEquals(true, solo.searchText("Talk to Girl"));
		Assert.assertEquals(true, solo.searchText("Ignore the girl"));
		
		solo.clickOnButton("Ignore the girl");
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Loner"));
		Assert.assertEquals(true, solo.searchText("Game Over: You stay quiet and continue eating. You spend the rest of your life alone."));
		Assert.assertEquals(true, solo.searchText("Game Over."));
		
		solo.clickOnButton("Game Over.");
		solo.waitForActivity("ActivityGameOver");
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe"));
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Counter"));
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Loner"));
		Assert.assertEquals(true, solo.searchText("Return to Home Page"));
		Assert.assertEquals(true, solo.searchText("Restart Game"));
		
		solo.clickOnButton("Return to Home Page");
		solo.waitForActivity("ActivityHome");
		solo.assertCurrentActivity("Expected activity ActivityHome", "ActivityHome");
	}
	
	public void testPath2()
	{
		solo.waitForActivity("ActivityHome");
		solo.clickOnButton("New Game");
		solo.waitForActivity("ActivityGame");
		solo.assertCurrentActivity("Expected activity ActivityGame", "ActivityGame");
		
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("You are in the busy streets of Osbourne, what do you do?"));
		Assert.assertEquals(true, solo.searchText("Go to the Bar"));
		Assert.assertEquals(true, solo.searchText("Get food"));
		
		solo.clickOnButton("Get food");
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe"));
		Assert.assertEquals(true, solo.searchText("You order crepe to celebrate your first day off in weeks."));
		Assert.assertEquals(true, solo.searchText("Eat in"));
		Assert.assertEquals(true, solo.searchText("Take out"));
		
		solo.clickOnButton("Take out");
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Exit"));
		Assert.assertEquals(true, solo.searchText("You decide to take out and eat at home"));
		Assert.assertEquals(true, solo.searchText("Go Downtown"));
		Assert.assertEquals(true, solo.searchText("Drive home"));
		
		solo.clickOnButton("Go Downtown");
		Assert.assertEquals(true, solo.searchText("The Cube - Music"));
		Assert.assertEquals(true, solo.searchText("Game Over: You listen to the live music at the cube and enjoy it."));
		Assert.assertEquals(true, solo.searchText("Game Over."));
		
		solo.clickOnButton("Game Over.");
		solo.waitForActivity("ActivityGameOver");
		solo.assertCurrentActivity("Expected activity ActivityGameOver", "ActivityGameOver");
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe"));
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Exit"));
		Assert.assertEquals(true, solo.searchText("The Cube - Music"));
		Assert.assertEquals(true, solo.searchText("Return to Home Page"));
		Assert.assertEquals(true, solo.searchText("Restart Game"));
		
		solo.clickOnButton("Restart Game");
		solo.waitForActivity("ActivityGame");
		solo.assertCurrentActivity("Expected activity ActivityGame", "ActivityGame");
		
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("You are in the busy streets of Osbourne, what do you do?"));
		Assert.assertEquals(true, solo.searchText("Go to the Bar"));
		Assert.assertEquals(true, solo.searchText("Get food"));
		
		solo.clickOnButton("Get food");
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe"));
		Assert.assertEquals(true, solo.searchText("You order crepe to celebrate your first day off in weeks."));
		Assert.assertEquals(true, solo.searchText("Eat in"));
		Assert.assertEquals(true, solo.searchText("Take out"));
		
		solo.clickOnButton("Take out");
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Exit"));
		Assert.assertEquals(true, solo.searchText("You decide to take out and eat at home"));
		Assert.assertEquals(true, solo.searchText("Go Downtown"));
		Assert.assertEquals(true, solo.searchText("Drive home"));
		
		solo.clickOnButton("Drive home");
		Assert.assertEquals(true, solo.searchText("Home - Netflix"));
		Assert.assertEquals(true, solo.searchText("Game Over: You decide to watch Netflix at home and end your night, little did you know, it was all a dream."));
		Assert.assertEquals(true, solo.searchText("Game Over."));
		
		solo.clickOnButton("Game Over.");
		solo.waitForActivity("ActivityGameOver");
		solo.assertCurrentActivity("Expected activity ActivityGameOver", "ActivityGameOver");
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe"));
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Exit"));
		Assert.assertEquals(true, solo.searchText("Home - Netflix"));
		Assert.assertEquals(true, solo.searchText("Return to Home Page"));
		Assert.assertEquals(true, solo.searchText("Restart Game"));
		
		solo.clickOnButton("Return to Home Page");
		solo.waitForActivity("ActivityHome");
		solo.assertCurrentActivity("Expected activity ActivityHome", "ActivityHome");
	}
	
	public void testPath3()
	{
		solo.waitForActivity("ActivityHome");
		solo.clickOnButton("New Game");
		solo.waitForActivity("ActivityGame");
		solo.assertCurrentActivity("Expected activity ActivityGame", "ActivityGame");
		
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("You are in the busy streets of Osbourne, what do you do?"));
		Assert.assertEquals(true, solo.searchText("Go to the Bar"));
		Assert.assertEquals(true, solo.searchText("Get food"));
		
		solo.clickOnButton("Go to the Bar");
		Assert.assertEquals(true, solo.searchText("The Toad"));
		Assert.assertEquals(true, solo.searchText("You arrive at The Toad and your favourite band is playing"));
		Assert.assertEquals(true, solo.searchText("Drink"));
		Assert.assertEquals(true, solo.searchText("Drive home"));
		
		solo.clickOnButton("Drink");
		Assert.assertEquals(true, solo.searchText("The Toad - Bar"));
		Assert.assertEquals(true, solo.searchText("It's your day off, you decide to relax"));
		Assert.assertEquals(true, solo.searchText("Listen to Band"));
		Assert.assertEquals(true, solo.searchText("Drink more"));
		
		solo.clickOnButton("Listen to Band");
		Assert.assertEquals(true, solo.searchText("The Toad - Band"));
		Assert.assertEquals(true, solo.searchText("Game Over: As you grab your drink you realize your friend's band is playing and decide to chill with him for the rest of the night."));
		Assert.assertEquals(true, solo.searchText("Game Over."));
		
		solo.clickOnButton("Game Over.");
		solo.waitForActivity("ActivityGameOver");
		solo.assertCurrentActivity("Expected activity ActivityGameOver", "ActivityGameOver");
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("The Toad"));
		Assert.assertEquals(true, solo.searchText("The Toad - Bar"));
		Assert.assertEquals(true, solo.searchText("The Toad - Band"));
		Assert.assertEquals(true, solo.searchText("Return to Home Page"));
		Assert.assertEquals(true, solo.searchText("Restart Game"));
		
		solo.clickOnButton("Restart Game");
		solo.waitForActivity("ActivityGame");
		solo.assertCurrentActivity("Expected activity ActivityGame", "ActivityGame");
		
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("You are in the busy streets of Osbourne, what do you do?"));
		Assert.assertEquals(true, solo.searchText("Go to the Bar"));
		Assert.assertEquals(true, solo.searchText("Get food"));
		
		solo.clickOnButton("Go to the Bar");
		Assert.assertEquals(true, solo.searchText("The Toad"));
		Assert.assertEquals(true, solo.searchText("You arrive at The Toad and your favourite band is playing"));
		Assert.assertEquals(true, solo.searchText("Drink"));
		Assert.assertEquals(true, solo.searchText("Drive home"));
		
		solo.clickOnButton("Drink");
		Assert.assertEquals(true, solo.searchText("The Toad - Bar"));
		Assert.assertEquals(true, solo.searchText("It's your day off, you decide to relax"));
		Assert.assertEquals(true, solo.searchText("Listen to Band"));
		Assert.assertEquals(true, solo.searchText("Drink more"));
		
		solo.clickOnButton("Drink more");
		Assert.assertEquals(true, solo.searchText("The Toad - More Drinks"));
		Assert.assertEquals(true, solo.searchText("Game Over: You ignore your surroundings and start drinking liquor like water. You are Drunk"));
		Assert.assertEquals(true, solo.searchText("Game Over."));
		
		solo.clickOnButton("Game Over.");
		solo.waitForActivity("ActivityGameOver");
		solo.assertCurrentActivity("Expected activity ActivityGameOver", "ActivityGameOver");
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("The Toad"));
		Assert.assertEquals(true, solo.searchText("The Toad - Bar"));
		Assert.assertEquals(true, solo.searchText("The Toad - More Drinks"));
		Assert.assertEquals(true, solo.searchText("Return to Home Page"));
		Assert.assertEquals(true, solo.searchText("Restart Game"));
		
		solo.clickOnButton("Return to Home Page");
		solo.waitForActivity("ActivityHome");
		solo.assertCurrentActivity("Expected activity ActivityHome", "ActivityHome");
	}
	
	public void testPath4()
	{
		solo.waitForActivity("ActivityHome");
		solo.clickOnButton("New Game");
		solo.waitForActivity("ActivityGame");
		solo.assertCurrentActivity("Expected activity ActivityGame", "ActivityGame");
		
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("You are in the busy streets of Osbourne, what do you do?"));
		Assert.assertEquals(true, solo.searchText("Go to the Bar"));
		Assert.assertEquals(true, solo.searchText("Get food"));
		
		solo.clickOnButton("Go to the Bar");
		Assert.assertEquals(true, solo.searchText("The Toad"));
		Assert.assertEquals(true, solo.searchText("You arrive at The Toad and your favourite band is playing"));
		Assert.assertEquals(true, solo.searchText("Drink"));
		Assert.assertEquals(true, solo.searchText("Drive home"));
		
		solo.clickOnButton("Drive home");
		Assert.assertEquals(true, solo.searchText("The Toad - Exit"));
		Assert.assertEquals(true, solo.searchText("It's your day off, you don't feel like drinking"));
		Assert.assertEquals(true, solo.searchText("Go Home"));
		Assert.assertEquals(true, solo.searchText("Watch a movie"));
		
		solo.clickOnButton("Go Home");
		Assert.assertEquals(true, solo.searchText("Home"));
		Assert.assertEquals(true, solo.searchText("Game Over: You decide to go to bed"));
		Assert.assertEquals(true, solo.searchText("Game Over."));
		
		solo.clickOnButton("Game Over.");
		solo.waitForActivity("ActivityGameOver");
		solo.assertCurrentActivity("Expected activity ActivityGameOver", "ActivityGameOver");
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("The Toad"));
		Assert.assertEquals(true, solo.searchText("The Toad - Exit"));
		Assert.assertEquals(true, solo.searchText("Home"));
		Assert.assertEquals(true, solo.searchText("Return to Home Page"));
		Assert.assertEquals(true, solo.searchText("Restart Game"));

		solo.clickOnButton("Restart Game");
		solo.waitForActivity("ActivityGame");
		solo.assertCurrentActivity("Expected activity ActivityGame", "ActivityGame");
		
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("You are in the busy streets of Osbourne, what do you do?"));
		Assert.assertEquals(true, solo.searchText("Go to the Bar"));
		Assert.assertEquals(true, solo.searchText("Get food"));
		
		solo.clickOnButton("Go to the Bar");
		Assert.assertEquals(true, solo.searchText("The Toad"));
		Assert.assertEquals(true, solo.searchText("You arrive at The Toad and your favourite band is playing"));
		Assert.assertEquals(true, solo.searchText("Drink"));
		Assert.assertEquals(true, solo.searchText("Drive home"));
		
		solo.clickOnButton("Drive home");
		Assert.assertEquals(true, solo.searchText("The Toad - Exit"));
		Assert.assertEquals(true, solo.searchText("It's your day off, you don't feel like drinking"));
		Assert.assertEquals(true, solo.searchText("Go Home"));
		Assert.assertEquals(true, solo.searchText("Watch a movie"));
		
		solo.clickOnButton("Watch a movie");
		Assert.assertEquals(true, solo.searchText("Theatre"));
		Assert.assertEquals(true, solo.searchText("Game Over: You decide to watch a movie and end your night."));
		Assert.assertEquals(true, solo.searchText("Game Over."));
		
		solo.clickOnButton("Game Over.");
		solo.waitForActivity("ActivityGameOver");
		solo.assertCurrentActivity("Expected activity ActivityGameOver", "ActivityGameOver");
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("The Toad"));
		Assert.assertEquals(true, solo.searchText("The Toad - Exit"));
		Assert.assertEquals(true, solo.searchText("Theatre"));
		Assert.assertEquals(true, solo.searchText("Return to Home Page"));
		Assert.assertEquals(true, solo.searchText("Restart Game"));

		solo.clickOnButton("Return to Home Page");
		solo.waitForActivity("ActivityHome");
		solo.assertCurrentActivity("Expected activity ActivityHome", "ActivityHome");
	}
}