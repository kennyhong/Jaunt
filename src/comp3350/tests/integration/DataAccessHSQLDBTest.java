package comp3350.tests.integration;

import junit.framework.TestCase;

import comp3350.jaunt.application.Main;
import comp3350.jaunt.application.Services;
import comp3350.jaunt.persistence.DataAccess;
import comp3350.tests.persistence.DataAccessTest;

public class DataAccessHSQLDBTest extends TestCase
{
	private static String dbName = Main.dbName;
	
	public DataAccessHSQLDBTest(String arg0)
	{
		super(arg0);
	}
	
	public void testDataAccess()
	{
		DataAccess dataAccess;
		
		Services.closeDataAccess();
		
		System.out.println("\nStarting Integration test DataAccess (using default DB)");
		
		Services.createDataAccess(dbName);
		dataAccess = Services.getDataAccess(dbName);
		
		DataAccessTest.dataAccessTest();

		System.out.println("Finished Integration test DataAccess (using default DB)");
	}
}
