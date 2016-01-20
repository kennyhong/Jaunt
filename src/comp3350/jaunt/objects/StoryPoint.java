package comp3350.jaunt.objects;

import java.util.ArrayList;

public class StoryPoint
{	
	private static final String DEFAULT_TITLE = "Missing Title";
	private static final String DEFAULT_TEXT = "Missing Text";
	private static final String DEFAULT_REF = "Missing Reference";
	private static final int DEFAULT_ID = -1;
	private static final int GAMEOVER = 9001;
	
	private String title;
	private String text;
	private String reference;
	private int pointID;
	private ArrayList<Integer> children;
	
	public StoryPoint(int pointID, String title, String text, String ref, int child1, int child2)
	{
		if(title == null)
		{
			title = DEFAULT_TITLE;
		}
		if(text == null)
		{
			text = DEFAULT_TEXT;
		}
		if(ref == null)
		{
			ref = DEFAULT_REF;
		}
		
		this.title = title;
		this.text = text;
		this.reference = ref;
		this.pointID = pointID;
		children = new ArrayList<Integer>();
		children.add(child1);
		children.add(child2);
	}
	
	public StoryPoint(int pointID, String title, String text, String ref, ArrayList<Integer> children)
	{
		if(title == null)
		{
			title = DEFAULT_TITLE;
		}
		if(text == null)
		{
			text = DEFAULT_TEXT;
		}
		if(ref == null)
		{
			ref = DEFAULT_REF;
		}
		
		this.title = title;
		this.text = text;
		this.reference = ref;
		this.pointID = pointID;
		this.children = children;
	}
	
	public StoryPoint(String title, String text, String ref)
	{
		if(title == null)
		{
			title = DEFAULT_TITLE;
		}
		if(text == null)
		{
			text = DEFAULT_TEXT;
		}
		if(ref == null)
		{
			ref = DEFAULT_REF;
		}
		
		this.title = title;
		this.text = text;
		this.reference = ref;
	}
	
	public StoryPoint(String title, String text, String ref, int child1, int child2)
	{
		if(title == null)
		{
			title = DEFAULT_TITLE;
		}
		if(text == null)
		{
			text = DEFAULT_TEXT;
		}
		if(ref == null)
		{
			ref = DEFAULT_REF;
		}
		
		this.title = title;
		this.text = text;
		this.reference = ref;
		children = new ArrayList<Integer>();
		children.add(child1);
		children.add(child2);
	}
	
	public StoryPoint(String title, String text, int child1, int child2)
	{
		this(title, text, "Go back to " + title, child1, child2);
	}
	
	public StoryPoint(int pointID, String title, String text, int child1, int child2)
	{
		this(pointID, title, text, "Go back to " + title, child1, child2);
	}
	
	public StoryPoint(int pointID, String title, String text, String ref)
	{
		this(pointID, title, text, ref,GAMEOVER, GAMEOVER);
		children.clear();
	}
	
	public StoryPoint()
	{
		this(DEFAULT_ID, DEFAULT_TITLE, DEFAULT_TEXT, DEFAULT_REF);
	}
	
	public String getTitle() 	{ return title; }
	public String getText() 	{ return text; }
	public String getReference() { return reference; }
	public ArrayList<Integer> getChildren() { return children; }
	public boolean hasChildren() { return !children.isEmpty(); }
	public int getID()	{return pointID;}
	
	public String toString()
	{
		String result;
		
		result = title + "\n";
		result += text + "\n";
		result += reference + "\n";
		
		return result;
	}
}