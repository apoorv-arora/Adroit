package com.adroit.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;


/**
 * <h2>Utility methods for alert dialog</h2>
 * @author app-ad
 * */
public class DialogUtils 
{
	
	/**
	 * Purpose - Constructs and displays a dialog. Default listener dismiss the dialog.
	 * 
	 * @param context Current context from which this method is called 
	 * @param title Title of the dialog box
	 * @param message Message of the dialog box
	 * @return AlertDialog object is returned so that onClickListener can be specified.
	 * */
	public static AlertDialog displayDialog(Context context, String title, String message)
	{
		if(context == null)
			return null;
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setPositiveButton(android.R.string.ok, closeDialogListener()); 
		AlertDialog dialog = builder.create();
        dialog.show();
        return dialog;
	}
	
	/**
	 * Purpose - Default on click listener which dismissed the dialog.
	 * */
	public static OnClickListener closeDialogListener() 
    {
		return new OnClickListener ()
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				dialog.dismiss();		
			}
		};
    }
}
