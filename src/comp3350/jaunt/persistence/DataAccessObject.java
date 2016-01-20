package comp3350.jaunt.persistence;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.util.ArrayList;

import comp3350.jaunt.objects.StoryPoint;
import comp3350.jaunt.objects.Save;

public class DataAccessObject implements DataAccess
{
	private Statement st1, st2, st3;
	private Connection c1;
	private ResultSet rs2, rs3, rs4, rs5;

	private String dbName;
	private String dbType;
	
	private ArrayList<Integer> history = new ArrayList<Integer>();
	private Save currSave;
	
	private String cmdString;
	private int updateCount;
	private String result;
	private static String EOF = "  ";
	
	public DataAccessObject(String dbName)
	{
		this.dbName = dbName;
	}
	
	public void open(String dbPath)
	{
		String url;
		try
		{
			dbType = "HSQL";
			Class.forName("org.hsqldb.jdbcDriver").newInstance();
			url = "jdbc:hsqldb:file:" + dbPath; 
			c1 = DriverManager.getConnection(url, "SA", "");
			st1 = c1.createStatement();
			st2 = c1.createStatement();
			st3 = c1.createStatement();
		}
		catch (Exception e)
		{
			processSQLError(e);
		}
		System.out.println("Opened " +dbType +" database " +dbPath);
	}
	
	public void close()
	{
		try
		{	
			cmdString = "shutdown compact";
			rs2 = st1.executeQuery(cmdString);
			c1.close();
		}
		catch (Exception e)
		{
			processSQLError(e);
		}
		System.out.println("Closed " +dbType +" database " +dbName);
	}
	
	public String processSQLError(Exception e)
	{
		String result = "*** SQL Error: " + e.getMessage();

		e.printStackTrace();
		
		return result;
	}
	
	public String checkWarning(Statement st, int updateCount)
	{

		result = null;
		try
		{
			SQLWarning warning = st.getWarnings();
			if (warning != null)
			{
				result = warning.getMessage();
			}
		}
		catch (Exception e)
		{
			result = processSQLError(e);
		}
		if (updateCount != 1)
		{
			result = "Tuple not inserted correctly.";
		}
		return result;
	}

	
	public String getPointsSequential(ArrayList<StoryPoint> points)
	{
		String result = null;

		int pointID = -1;
		String title = EOF;
		String text = EOF;
		String reference = EOF;
		String childrenPoints = EOF;
		ArrayList<Integer> children = new ArrayList<Integer>();
		StoryPoint point;
		
		try
		{
			cmdString = "Select * from Points";
			rs2 = st2.executeQuery(cmdString);
		}
		catch(Exception e)
		{
			processSQLError(e);
		}
		try
		{
			while (rs2.next())
			{
				pointID = rs2.getInt("PointID");
				title = rs2.getString("Title");
				text = rs2.getString("Text");
				reference = rs2.getString("Reference");
				childrenPoints = rs2.getString("Children");
				children = new ArrayList<Integer>();
				if(childrenPoints != null)
				{
					for(String childID: (childrenPoints.split(",")))
					{
						children.add(Integer.parseInt(childID));
					}
				}
				point = new StoryPoint(pointID, title, text, reference, children);
				points.add(point);
			}
			rs2.close();
		}
		catch (Exception e)
		{
			result = processSQLError(e);
		}
		
		return result;
	}
	
	public StoryPoint getPoint(int pointID)
	{
		StoryPoint result = new StoryPoint();
		String title = EOF;
		String text = EOF;
		String reference = EOF;
		String childrenPoints = EOF;
		ArrayList<Integer> children = new ArrayList<Integer>();
		
		try
		{
			cmdString = "Select * from Points where PointID = " + pointID;
			rs3 = st3.executeQuery(cmdString);
			
			if(rs3 != null)
			{
				rs3.next();
				pointID = rs3.getInt("PointID");
				title = rs3.getString("Title");
				text = rs3.getString("Text");
				reference = rs3.getString("Reference");
				childrenPoints = rs3.getString("Children");
				if(childrenPoints != null)
				{
					for(String childID: (childrenPoints.split(",")))
					{
						children.add(Integer.parseInt(childID.trim()));
					}
				}
				result = new StoryPoint(pointID, title, text, reference, children);
			}
		}
		catch(Exception e)
		{
			processSQLError(e);
		}
			
		return result;
	}
	
