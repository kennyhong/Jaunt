package comp3350.jaunt.business;

import java.util.ArrayList;

import comp3350.jaunt.application.Main;
import comp3350.jaunt.application.Services;
import comp3350.jaunt.persistence.DataAccess;
import comp3350.jaunt.objects.Save;

public class AccessSaveData
{
	private DataAccess dataAccess;
	
	public AccessSaveData()
	{
		dataAccess = Services.getDataAccess(Main.dbName);
	}
	
	public void saveCurrentGame(Save currPoint)
	{
		this.dataAccess.insertSavePoint(currPoint);
	}
	
	public Save getSavedGame(int saveID)
	{
		return this.dataAccess.getSave(saveID);
	}
	
	public String getSaveFiles(ArrayList<Save> saves)
	{
		return this.dataAccess.getSavesSequential(saves);
	}
	
	public void insertHistoryPoint(int pointID)
	{
		dataAccess.addToHistory(pointID);
	}
	
	public void updateHistory(ArrayList<Integer> points)
	{
		dataAccess.updateHistory(points);
	}
	
	public void getHistoryPointsSequential(ArrayList<Integer> points)
	{
		points.clear();
		dataAccess.getHistorySequential(points);
	}
}
