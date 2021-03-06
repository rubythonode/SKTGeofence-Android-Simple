package com.btncafe.android.sktgeofence;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.skt.geofence.GeoConstData;

public class SKTGeofenceServiceReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		if (intent.getAction().equals(SKTGeofence.getAppData().packageName + ".GEOEVENT")) {

			int storeId = intent.getIntExtra(GeoConstData.STORE_ID, 0);

			CheckInHandler checkInHandler = SKTGeofence.getCheckInHandler();
			
			if (checkInHandler != null) {
				checkInHandler.handle(storeId);
			}
		}
	}
}