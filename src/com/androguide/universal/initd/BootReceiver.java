package com.androguide.universal.initd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0,

	Intent arg1) {
		// When Boot is Completed, do the following

		Log.v("BOOT SERVICE","THE BOOT IS COMPLETED");
		
		Intent mIntent = new Intent(arg0, BootService.class);
		arg0.startService(mIntent);

		// Now we need to add the correct permissions to the
		// AndroidManifest.xml, as well as declare our BroadcastReceiver &
		// Service setup an intent-filter for
		// them and a service for the... well the Service^^
	}

}
