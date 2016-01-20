package comp3350.jaunt.presentation;

import comp3350.jaunt.R;
import comp3350.jaunt.application.Services;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class DialogSettings extends DialogFragment implements android.view.View.OnClickListener
{
	private Context mContext;
	private boolean nightMode=Services.checkNightModeEnabled();
	
	public DialogSettings(Context ctx)
	{
		mContext = ctx;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		super.onCreateDialog(savedInstanceState);
		
		Dialog diag = new Dialog(mContext);
		
		diag.setCanceledOnTouchOutside(false);
		diag.setContentView(R.layout.dialog_settings);
		diag.setTitle(R.string.action_settings);
		
		ToggleButton tb = (ToggleButton) diag.findViewById(R.id.toggleNightMode);
		tb.setChecked(Services.checkNightModeEnabled());
		tb.setOnClickListener(this);

		Button btn = (Button) diag.findViewById(R.id.settingsCloseButton);
		btn.setOnClickListener(this);
		
		TextView txt = (TextView) diag.findViewById(R.id.textNightMode);
		txt.setTextColor(getResources().getColor(R.color.black));

		return diag;
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
			case R.id.toggleNightMode:
				nightMode = !nightMode;
				break;
			case R.id.settingsCloseButton:
				if(Services.checkNightModeEnabled() != nightMode)
				{
					Services.toggleNightMode(mContext);
				}
				dismiss();
				break;
			default:
				break;
		}
	}
}