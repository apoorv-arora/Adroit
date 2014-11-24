package com.adroit.utils;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * <h2>Utility methods for a Receiver</h2>
 * @author app-ad
 * */
public class ReceiverUtils 
{
	/*
	 * Constants for alarmType: InExactRepeating, Exact and Repeating.
	 * */
	private static final int INEXACT_REPEATING = 0;
	private static final int EXACT = 1;
	private static final int REPEATING = 2;

	/**
	 * Purpose - Trigger a receiver as defined in android:enabled property in the manifest file.
	 * 
	 *  @param context Current Activit\Context from which this method is called
	 *  @param newState Set the new state of the component. Check PackageManager.COMPONENT_ENABLED_STATE_ENABLED and PackageManager.COMPONENT_ENABLED_STATE_DISABLED
	 *  @param flags Optional behavior. Pass PackageManager.DONT_KILL_APP or 0.
	 *  @param receiver Class object of the desired component
	 * */
	public static void triggerComponent(Context context, int newState, int flags, Class<?> receiver)
	{
		if(context == null)
    		return;
		//trigger boot receiver
	    ComponentName componentReceiver = new ComponentName(context, receiver);
	    PackageManager packageMgr = context.getPackageManager();
	    packageMgr.setComponentEnabledSetting(componentReceiver, newState, flags);
	}
	
	/**
	 * Purpose - Sets an alarm and triggers the receiver.
	 * 
	 * @param context Current Activity\Context from which this method is called
	 * @param alarmType One of INEXACT_REPEATING, EXACT, or REPEATING.
	 * @param type One of ELAPSED_REALTIME, ELAPSED_REALTIME_WAKEUP, RTC, or RTC_WAKEUP.
	 * @param triggerAtMillis time in milliseconds that the alarm should first go off, using the appropriate clock (depending on the alarm type). 
	 * @param interval interval in milliseconds between subsequent repeats of the alarm
	 * @param requestCode Private request code for the sender
	 * @param flags May be FLAG_ONE_SHOT, FLAG_NO_CREATE, FLAG_CANCEL_CURRENT, FLAG_UPDATE_CURRENT, or any of the flags as supported by Intent.fillIn() to control which unspecified parts of the intent that can be supplied when the actual send happens.
	 * @param alarmReceiver Class object of the receiver which will be triggered
	 * 
	 * */
	@TargetApi(Build.VERSION_CODES.KITKAT)
	public static void setAlarm(Context context, int alarmType, int type, int triggerAtMillis, int interval, int requestCode, int flags, Class<?> alarmReceiver)
    {
    	if(context == null)
    		return;
    	AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, alarmReceiver);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, requestCode, intent, flags);

        switch(alarmType)
        {
	        case ReceiverUtils.INEXACT_REPEATING:
	        				alarmMgr.setInexactRepeating(type, triggerAtMillis*1000, interval*1000, alarmIntent);
	        				break;
	        case ReceiverUtils.EXACT:
							alarmMgr.setExact(type, triggerAtMillis*1000, alarmIntent);
							break;
	        case ReceiverUtils.REPEATING:
							alarmMgr.setRepeating(type, triggerAtMillis*1000, interval*1000, alarmIntent);
							break;
        }
    }
	
	/**
	 * Purpose - Removes any alarm with the maching intent.
	 * 
	 * @param context Current Activity\Context from which this method is called
	 * @param alarmMgr One of INEXACT_REPEATING, EXACT, or REPEATING.
	 * @param alarmIntent Intent to match for removal
	 * */
    public void cancelAlarm(Context context, AlarmManager alarmMgr, PendingIntent alarmIntent)
    {
    	if(context == null)
    		return;
        if (alarmMgr!= null)
        {
            alarmMgr.cancel(alarmIntent);
        }
    }
}
