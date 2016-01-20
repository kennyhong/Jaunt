package comp3350.tests.acceptance;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AcceptanceTests
{
	public static TestSuite suite;

    public static Test suite()
    {
        suite = new TestSuite("Acceptance tests");
        suite.addTestSuite(StoryGameTest.class);
        suite.addTestSuite(SaveGameTest.class);
        suite.addTestSuite(GlossaryTest.class);
        suite.addTestSuite(SettingsTest.class);
        return suite;
    }
}
