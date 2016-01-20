package comp3350.jaunt.business;

import java.util.ArrayList;

import comp3350.jaunt.application.Main;
import comp3350.jaunt.application.Services;
import comp3350.jaunt.objects.StoryPoint;
import comp3350.jaunt.persistence.DataAccess;

public class AccessStoryPoints 
{
	private DataAccess dataAccess;

	public AccessStoryPoints()
	{
		dataAccess = Services.getDataAccess(Main.dbName);
	}

	public String getStoryPoints(ArrayList<StoryPoint> points)
	{
		points.clear();
		return dataAccess.getPointsSequential(points);
	}
	
	public StoryPoint getPoint(int pointID)
	{
		return dataAccess.getPoint(pointID);
	}
}