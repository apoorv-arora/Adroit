package com.adroit.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * <h2>Check if Hardware features like gps, nfc, camera, etc. are present\enabled in the device.</h2>
 * @author app-ad
 * */
public class FeatureUtils 
{
	/**
	 * Purpose - Check if GPS is present.
	 * 
	 * @param context Current Activity\Context from which this method is called
	 * */
	public static boolean getGPSPresentStatus(Context context)
	{
		if(context == null)
			return false;
		PackageManager pm = context.getPackageManager();
		return pm.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS);
	}
	
	/**
	 * Purpose - Check if NFC is present and android beam file transfer is supported.
	 * Note: This checks for API 17 and above and then checks the feature as earlier versions do not support NFC. 
	 * 
	 * @param context Current Activity\Context from which this method is called
	 * */
	public static boolean IsNFCPresent(Context context)
	{
		if(context == null)
			return false;
		PackageManager pm = context.getPackageManager();
		return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && pm.hasSystemFeature(PackageManager.FEATURE_NFC));
	}
	
	/**
	 * Purpose - Check if Camera is present.
	 * 
 	 * @param context Current Activity\Context from which this method is called
	 * */
	public static boolean IsCameraPresent(Context context)
	{
		if(context == null)
			return false;
		PackageManager pm = context.getPackageManager();
		return (pm.hasSystemFeature(PackageManager.FEATURE_CAMERA));
	}
	
	/**
	 * Purpose - Check if Bluetooth is present.
	 * 
 	 * @param context Current Activity\Context from which this method is called
	 * */
	public static boolean IsBluetoothPresent(Context context)
	{
		if(context == null)
			return false;
		PackageManager pm = context.getPackageManager();
		return (pm.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH));
	}
	
	/**
	 * Purpose - Check if blue tooth is available or not
	 * 
	 * @param context Current Activity\Context from which this method is called
	 * 
	 * */
	public static boolean isBluetoothEnabled(Context context) 
	{
		if(context == null || (!FeatureUtils.IsBluetoothPresent(context)))
			return false;
		BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter(); 
		return mBluetoothAdapter.isEnabled();
	} 
}
