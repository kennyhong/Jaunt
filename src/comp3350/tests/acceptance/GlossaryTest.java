package comp3350.tests.acceptance;

import junit.framework.Assert;

import com.robotium.solo.Solo;

import comp3350.jaunt.presentation.ActivityHome;
import android.test.ActivityInstrumentationTestCase2;

public class GlossaryTest extends ActivityInstrumentationTestCase2<ActivityHome>
{
	private Solo solo;
	
	public GlossaryTest()
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
	
	public void testAllGlossary()
	{
		solo.waitForActivity("ActivityHome");
		solo.clickOnButton("Glossary");
		solo.waitForActivity("ActivityGlossary");
		solo.assertCurrentActivity("Expected activity ActivityGlossary", "ActivityGlossary");
		
		Assert.assertEquals(true, solo.searchText("0    City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("1    The Toad"));
		Assert.assertEquals(true, solo.searchText("2    Kawaii Crepe"));
		Assert.assertEquals(true, solo.searchText("3    The Toad - Bar"));
		Assert.assertEquals(true, solo.searchText("4    The Toad - Exit"));
		Assert.assertEquals(true, solo.searchText("5    Kawaii Crepe - Counter"));
		Assert.assertEquals(true, solo.searchText("6    Kawaii Crepe - Exit"));
		Assert.assertEquals(true, solo.searchText("7    The Toad - Band"));
		Assert.assertEquals(true, solo.searchText("8    The Toad - More Drinks"));
		Assert.assertEquals(true, solo.searchText("9    Home"));
		
		solo.scrollDown();
		
		Assert.assertEquals(true, solo.searchText("10   Theatre"));
		Assert.assertEquals(true, solo.searchText("11   Kawaii Crepe - Girl"));
		Assert.assertEquals(true, solo.searchText("12   Kawaii Crepe - Loner"));
		Assert.assertEquals(true, solo.searchText("13   The Cube - Music"));
		Assert.assertEquals(true, solo.searchText("14   Home - Netflix"));
		
		solo.scrollUp();
		
		solo.clickOnButton("0    City of Winnipeg");
		Assert.assertEquals(true, solo.searchText("City of Winnipeg"));
		Assert.assertEquals(true, solo.searchText("You are in the busy streets of Osbourne, what do you do?"));
		Assert.assertEquals(true, solo.searchText("Back"));
		solo.clickOnButton("Back");
		
		solo.clickOnButton("1    The Toad");
		Assert.assertEquals(true, solo.searchText("The Toad"));
		Assert.assertEquals(true, solo.searchText("You arrive at The Toad and your favourite band is playing"));
		Assert.assertEquals(true, solo.searchText("Back"));
		solo.clickOnButton("Back");
		
		solo.clickOnButton("2    Kawaii Crepe");
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe"));
		Assert.assertEquals(true, solo.searchText("You order crepe to celebrate your first day off in weeks."));
		Assert.assertEquals(true, solo.searchText("Back"));
		solo.clickOnButton("Back");
		
		solo.clickOnButton("3    The Toad - Bar");
		Assert.assertEquals(true, solo.searchText("The Toad - Bar"));
		Assert.assertEquals(true, solo.searchText("It's your day off, you decide to relax"));
		Assert.assertEquals(true, solo.searchText("Back"));
		solo.clickOnButton("Back");
		
		solo.clickOnButton("4    The Toad - Exit");
		Assert.assertEquals(true, solo.searchText("The Toad - Exit"));
		Assert.assertEquals(true, solo.searchText("It's your day off, you don't feel like drinking"));
		Assert.assertEquals(true, solo.searchText("Back"));
		solo.clickOnButton("Back");
		
		solo.clickOnButton("5    Kawaii Crepe - Counter");
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Counter"));
		Assert.assertEquals(true, solo.searchText("You decide to eat in and enjoy the view of a beautiful woman"));
		Assert.assertEquals(true, solo.searchText("Back"));
		solo.clickOnButton("Back");
		
		solo.clickOnButton("6    Kawaii Crepe - Exit");
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Exit"));
		Assert.assertEquals(true, solo.searchText("You decide to take out and eat at home"));
		Assert.assertEquals(true, solo.searchText("Back"));
		solo.clickOnButton("Back");
		
		solo.clickOnButton("7    The Toad - Band");
		Assert.assertEquals(true, solo.searchText("The Toad - Band"));
		Assert.assertEquals(true, solo.searchText("Game Over: As you grab your drink you realize your friend's band is playing and decide to chill with him for the rest of the night."));
		Assert.assertEquals(true, solo.searchText("Back"));
		solo.clickOnButton("Back");
		
		solo.clickOnButton("8    The Toad - More Drinks");
		Assert.assertEquals(true, solo.searchText("The Toad - More Drinks"));
		Assert.assertEquals(true, solo.searchText("Game Over: You ignore your surroundings and start drinking liquor like water. You are Drunk"));
		Assert.assertEquals(true, solo.searchText("Back"));
		solo.clickOnButton("Back");
		
		solo.clickOnButton("9    Home");
		Assert.assertEquals(true, solo.searchText("Home"));
		Assert.assertEquals(true, solo.searchText("Game Over: You decide to go to bed"));
		Assert.assertEquals(true, solo.searchText("Back"));
		solo.clickOnButton("Back");
		
		solo.scrollDown();
		
		solo.clickOnButton("10   Theatre");
		Assert.assertEquals(true, solo.searchText("Theatre"));
		Assert.assertEquals(true, solo.searchText("Game Over: You decide to watch a movie and end your night."));
		Assert.assertEquals(true, solo.searchText("Back"));
		solo.clickOnButton("Back");
		
		solo.clickOnButton("11   Kawaii Crepe - Girl");
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Girl"));
		Assert.assertEquals(true, solo.searchText("Game Over: You meet a lady and decide to chat with her, you get turned down"));
		Assert.assertEquals(true, solo.searchText("Back"));
		solo.clickOnButton("Back");
		
		solo.clickOnButton("12   Kawaii Crepe - Loner");
		Assert.assertEquals(true, solo.searchText("Kawaii Crepe - Loner"));
		Assert.assertEquals(true, solo.searchText("Game Over: You stay quiet and continue eating. You spend the rest of your life alone."));
		Assert.assertEquals(true, solo.searchText("Back"));
		solo.clickOnButton("Back");
		
		solo.clickOnButton("13   The Cube - Music");
		Assert.assertEquals(true, solo.searchText("The Cube - Music"));
		Assert.assertEquals(true, solo.searchText("Game Over: You listen to the live music at the cube and enjoy it."));
		Assert.assertEquals(true, solo.searchText("Back"));
		solo.clickOnButton("Back");
		
		solo.clickOnButton("14   Home - Netflix");
		Assert.assertEquals(true, solo.searchText("Home - Netflix"));
		Assert.assertEquals(true, solo.searchText("Game Over: You decide to watch Netflix at home and end your night, little did you know, it was all a dream."));
		Assert.assertEquals(true, solo.searchText("Back"));
		solo.clickOnButton("Back");
		
		solo.goBack();
	}
}
