package comp3350.tests.business;

import java.util.ArrayList;

import comp3350.jaunt.application.Main;
import comp3350.jaunt.application.Services;
import comp3350.jaunt.business.AccessSaveData;
import comp3350.jaunt.objects.Save;
import comp3350.tests.persistence.DataAccessStub;
import junit.framework.TestCase;

public class AccessSaveDataTest extends TestCase
{
	private static String dbName = Main.dbName;
	
	public AccessSaveDataTest(String arg0)
	{
		super(arg0);
	}
	
	public void testSave()
	{
		AccessSaveData as;
		Save currSave;
		ArrayList<Integer> historyStub = new ArrayList<Integer>();
		
		
		Services.closeDataAccess();
		
		System.out.println("\nStarting AcessSaveData Test");
		
		Services.createDataAccess(new DataAccessStub(dbName));
		
		historyStub.add(0);
		
		currSave = new Save(1, 1, historyStub);
		
		as = new AccessSaveData();
		
		as.saveCurrentGame(currSave);
		
		currSave = as.getSavedGame(1);
		
		assertNotNull(currSave);
		assertEquals(1, currSave.getSaveID());
		
		Services.closeDataAccess();
		
		System.out.println("Finished AccessSaveData test");
	}
	
}
