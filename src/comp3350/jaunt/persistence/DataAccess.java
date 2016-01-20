package comp3350.jaunt.persistence;

import java.util.ArrayList;

import comp3350.jaunt.objects.StoryPoint;
import comp3350.jaunt.objects.Save;

public interface DataAccess 
{
	public void open(String string);
	
	public void close();
		
	public String getPointsSequential(ArrayList<StoryPoint> points);
	
	public String insertSavePoint(Save savefile);
	
	public Save getSave(int sID);
	
	public void addToHistory(int pointID);
	
	public void updateHistory(ArrayList<Integer> points);
	
	public String getSavesSequential(ArrayList<Save> saves);
	
	public StoryPoint getPoint(int pointID);
	
	public void getHistorySequential(ArrayList<Integer> points);
	
}
