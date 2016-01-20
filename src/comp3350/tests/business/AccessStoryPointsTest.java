package comp3350.tests.business;

import comp3350.jaunt.application.Main;
import comp3350.jaunt.application.Services;
import comp3350.jaunt.business.AccessStoryPoints;
import comp3350.jaunt.objects.StoryPoint;
import comp3350.tests.persistence.DataAccessStub;
import junit.framework.TestCase;

public class AccessStoryPointsTest extends TestCase
{
	private static String dbName = Main.dbName;
	
	public AccessStoryPointsTest(String arg0)
	{
		super(arg0);
	}
	
	public void testStoryPoints()
	{
		AccessStoryPoints ap;
		StoryPoint currPoint;
		
		Services.closeDataAccess();
		
		System.out.println("\nStarting StoryPoints Test");
		
		Services.createDataAccess(new DataAccessStub(dbName));
		
		ap = new AccessStoryPoints();
		
		currPoint = ap.getPoint(0);
		
		assertNotNull(currPoint);
		assertEquals(0, currPoint.getID());
		assertEquals("City of Winnipeg", currPoint.getTitle());
		
		Services.closeDataAccess();
		
		System.out.println("Finished AccessStoryPoint test");
		
	}
}
