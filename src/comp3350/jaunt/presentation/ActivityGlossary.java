package comp3350.jaunt.presentation;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import comp3350.jaunt.R;
import comp3350.jaunt.application.Services;
import comp3350.jaunt.business.AccessStoryPoints;
import comp3350.jaunt.objects.StoryPoint;

public class ActivityGlossary extends Activity 
{
	private static ScrollView unclicked;
	private static RelativeLayout clicked;
	
	private AccessStoryPoints accessPoints;
	private ArrayList<StoryPoint> points;
	
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
		setContentView(R.layout.activity_glossary);
		
		unclicked = (ScrollView) findViewById(R.id.unclickedLayout);
		clicked = (RelativeLayout) findViewById(R.id.clickedLayout);
		
		accessPoints = new AccessStoryPoints();
		points = new ArrayList<StoryPoint>();
		accessPoints.getStoryPoints(points);
		
		createButtons();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.activity_glossary, menu);
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
	
	private void createButtons()
	{	
		LinearLayout layout = (LinearLayout) findViewById(R.id.ids);
		
		for(int i = 0; i < points.size(); i++)
		{
			Button button = new Button(this);
			StoryPoint currPoint = points.get(i);
			String text = String.format("%-5d%-10s", i, currPoint.getTitle());
			button.setText(text);
			button.setTag(i);
			button.setPadding(0, 25, 0, 25);
			if(Services.checkNightModeEnabled())
			{
				button.setTextColor(Color.parseColor("#e6e6e6"));
			}
			else
			{
				button.setTextColor(getResources().getColor(R.color.brown));
			}
			button.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v) 
				{
					onPointClick(v, v.getId());
				}
			});
		
			layout.addView(button);
		}
	}
	
	private void setStoryLayouts(View v)
	{
		StoryPoint currPoint = points.get((Integer) v.getTag());
		TextView title = (TextView) findViewById(R.id.editTitle);
		TextView text = (TextView) findViewById(R.id.editText);
		title.setText(currPoint.getTitle());
		text.setText(currPoint.getText());
	}
	
	public void onPointClick(View v, int id)
	{
		unclicked.setClickable(false);
		unclicked.setVisibility(View.INVISIBLE);
		clicked.setClickable(true);
		clicked.setVisibility(View.VISIBLE);
		setStoryLayouts(v);
	}
	
	public void onDoneClick(View v)
	{
		unclicked.setClickable(true);
		unclicked.setVisibility(View.VISIBLE);
		clicked.setClickable(false);
		clicked.setVisibility(View.GONE);
	}
}