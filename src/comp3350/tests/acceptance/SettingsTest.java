package comp3350.tests.acceptance;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import comp3350.jaunt.presentation.ActivityHome;

public class SettingsTest extends ActivityInstrumentationTestCase2<ActivityHome>
{
	private Solo solo;
	
	public SettingsTest()
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
	
	public void testNightMode()
	{
		solo.waitForActivity("ActivityHome");
		solo.clickOnButton("Settings");
		
		Assert.assertEquals(true, solo.searchText("Settings"));
		Assert.assertEquals(true, solo.searchText("Night Mode"));
		Assert.assertEquals(true, solo.searchText("OFF"));
		Assert.assertEquals(true, solo.searchText("Close"));
		
		solo.clickOnButton("OFF");
		
		Assert.assertEquals(true, solo.searchText("Settings"));
		Assert.assertEquals(true, solo.searchText("Night Mode"));
		Assert.assertEquals(true, solo.searchText("ON"));
		Assert.assertEquals(true, solo.searchText("Close"));
		
		solo.clickOnButton("Close");
		
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
		
		solo.scrollDown();
		
		solo.clickOnButton("14   Home - Netflix");
		Assert.assertEquals(true, solo.searchText("Home - Netflix"));
		Assert.assertEquals(true, solo.searchText("Game Over: You decide to watch Netflix at home and end your night, little did you know, it was all a dream."));
		Assert.assertEquals(true, solo.searchText("Back"));
		solo.clickOnButton("Back");
		
		solo.goBack();
		
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
		solo.clickOnMenuItem("Save Game");
		
		solo.clickOnButton("Continue");
		solo.waitForActivity("ActivityGame");
		solo.assertCurrentActivity("Expected activity ActivityGame", "ActivityGame");
		
		solo.goBack();
		
		solo.waitForActivity("ActivityHome");
		solo.clickOnButton("Settings");
		
		Assert.assertEquals(true, solo.searchText("Settings"));
		Assert.assertEquals(true, solo.searchText("Night Mode"));
		Assert.assertEquals(true, solo.searchText("ON"));
		Assert.assertEquals(true, solo.searchText("Close"));
		
		solo.clickOnButton("ON");
		
		Assert.assertEquals(true, solo.searchText("Settings"));
		Assert.assertEquals(true, solo.searchText("Night Mode"));
		Assert.assertEquals(true, solo.searchText("OFF"));
		Assert.assertEquals(true, solo.searchText("Close"));
		
		solo.clickOnButton("Close");
	}
}