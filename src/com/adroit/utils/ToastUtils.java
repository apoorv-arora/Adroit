package com.adroit.utils;

import android.content.Context;
import android.widget.Toast;


/**
 * <h2>Utility methods for toast notifications</h2>
 * @author app-ad
 * */
public class ToastUtils 
{
	
	/**
	 * Purpose - Display a toast notification.
	 * 
	 *  @param context Activity context which is calling this method
	 *  @param message Message to be displayed as part of the Toast.
	 * */
	public static Toast quickToast(Context context, String message)
	{
		return quickToast(context, message, false);
	}
	
	/**
	 * Purpose - Display a toast notification with intended length.
	 * 
	 *  @param context Activity context which is calling this method
	 *  @param message Message to be displayed as part of the Toast.
	 *  @param toastLength If true, hold the toast for long, else hold the toast for short interval.
	 * */
	public static Toast quickToast(Context context, String message, boolean toastLengthLong)
	{
		Toast toast;
		if(toastLengthLong)
		{
			toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
		}
		else
		{
			toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
		}
		toast.show();
		return toast;
	}
}
