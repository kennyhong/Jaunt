package comp3350.tests.acceptance;

import junit.framework.Assert;

import com.robotium.solo.Solo;

import comp3350.jaunt.presentation.ActivityHome;
import android.test.ActivityInstrumentationTestCase2;

public class SaveGameTest extends ActivityInstrumentationTestCase2<ActivityHome>
{
	private Solo solo;
	
	public SaveGameTest()
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
	
	public void testSaveGame()
	{
		solo.waitForActivity("ActivityHome");
		solo.clickOnButton("New Game");
		solo.waitForActivity("ActivityGame");
		solo.assertCurrentActivity("Expected activity ActivityGame", "ActivityGame");
		
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("You are in the busy streets of Osbourne, what do you do?"));
		Assert.assertEquals(true, solo.searchText("Go to the Bar"));
		Assert.assertEquals(true, solo.searchText("Get food"));
		solo.clickOnMenuItem("Save Game");
		
		solo.clickOnButton("Continue");
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
		solo.clickOnMenuItem("Save Game");
		
		solo.clickOnButton("Continue");
		solo.waitForActivity("ActivityGame");
		solo.assertCurrentActivity("Expected activity ActivityGame", "ActivityGame");
		
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
		solo.clickOnMenuItem("Save Game");
		
		solo.clickOnButton("Continue");
		solo.waitForActivity("ActivityGame");
		solo.assertCurrentActivity("Expected activity ActivityGame", "ActivityGame");
		
		solo.clickOnButton("Game Over.");
		solo.assertCurrentActivity("Expected activity ActivityGameOver", "ActivityGameOver");
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe"));
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Counter"));
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Girl"));
		Assert.assertEquals(true, solo.searchText("Return to Home Page"));
		Assert.assertEquals(true, solo.searchText("Restart Game"));
		
		solo.clickOnButton("Return to Home Page");
		solo.waitForActivity("ActivityHome");
		solo.assertCurrentActivity("Expected activity ActivityHome", "ActivityHome");
	}
}