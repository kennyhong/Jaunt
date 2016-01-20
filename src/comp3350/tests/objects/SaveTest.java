package comp3350.tests.objects;

import junit.framework.TestCase;

import java.util.ArrayList;

import comp3350.jaunt.objects.Save;
import comp3350.jaunt.objects.StoryPoint;

public class SaveTest extends TestCase
{
	private StoryPoint storyPoint;
	private ArrayList<Integer> testHistory;
	private Save testSave;
	private int testID = 0;
	private int testPointID = 0;
	
	public SaveTest(String arg0)
	{
		super(arg0);
	}
	
	public void setUp()
	{
		System.out.println("\nStarting " + this.getName() + "...");
		storyPoint = new StoryPoint("Title", "Text", 1, 2);
		testHistory = new ArrayList<Integer>();
		testHistory.add(1);
		testHistory.add(2);
		testHistory.add(3);
		testHistory.add(4);
		testHistory.add(5);
		testHistory.add(6);		
	}
	
	public void tearDown()
	{
		System.out.println("Test "+ this.getName() + " Completed");
	}
	
	public void testSavePointWithHistory()
	{	
		testSave = new Save(testID, testPointID, testHistory);

		assertNotNull(testSave);
		assertNotNull(testSave.getSavePoint());
		assertNotNull(testSave.getSummary());
	}
	
	public void testPointExistsNullHistory()
	{
		ArrayList<Integer> nullHistory = null;
		
		testSave = new Save(testID, testPointID, nullHistory);
		
		assertNotNull(testSave);
		assertNotNull(testSave.getSavePoint());
		assertNull(testSave.getSummary());
	}
	
	public void testGetSaveData()
	{
		testSave = new Save(testID, testPointID, testHistory);
		
		assertNotNull(testSave);
		assertNotNull(testSave.getSavePoint());
		assertNotNull(testSave.getSummary());
		assertEquals(6, testSave.getSummary().size());
		assertEquals(storyPoint.getID(), testSave.getSavePoint());
		assertEquals(testHistory.toString(), testSave.getSummary().toString());
	}
}
