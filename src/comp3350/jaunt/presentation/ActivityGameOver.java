package comp3350.jaunt.presentation;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import comp3350.jaunt.R;
import comp3350.jaunt.application.Services;
import comp3350.jaunt.business.AccessSaveData;
import comp3350.jaunt.business.AccessStoryPoints;
import comp3350.jaunt.objects.StoryPoint;

public class ActivityGameOver extends Activity 
{
	private AccessSaveData accessSave;
	private AccessStoryPoints accessPoints;
	private MediaPlayer mp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		if(Services.checkNightModeEnabled())
		{
			setTheme(R.style.NightMode);
		}
		else
		{
			setTheme(R.style.BookMode);
		}
		
		super.onCreate(savedInstanceState);
		
		if(mp != null)
		{
			mp.stop();
		}
		
		mp = MediaPlayer.create(ActivityGameOver.this, R.raw.gameover);
		mp.setLooping(true);
		mp.start();
		setContentView(R.layout.activity_game_over);
		
		if(Services.checkNightModeEnabled())
		{
			Button btn = (Button) findViewById(R.id.btnReturn);
			btn.setTextColor(Color.parseColor("#E6E6E6"));
			btn = (Button) findViewById(R.id.btnRestart);
			btn.setTextColor(Color.parseColor("#E6E6E6"));
		}
		else
		{
			Button btn = (Button) findViewById(R.id.btnReturn);
			btn.setTextColor(getResources().getColor(R.color.brown));
			btn = (Button) findViewById(R.id.btnRestart);
			btn.setTextColor(getResources().getColor(R.color.brown));
		}
		
		accessSave = new AccessSaveData();
		accessPoints = new AccessStoryPoints();
		displayHistory();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.activity_game_over, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();
		if (id == R.id.action_settings) 
		{
			DialogSettings options = new DialogSettings(this);
			options.show(getFragmentManager(), "dialog");
		}
	
		return super.onOptionsItemSelected(item);
	}

	public void displayHistory()
	{
		ArrayList<Integer> points = new ArrayList<Integer>();
		TextView text = (TextView) findViewById(R.id.historyText);
		accessSave.getHistoryPointsSequential(points);
		
		String history = printList(points);
		if(text != null)
		{
			text.setText(history);
		}
	}
	
	private String printList(ArrayList<Integer> points)
	{
		String result = "";
		
		for(int i = 0 ; i< points.size(); i++)
		{
			StoryPoint tempPoint = accessPoints.getPoint(points.get(i));
			result += tempPoint.getTitle() + "\n";
		}
		
		return result;
	}
	
	public void onReturnClick(View view)
	{
		mp.stop();
		finish();
	}
	
	public void onRestartClick(View view)
	{
		Intent intent = new Intent(ActivityGameOver.this, ActivityGame.class);
		mp.stop();
		startActivity(intent);
		finish();
	}
}