package com.adroit.utils;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;


/**
 * <h2>Utility methods for an Activity.</h2>
 * @author app-ad.
 * */
public class ActivityUtils 
{
	
	/**
	 * Purpose - Launch an activity
	 * 
	 *  @param packageContext - Current context
	 *  @param flags - Intent flags to launch with the activity
	 *  @param pairs - parameters to the activity as a Bundle
	 *  @param closeCurrentContext - whether or not to close the current activity\service
	 *  @param activity - Activity to launch
	 * 
	 * */
	public static void openActivity(Context packageContext, int flags, Map<String, String> pairs, boolean closeCurrentContext, Class<?> activity)
	{
		if(packageContext == null)
			return;
		Intent intent = new Intent(packageContext, activity);
		//set the intent flags if any
		intent.setFlags(flags);
		if(pairs != null && !pairs.isEmpty())
		{
			Bundle extras = new Bundle();
			for(Entry<String, String> pair: pairs.entrySet())
			{
				extras.putString(pair.getKey(), pair.getValue());
			}
			intent.putExtras(extras);
		}
		//start the activity
		packageContext.startActivity(intent);
		//Close the current context
		if(closeCurrentContext)
		{
			if(packageContext instanceof Activity)
			{
				((Activity)packageContext).finish();
			}
			else if(packageContext instanceof Service)
			{
				((Service)packageContext).stopSelf();
			}
		}
	}
	
	 /**
     * Purpose - Force screen to turn on if the phone is asleep.
     *
     * @param context The current Activity Context from which this method is called
     */
    public static void turnScreenOn(Activity context) 
    {
    	if(context == null)
			return;
        try 
        {
            Window window = context.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
            window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
            window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        }
        catch (Exception ex) 
        {
            Log.e("Adroit", "Unable to turn on screen for activity " + context);
        }
    }
    
	/**
     * Used to get the parameter values passed into Activity via a Bundle.
     *
     * @param context The current Context or Activity from which this method is called
     * @param key     Extra key name.
     */
    public static Object getExtraObject(Activity context, String key) 
    {
    	if(context == null)
			return null;
        Object param = null;
        Bundle bundle = context.getIntent().getExtras();
        if (bundle != null) 
        {
            param = bundle.get(key);
        }
        return param;
    }
    
    /**
     * Purpose - Before trigerring an implicit intent check if there is any registered activity
     * 
     *  @param context Current Activity context
     *  @param intent Implicit Intent to be called
     * */
    public static boolean isIntentSafe(Context context, Intent intent)
    {
    	if(context == null)
			return false;
    	PackageManager packageMgr = context.getPackageManager();
    	List<ResolveInfo> activities = packageMgr.queryIntentActivities(intent, 0);
    	return (activities.size() > 0);
    }
    
    /**
     * Purpose - Before triggering broadcast check if there is any registered receivers
     * 
     *  @param context Current Activity context
     *  @param intent Intent to be called
     * */
    public static boolean isBroadcastSafe(Context context, Intent intent)
    {
    	if(context == null)
			return false;
    	PackageManager packageMgr = context.getPackageManager();
    	List<ResolveInfo> receivers = packageMgr.queryBroadcastReceivers(intent, 0);
    	return (receivers.size() > 0);
    }
}
