package comp3350.tests.persistence;

import java.util.ArrayList;

import comp3350.jaunt.application.Main;
import comp3350.jaunt.objects.StoryPoint;
import comp3350.jaunt.objects.Save;
import comp3350.jaunt.persistence.DataAccess;

public class DataAccessStub implements DataAccess
{
	private String dbName;
	private String dbType = "stub";
	
	private ArrayList<StoryPoint> storyPoints;
	private ArrayList<Integer> history;
	private ArrayList<Save> saves;
	
	public DataAccessStub(String dbName)
	{
		this.dbName = dbName;
	}

	public DataAccessStub()
	{
		this(Main.dbName);
	}
	
	public void open(String dbName)
	{
		StoryPoint point;
		history = new ArrayList<Integer>();
		saves = new ArrayList<Save>();
		storyPoints = new ArrayList<StoryPoint>();
		
		point = new StoryPoint(0,"City of Winnipeg", "You are in the busy streets of Osbourne, what do you do?", 1 , 2);
		storyPoints.add(point);
		point = new StoryPoint(1,"The Toad", "You arrive at The Toad and your favourite band is playing", "Go to the Bar", 3, 4);
		storyPoints.add(point);
		point = new StoryPoint(2,"Kawaii Crepe", "You order crepe to celebrate your first day off in weeks.", "Get food", 5, 6);
		storyPoints.add(point);
		point = new StoryPoint(3,"The Toad - Bar", "It's your day off, you decide to relax", "Drink", 7, 8);
		storyPoints.add(point);
		point = new StoryPoint(4,"The Toad - Exit", "It's your day off, you don't feel like drinking", "Drive home", 9, 10);
		storyPoints.add(point);
		point = new StoryPoint(5,"Kawaii Crepe - Counter", "You decide to eat in and enjoy the view of a beautiful woman", "Eat in" , 11, 12);
		storyPoints.add(point);
		point = new StoryPoint(6,"Kawaii Crepe - Exit", "You decide to take out and eat at home", "Take out", 13, 14);
		storyPoints.add(point);
		point = new StoryPoint(7,"The Toad - Band", "Game Over: As you grab your drink you realize your friend's band is playing and decide to chill with him for the rest of the night.", "Listen to Band");
		storyPoints.add(point);
		point = new StoryPoint(8,"The Toad - More Drinks", "Game Over: You ignore your surroundings and start drinking liquor like water. You are Drunk", "Drink more");
		storyPoints.add(point);
		point = new StoryPoint(9,"Home", "Game Over: You decide to go to bed", "Go Home");
		storyPoints.add(point);
		point = new StoryPoint(10,"Theatre", "Game Over: You decide to watch a movie and end your night.", "Watch a movie");
		storyPoints.add(point);
		point = new StoryPoint(11,"Kawaii Crepe - Girl", "Game Over: You meet a lady and decide to chat with her, you get turned down", "Talk to Girl");
		storyPoints.add(point);
		point = new StoryPoint(12,"Kawaii Crepe - Loner", "Game Over: You stay quiet and continue eating. You spend the rest of your life alone.", "Ignore the girl");
		storyPoints.add(point);
		point = new StoryPoint(13,"The Cube - Music", "Game Over: You listen to the live music at the cube and enjoy it.", "Go Downtown");
		storyPoints.add(point);
		point = new StoryPoint(14,"Home - Netflix", "Game Over: You decide to watch Netflix at home and end your night, little did you know, it was all a dream.", "Drive home");
		storyPoints.add(point);
	}
	
	public void close()
	{
		System.out.println("Closed " +dbType +" database " +dbName);
	}
	
	public String getPointsSequential(ArrayList<StoryPoint> points)
	{
		points.addAll(storyPoints);
		return null;
	}
	
	public StoryPoint getPoint(int pointID)
	{
		StoryPoint result = null;
		for(int i = 0; i < storyPoints.size(); i++)
		{
			if(storyPoints.get(i).getID() == pointID)
			{
				result = storyPoints.get(i);
			}
		}
		return result;
	}
	
	public String insertSavePoint(Save saveFile)
	{
		saves.add(saveFile);
		return null;
	}
	
	public Save getSave(int saveID)
	{
		Save currSave = null;
		
		for(int i = 0; i < saves.size(); i++)
		{
			if(saves.get(i).getSaveID() == saveID)
			{
				currSave = saves.get(i);
			}
		}
		
		return currSave;
	}

	public void addToHistory(int pointID)
	{
		history.add(pointID);
	}
	
	public void updateHistory(ArrayList<Integer> points)
	{
		history.clear();
		history.addAll(points);
	}
	
	public void getHistorySequential(ArrayList<Integer> historyPoints)
	{
		historyPoints.addAll(history);
	}
	
	public String getSavesSequential(ArrayList<Save> saveFiles)
	{
		saveFiles.addAll(saves);
		return null;
	}
	
}