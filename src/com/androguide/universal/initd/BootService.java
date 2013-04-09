package com.androguide.universal.initd;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.util.Log;

public class BootService extends Service {

	SharedPreferences prefs;
	Boolean execute;

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	protected Void doInBackground(Void... args) {

		prefs = getSharedPreferences("INITD_PREFS", 0);
		execute = prefs.getBoolean("IS_ON", false);

		if (execute == true) {

			CMDProcessor cmd = new CMDProcessor();
			// execute all scripts located in /system/etc/init.d
			cmd.su.runWaitFor("sh /system/etc/init.d/*");

			Log.v("SERVICE", "The Switch is ON, execute scripts");

		} else {

			Log.v("SERVICE", "The Switch is OFF, DO NOTHING");
		}

		Log.v("BOOT SERVICE", "THE SERVICE HAS BEEN EXECUTED");
		return null;
	}

}
