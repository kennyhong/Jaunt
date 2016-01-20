package comp3350.jaunt.application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;


import comp3350.jaunt.persistence.DataAccess;
import comp3350.jaunt.persistence.DataAccessObject;

public class Services
{
	private static boolean nightModeEnabled = false;
	private static DataAccess dataAccessService = null;
	private static Typeface gameFont = null;

	public static DataAccess createDataAccess(String dbName)
	{
		if (dataAccessService == null)
		{
			dataAccessService = new DataAccessObject(dbName);
			dataAccessService.open(Main.getDBPathName());
		}
		return dataAccessService;
	}

	public static DataAccess createDataAccess(DataAccess alternateDataAccessService)
	{
		if (dataAccessService == null)
		{
			dataAccessService = alternateDataAccessService;
			dataAccessService.open(Main.getDBPathName());
		}
		return dataAccessService;
	}

	public static DataAccess getDataAccess(String dbName)
	{
		if (dataAccessService == null)
		{
			System.out.println("Connection to data access has not been established.");
			System.exit(1);
		}
		return dataAccessService;
	}

	public static void closeDataAccess()
	{
		if (dataAccessService != null)
		{
			dataAccessService.close();
		}
		dataAccessService = null;
	}
	
	public static boolean checkNightModeEnabled()
	{
		return nightModeEnabled;
	}
	
	public static void toggleNightMode(Context mContext)
	{
		Activity activity;
		
		if(nightModeEnabled)
		{
			nightModeEnabled = false;
			
		} 
		else 
		{
			nightModeEnabled = true;
		}
		
		if(mContext instanceof Activity)
		{
			activity = (Activity) mContext;
			Intent intent = new Intent();
			intent.setClass(activity, activity.getClass());
			activity.startActivity(intent);
			activity.finish();
		}
	}
	
	public static void createGameFont(AssetManager mgr)
	{
		gameFont = Typeface.createFromAsset(mgr, "fonts/Quantico-Regular.ttf");
	}
	
	public static Typeface getFont()
	{
		return gameFont;
	}
}