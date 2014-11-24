package com.adroit.utils;

import java.util.Map;
import java.util.Map.Entry;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


/**
 * <h2>Utility methods for a Service</h2>
 * @author app-ad
 * */
public class ServiceUtils 
{
	
	/**
	 * Purpose - Launch an service
	 * 
	 *  @param packageContext - Current context from which this method is called.
	 *  @param flags - Intent flags to launch with the service.
	 *  @param pairs - parameters to the service as a Bundle.
	 *  @param service - Service to launch.
	 * */
	public static void openService(Context packageContext, int flags, Map<String, String> pairs, boolean closeCurrentContext, Class<?> service)
	{
		if(packageContext == null)
			return;
		 Intent intent = new Intent(packageContext, service);
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
		 packageContext.startService(intent);
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
	 * Purpose - Find the system service with explicit type checking.
	 * 
	 *  @param context - Current context.
	 *  @param propertyName - Property name to fetch from the current context
	 * */
	public static <T extends Object> T getSystemService(Context context, String propertyName) 
	{
		if(context == null)
			return null;
		T service = null;
		Object genericService = context.getSystemService(propertyName);
		try
		{
			service = (T)(genericService);
		}
		catch(Exception e)
		{
			String message = "Could not service view with exception: "+ e;
			throw new ClassCastException(message);
		}
		return service;
	}
}
