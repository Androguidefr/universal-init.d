package com.androguide.universal.initd;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.CompoundButton;
import de.ankri.views.Switch;

public class Main extends Activity {

	Switch toggle;
	SharedPreferences prefs;
	Boolean isOn;
	Boolean test;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		prefs = getSharedPreferences("INITD_PREFS", 0);
		isOn = prefs.getBoolean("IS_ON", false);
		Log.v("TOGGLE", "The toggle is" + isOn);

		toggle = (Switch) findViewById(R.id.toggle);

		if (isOn == true)
			toggle.setChecked(true);
		else
			toggle.setChecked(false);

		toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

				if (toggle.isChecked()) {

					Editor e = prefs.edit();
					e.putBoolean("IS_ON", true);
					e.commit();
					
					test = true;
					Log.v("TOGGLE", "The toggle is" + test);

				} else {

					Editor e = prefs.edit();
					e.putBoolean("IS_ON", false);
					e.commit();
					
					test = false;
					Log.v("TOGGLE", "The toggle is" + test);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
