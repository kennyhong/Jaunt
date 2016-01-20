package comp3350.tests.objects;

import junit.framework.TestCase;
import java.util.ArrayList;
import comp3350.jaunt.objects.StoryPoint;

public class StoryPointTest extends TestCase
{
	private ArrayList<StoryPoint> list = new ArrayList<StoryPoint>();
	private StoryPoint pointEnd;
	private StoryPoint pointStart;
	private StoryPoint pointMid;
	private StoryPoint pointMid2;
	
	public StoryPointTest(String arg0)
	{
		super(arg0);
	}
	
	@Override
	public void setUp()
	{
		System.out.println("\nStarting " + this.getName() + "...");
		pointEnd = new StoryPoint("End title", "End text", "End reference");
		pointStart = new StoryPoint("Beginning title", "Beginning text", 1, 2);
		pointMid = new StoryPoint("Mid title", "Mid text", 3, 4);
		pointMid2 = new StoryPoint("Mid title 2", "Mid text 2", 5, 6);
		list.add(pointStart);
		list.add(pointMid);	
		list.add(pointMid2);
		list.add(pointEnd);
		list.add(pointEnd);
		list.add(pointEnd);
		list.add(pointEnd);
	}
	
	@Override
	public void tearDown()
	{
		System.out.println("Test "+ this.getName() + " Completed");
	}
	
	public void testCreateStoryPoint()
	{
		StoryPoint point;
		point = new StoryPoint(3, "End title", "End text", "End reference");
		assertNotNull(point);
		assertEquals("End title", point.getTitle());
		assertEquals("End text", point.getText());
		assertEquals("End reference", point.getReference());
		assertEquals(false, point.hasChildren());
	}
	
	public void testEmptyStoryPoint()
	{
		StoryPoint emptySP;
		emptySP = new StoryPoint();
		assertNotNull(emptySP);
		assertEquals("Missing Title", emptySP.getTitle());
		assertEquals("Missing Text", emptySP.getText());
		assertEquals("Missing Reference", emptySP.getReference());
		assertEquals(false, emptySP.hasChildren());
		
	}
	
	public void testNullStoryPoint()
	{
		StoryPoint nullSP;
		nullSP = new StoryPoint (null, null, null);
		assertNotNull(nullSP);
		assertEquals("Missing Title", nullSP.getTitle());
		assertEquals("Missing Text", nullSP.getText());
		assertEquals("Missing Reference", nullSP.getReference());

		
		nullSP = new StoryPoint (null, null, "Ref");
		assertNotNull(nullSP);
		assertEquals("Missing Title", nullSP.getTitle());
		assertEquals("Missing Text", nullSP.getText());
		assertEquals("Ref", nullSP.getReference());
		
		nullSP = new StoryPoint (null, "Text", null);
		assertNotNull(nullSP);
		assertEquals("Missing Title", nullSP.getTitle());
		assertEquals("Text", nullSP.getText());
		assertEquals("Missing Reference", nullSP.getReference());
		
		nullSP = new StoryPoint ("Title", null, null);
		assertNotNull(nullSP);
		assertEquals("Title", nullSP.getTitle());
		assertEquals("Missing Text", nullSP.getText());
		assertEquals("Missing Reference", nullSP.getReference());
		
		nullSP = new StoryPoint ("Title", "Text", null);
		assertNotNull(nullSP);
		assertEquals("Title", nullSP.getTitle());
		assertEquals("Text", nullSP.getText());
		assertEquals("Missing Reference", nullSP.getReference());

		nullSP = new StoryPoint ("Title", null, "Ref");
		assertNotNull(nullSP);
		assertEquals("Title", nullSP.getTitle());
		assertEquals("Missing Text", nullSP.getText());
		assertEquals("Ref", nullSP.getReference());
		
		nullSP = new StoryPoint (null, "Text", "Ref");
		assertNotNull(nullSP);
		assertEquals("Missing Title", nullSP.getTitle());
		assertEquals("Text", nullSP.getText());
		assertEquals("Ref", nullSP.getReference());
	}
	
	public void testListOfStoryPoints()
	{
		ArrayList<StoryPoint> points;
		
		points = new ArrayList<StoryPoint>();
		assertEquals(true, points.isEmpty());
		assertNotNull(points);
		assertEquals(0, points.size());
		
		pointEnd = new StoryPoint(3, "End title", "End text", "End reference");
		pointStart = new StoryPoint(0, "Beginning title", "Beginning text", 1, 2);
		pointMid = new StoryPoint(1, "Mid title", "Mid text", 3, 4);
		pointMid2 = new StoryPoint(2, "Mid title 2", "Mid text 2", 5, 6);
		
		points.add(pointStart);
		assertNotNull(points.get(0));
		assertEquals(0, points.get(0).getID());
		assertEquals("Beginning title", points.get(0).getTitle());
		assertEquals("Beginning text", points.get(0).getText());
		assertEquals("Go back to " + pointStart.getTitle(), points.get(0).getReference());
		assertEquals(true, points.get(0).hasChildren()); 
		assertEquals(1, points.size());
		
		points.add(pointMid);
		assertNotNull(points.get(1));
		assertEquals(1, points.get(1).getID());
		assertEquals("Mid title", points.get(1).getTitle());
		assertEquals("Mid text", points.get(1).getText());
		assertEquals("Go back to " + pointMid.getTitle(), points.get(1).getReference());
		assertEquals(true, points.get(1).hasChildren()); 
		assertEquals(2, points.size());
		
		points.add(pointMid2);
		assertNotNull(points.get(2));
		assertEquals(2, points.get(2).getID());
		assertEquals("Mid title 2", points.get(2).getTitle());
		assertEquals("Mid text 2", points.get(2).getText());
		assertEquals("Go back to " + pointMid2.getTitle(), points.get(2).getReference());
		assertEquals(true, points.get(2).hasChildren()); 
		assertEquals(3, points.size());
		
		points.add(pointEnd);
		assertNotNull(points.get(3));
		assertEquals(3, points.get(3).getID());
		assertEquals("End title", points.get(3).getTitle());
		assertEquals("End text", points.get(3).getText());
		assertEquals("End reference", points.get(3).getReference());
		assertEquals(false, points.get(3).hasChildren()); 
		assertEquals(4, points.size());
		
		points.remove(2);
		assertEquals(3, points.size());
		assertEquals(3, points.get(2).getID());
		
		points.add(null);
		assertEquals(4, points.size());
		assertEquals(null, points.get(3));
	}
}