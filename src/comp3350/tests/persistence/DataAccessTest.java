package comp3350.tests.persistence;

import junit.framework.TestCase;

import java.util.ArrayList;

import comp3350.jaunt.application.Services;
import comp3350.jaunt.application.Main;
import comp3350.jaunt.objects.StoryPoint;
import comp3350.jaunt.persistence.DataAccess;


public class DataAccessTest extends TestCase
{
	private static String dbName = Main.dbName;
	
	public DataAccessTest(String arg0)
	{
		super(arg0);
	}
	
	public void testDataAccess()
	{
		DataAccess dataAccess;
		
		Services.closeDataAccess();
		
		System.out.println("\nStarting Persistence test DataAccess (using stub)");
		
		dataAccess = (DataAccess) Services.createDataAccess(new DataAccessStub(dbName));
		
		dataAccessTest();

		System.out.println("Finished Persistence test DataAccess (using stub)");
	}
	
	public static void dataAccessTest()
	{
		DataAccess dataAccess;
		
		ArrayList<StoryPoint> points;
		StoryPoint point;
		
		String result;
		
		dataAccess = (DataAccess) Services.getDataAccess(dbName);
		
		points = new ArrayList<StoryPoint>();
		result = dataAccess.getPointsSequential(points);
		assertNull(result);
		assertNotNull(points);
		assertEquals(15, points.size());
		point = (StoryPoint) points.get(2);
		assertEquals(2, point.getID());
		assertEquals("Kawaii Crepe", point.getTitle());
		assertEquals("You order crepe to celebrate your first day off in weeks.", point.getText());
		assertEquals("Get food", point.getReference());
		assertEquals("[5, 6]", point.getChildren().toString());
		
		Services.closeDataAccess();
	}
}
