package com.adroit.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * <h2>Utility for networking operations.</h2>
 * @author app-ad
 * */
public class NetworkUtils 
{
	
	/**
	 * Purpose - Check if network connection is available or not.
	 * 
	 * @param context Current Activity\Context from which this method is called 
	 * 
	 * */
	public static boolean isOnline(Context context) 
	{
	    ConnectivityManager connMgr = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
	    return (networkInfo != null && networkInfo.isConnected());
	} 
	
	/**
	 * Purpose - Check if wifi connection is available or not
	 * 
	 * @param context Current Activity\Context from which this method is called
	 * 
	 * */
	public static boolean isConnectedWifi(Context context) 
	{
	    ConnectivityManager connMgr = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
	    return (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == ConnectivityManager.TYPE_WIFI);
	} 
	
	/**
	 * Purpose - Check if mobile network connection is available or not
	 * 
	 * @param context Current Activity\Context from which this method is called
	 * 
	 * */
	public static boolean isConnectedMobile(Context context) 
	{
	    ConnectivityManager connMgr = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
	    return (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE);
	} 
	
	/**
	 * Purpose - Check if dummy network connection is available or not
	 * 
	 * @param context Current Activity\Context from which this method is called
	 * 
	 * */
	public static boolean isConnectedDummy(Context context) 
	{
	    ConnectivityManager connMgr = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
	    return (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == ConnectivityManager.TYPE_DUMMY);
	} 
	
	
	/**
	 * Purpose - Check if ethernet network connection is available or not
	 * 
	 * @param context Current Activity\Context from which this method is called
	 * 
	 * */
	public static boolean isConnectedEthernet(Context context) 
	{
	    ConnectivityManager connMgr = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
	    return (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == ConnectivityManager.TYPE_ETHERNET);
	} 
}
