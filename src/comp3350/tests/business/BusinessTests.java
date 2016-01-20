package comp3350.tests.business;

import junit.framework.Test;
import junit.framework.TestSuite;

public class BusinessTests 
{
	public static TestSuite suite;
	
	public static Test suite()
	{
		suite = new TestSuite("Business tests");
		suite.addTestSuite(AccessSaveDataTest.class);
		suite.addTestSuite(AccessStoryPointsTest.class);
		return suite;
	}
}
