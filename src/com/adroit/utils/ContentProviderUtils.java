package com.adroit.utils;

import java.util.Map;
import java.util.Map.Entry;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;


/**
 * <h2>Utility methods for Content Providers</h2>
 * @author app-ad
 * */
public class ContentProviderUtils 
{
	
	/**
	 * Purpose - Put shared preferences through the Shared Preferences API. 
	 * Use this if you need multiple shared preference files identified by name.
	 * 
	 * @param context - Current context
	 * @param prefName - Desired preferences file name
	 * @param mode - Mode to open shared preferences
	 * @param pairs - map to put in shared preferences
	 * */
	public static void putSharedPrefs(Context context, String prefName, int mode, Map<String, String> pairs)
	{
		SharedPreferences prefs = context.getSharedPreferences(prefName, mode);
		if(pairs != null && !pairs.isEmpty())
		{
			SharedPreferences.Editor editor = prefs.edit();
			for(Entry<String, String> pair: pairs.entrySet())
			{
				editor.putString(pair.getKey(), pair.getValue()).commit();
			}
			editor.commit();
		}	
	}
	
	/**
	 * Purpose - Put preferences through the Shared Preferences API. 
	 * Use this from an activity if you need to use only one shared preference file for the activity
	 * 
	 * @param context - Activity context
	 * @param mode - Mode to open shared preferences
	 * @param pairs - map to put in shared preferences
	 * */
	public static void putPrefs(Activity context, int mode, Map<String, String> pairs)
	{
		SharedPreferences prefs = context.getPreferences(mode);
		if(pairs != null && !pairs.isEmpty())
		{
			SharedPreferences.Editor editor = prefs.edit();
			for(Entry<String, String> pair: pairs.entrySet())
			{
				editor.putString(pair.getKey(), pair.getValue());
			}
			editor.commit();
		}
	}
}
