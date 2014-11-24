package com.adroit.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


/**
 * <h2>Utilities for view related operations</h2>
 * @author app-ad
 * */
public class ViewUtils
{
	
	/**
	 * Purpose - Find the view with explicit type checking. 
	 * 
	 * @param context Current context of an activity from where the method is called.
	 * @param id Id generated for the field whose view is to be found.
	 * @return view if found and null if view is not found.
	 * */
	@SuppressWarnings("unchecked")
	public static <T extends View> T findViewById(Activity context, int id)
	{
		T view = null;
		View genericView = context.findViewById(id);
		try
		{
			view = (T)(genericView);
		}
		catch(Exception e)
		{
			String message = "Could not cast view with exception: "+ e;
			throw new ClassCastException(message);
		}
		return view;
	}
	
	 /**
     * Purpose - Hide the keyboard from the current view that holds the focus.
     *
     * @param context The current Activity Context this method is called from.
     * @param view Current view that holds keyboard focus
     * @param flags Additional operational flags for hiding soft input from window.
     */
	public static void removeKeyboard(Context context, View view, int flags)
	{
		try
		{
			InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(view.getWindowToken(), flags);
		}
		catch(Exception exp)
		{
			Log.e("Adroit", "Unable to hide keyboard with exception: "+exp);
		}
	}
	
	 /**
     * Purpose - Show the soft keyboard focused on a field.
     *
     * @param context Activity/Context
     * @param field   field that requests focus
     */
    public static void showKeyboard(Context context, View field){
        try 
        {
            field.requestFocus();
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(field, InputMethodManager.SHOW_IMPLICIT);
        }
        catch (Exception exp) 
        {
            Log.e("Adroit", "Unable to show keyboard with exception:" + exp);
        }
    }
    
    /**
     * Purpose - Make a view visible\invisible for an activity.
     * 
     * @param context Current Activity context
     * @param id	Resource id for the view
     * @param visible	If true, would make the view visible, else will hide it.
     * */
    public static void setVisible(Activity context, int id, boolean visible)
    {
    	View view = ViewUtils.findViewById(context, id);
    	if(view != null)
    	{
    		if(visible)
    		{
    			view.setVisibility(View.VISIBLE);
    		}
    		else
    		{
    			view.setVisibility(View.GONE);
    		}
    	}
    	else
    	{
    		Log.e("Adroit", "View does not exist.");
    	}
    }
}
