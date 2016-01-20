package comp3350.jaunt.objects;

import java.util.ArrayList;

public class Save 
{
	private int savePoint;
	private ArrayList<Integer> summary;
	private int saveID;

	public Save(int pointID, ArrayList<Integer> history)
	{	
		if(history != null && history.size() > 0)
		{
			savePoint = pointID;
			this.summary = history;
			this.saveID = 1;
		}
	}

	public Save(int saveID, int pointID, ArrayList<Integer> history)
	{
		this.saveID = saveID;
		this.savePoint = pointID;
		this.summary = history;
	}
	
	public int getSavePoint() { return  savePoint;}
	public ArrayList<Integer> getSummary() {	return this.summary; }
	public int getSaveID() { return this.saveID; }
}