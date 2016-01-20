package comp3350.jaunt.presentation;

import java.util.ArrayList;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import comp3350.jaunt.R;
import comp3350.jaunt.application.Services;
import comp3350.jaunt.business.AccessSaveData;
import comp3350.jaunt.business.AccessStoryPoints;
import comp3350.jaunt.objects.Save;
import comp3350.jaunt.objects.StoryPoint;

public class ActivityGame extends Activity
{
	private AccessStoryPoints accessPoints;
	private AccessSaveData accessSaveData;
    private ArrayList<StoryPoint> points;
    private StoryPoint currPoint = null;
    private MediaPlayer mp;
    private static ArrayList<Integer> history;
    private boolean loadSavedGame;

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
		
    	loadSavedGame = this.getIntent().getBooleanExtra("Continue", false);
    	int saveID = 0;
    	Save savePoint = null;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		history = new ArrayList<Integer>();
		
		if(mp != null)
		{
			mp.stop();
		}
		
		mp = MediaPlayer.create(ActivityGame.this, R.raw.game);
		mp.setLooping(true);
		mp.start();
		
		points = new ArrayList<StoryPoint>();
		accessSaveData = new AccessSaveData();
        accessPoints = new AccessStoryPoints();
        accessPoints.getStoryPoints(points);
        accessSaveData.updateHistory(new ArrayList<Integer>());
        
        if(loadSavedGame)
        {
        	savePoint = accessSaveData.getSavedGame(saveID);
        	
        	if(savePoint != null)
        	{
        		history = savePoint.getSummary();
            	currPoint = accessPoints.getPoint(savePoint.getSavePoint());
        	}	
        	else
        	{
        		Toast.makeText(getApplicationContext(), "No Save Found!", Toast.LENGTH_LONG).show();
        	}
        }
        
        if(currPoint == null)
        {
        	currPoint = points.get(0);
        }
       
        setElements();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.activity_game, menu);
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
		else if(id == R.id.saveGame)
		{	
			Save newSave = new Save(0, currPoint.getID(), history);
			accessSaveData.saveCurrentGame(newSave);
			Intent intent = new Intent(ActivityGame.this, ActivityHome.class);
			mp.stop();
			startActivity(intent);
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	public void setElements()
	{
		clearButtons();
		
		TextView text = (TextView) findViewById(R.id.storyTitle);
		text.setText(currPoint.getTitle());
		
		if(!loadSavedGame)
		{	
			addToHistory(currPoint.getID());
		}
		else
		{
			loadSavedGame = false;
		}
		
		text = (TextView) findViewById(R.id.storyText);
		text.setText(currPoint.getText());
		
		setButtons();
	}
	
	private void clearButtons()
	{
		ViewGroup layout = (ViewGroup) findViewById(R.id.gameLayout);
		if(layout.getChildCount() > 2)
		{
			layout.removeViews(2, layout.getChildCount()-2);
		}
	}
	
	public void setButtons()
	{
		LinearLayout layout = (LinearLayout) findViewById(R.id.gameLayout);
		
		if(currPoint.hasChildren() && validChildren())
		{
			for(int i = 0; i < currPoint.getChildren().size(); i++)
			{
				layout.addView(createButton(i, false));
			}
		}
		else
		{
			layout.addView(createButton(0, true));
		}
	}
	
	private boolean validChildren()
	{
		boolean valid = true;
		
		ArrayList<Integer> children = currPoint.getChildren();
		for(int i = 0; i < children.size() && valid; i++)
		{
			if(children.get(i) >= points.size())
			{
				children.remove(i);
			}
		}
		
		if(children.size() == 0)
		{
			valid = false;
		}
		
		return valid;
	}
	
	private Button createButton(int i, final boolean gameover)
	{
		ArrayList<Integer> children = currPoint.getChildren();
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		
		Button button = new Button(this);
		button.setTag(i);
		button.setLayoutParams(params);
		button.setGravity(Gravity.CENTER);
		button.setTypeface(android.graphics.Typeface.MONOSPACE, android.graphics.Typeface.BOLD);
		if(Services.checkNightModeEnabled())
		{
			button.setTextColor(Color.parseColor("#e6e6e6"));
		} 
		else
		{
			button.setTextColor(getResources().getColor(R.color.brown));
		}
		
		if(gameover)
		{
			button.setText("Game Over.");
		}
		else
		{
			button.setText(points.get(children.get(i)).getReference());
		}
		
		button.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if(gameover)
				{
					gameOver();
				}
				else
				{
					currPoint = points.get(currPoint.getChildren().get((Integer) v.getTag()));
					setElements();
				}
			}
		});
		
		return button;
	}
	
	public void addToHistory(int pointID)
	{
		accessSaveData.insertHistoryPoint(pointID);
	}
	
	public void gameOver()
	{
		mp.stop();
		Intent intent = new Intent(ActivityGame.this, ActivityGameOver.class);
		startActivity(intent);
		finish();
	}
	
	@Override
	public void onDestroy()
	{
		mp.stop();
		super.onDestroy();
	}
}