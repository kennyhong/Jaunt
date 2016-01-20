package comp3350.tests.integration;

import java.util.ArrayList;

import junit.framework.TestCase;
import comp3350.jaunt.application.Main;
import comp3350.jaunt.application.Services;
import comp3350.jaunt.business.AccessSaveData;
import comp3350.jaunt.business.AccessStoryPoints;
import comp3350.jaunt.objects.Save;
import comp3350.jaunt.objects.StoryPoint;

public class BusinessPersistenceSeamTest extends TestCase
{
	public BusinessPersistenceSeamTest(String arg0)
	{
		super(arg0);
	}
	
	public void testAccessStoryPoints()
	{
		AccessStoryPoints ap;
		StoryPoint currPoint;
		
		Services.closeDataAccess();
		
		System.out.println("\nStarting Integration test of AccessStoryPoints to persistence");
		
		Services.createDataAccess(Main.dbName);
		
		ap = new AccessStoryPoints();
		
		currPoint = ap.getPoint(1);
		
		assertNotNull(currPoint);
		assertEquals(1, currPoint.getID());
		assertEquals("The Toad", currPoint.getTitle());
		
		currPoint = ap.getPoint(13);
		
		assertNotNull(currPoint);
		assertEquals(13, currPoint.getID());
		assertEquals("The Cube - Music", currPoint.getTitle());
		
		Services.closeDataAccess();
		
		System.out.println("Finished Integration test of AccessStudents to persistence");
	}
	
	public void testAccessSaveData()
	{
		AccessSaveData as;
		Save newSave;
		Save testSave;
		ArrayList<Integer> history;

		Services.closeDataAccess();
		
		System.out.println("\nStarting Integration test of AccessSaveData to persistence");
		
		Services.createDataAccess(Main.dbName);
		
		as = new AccessSaveData();
		
		history = new ArrayList<Integer>();
		
		history.add(0);
		
		as.insertHistoryPoint(0);
		
		newSave = new Save(0, 2, history);
		
		as.saveCurrentGame(newSave);
		
		testSave = as.getSavedGame(0);
		assertEquals(0, testSave.getSaveID());
		assertEquals(2, testSave.getSavePoint());
		assertEquals("[0]", testSave.getSummary().toString());
		
		history.add(2);
		
		as.insertHistoryPoint(2);
		
		newSave = new Save(0, 5, history);
		
		as.saveCurrentGame(newSave);
		assertEquals(0, testSave.getSaveID());
		assertEquals(2, testSave.getSavePoint());
		assertEquals("[0, 2]", testSave.getSummary().toString());
		
		Services.closeDataAccess();
		
		System.out.println("Finished Integration test of AccessSaveData to persistence");
	}
}