	public String insertSavePoint(Save savefile)
	{
		String result = null;
		String values;
		ArrayList<Integer> summary;
		String idCheckCmd;
		String summaryPoints = "";
		
		try
		{	
			values = savefile.getSaveID() + "," + savefile.getSavePoint() + ",";
			summary = history;
			if(summary.size() > 0)
			{
				summaryPoints += "'";
				for(int i = 0; i < summary.size(); i++)
				{			
					summaryPoints += summary.get(i);
					
					if(i != summary.size() - 1)
					{
						summaryPoints += ",";
					}
				}
				summaryPoints += "'";
				values += summaryPoints;
			}
			
			idCheckCmd = "Select * from saves where saveid = " + savefile.getSaveID();
			rs5 = st3.executeQuery(idCheckCmd);
			
			if(rs5.next() == false)
			{
				cmdString = "Insert into Saves " +" Values(" +values +")";
			}
			else
			{
				cmdString = "Update Saves SET savepoint = " + savefile.getSavePoint() + " where saveid =" + savefile.getSaveID() + ";";
				cmdString += "Update Saves SET summary = " + summaryPoints + " where saveid =" + savefile.getSaveID() + ";";
			}
			updateCount = st2.executeUpdate(cmdString);
			result = checkWarning(st2, updateCount);
		}
		catch (Exception e)
		{
			result = processSQLError(e);
		}
		return result;
	}
	

	public String getSavesSequential(ArrayList<Save> saves)
	{
		result = null;

		int saveID;
		int savePoint;
		String summaryPoints = EOF;
		ArrayList<Integer> summary = new ArrayList<Integer>();
		Save aSave;
		
		try
		{
			cmdString = "Select * from Saves";
			rs4 = st2.executeQuery(cmdString);

		}
		catch (Exception e)
		{
			result = processSQLError(e);
		}
		try
		{
			while (rs4.next())
			{
				saveID = rs4.getInt("SaveID");
				savePoint = rs4.getInt("SavePoint");
				summaryPoints = rs4.getString("Summary");
				summary.clear();
				
				for(String point: (summaryPoints.split(",")))
				{
					summary.add(Integer.parseInt(point));
				}
				aSave = new Save(saveID, savePoint, summary);
				saves.add(aSave);
			}
		}
		catch (Exception e)
		{
			result = processSQLError(e);
		}
		
		return result;
	}
	
	public Save getSave(int sid)
	{
		int saveID;
		int savePoint;
		String summaryPoints = EOF;
		result = null;
		ArrayList<Integer> summary = new ArrayList<Integer>();
		Save aSave;
		
		try
		{
			cmdString = "Select * from Saves where SaveID = " + sid;
			rs5 = st2.executeQuery(cmdString);
			if(rs5 != null)
			{
				rs5.next();
				saveID = rs5.getInt("SaveID");
				savePoint = rs5.getInt("SavePoint");
				summaryPoints = rs5.getString("Summary");
				
				for(String point: (summaryPoints.split(",")))
				{
					summary.add(Integer.parseInt(point));
				}
				aSave = new Save(saveID, savePoint, summary);
				history = summary;
				currSave = aSave;
			}
		}
		catch (Exception e)
		{
			result = processSQLError(e);
		}
		
		return currSave;
	}
	
	public void addToHistory(int pointID)
	{
		history.add(pointID);
	}
	
	public void updateHistory(ArrayList<Integer> points)
	{
		if(history != null)
		{
			history.clear();
		}
		history.addAll(points);
	}
	
	public void getHistorySequential(ArrayList<Integer> points)
	{
		points.clear();
		points.addAll(history);
	}
}