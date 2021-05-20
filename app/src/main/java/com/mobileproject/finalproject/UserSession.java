package com.mobileproject.finalproject;


import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.RegionIterator;
import android.webkit.RenderProcessGoneDetail;

public class UserSession {
    // Shared Preferences reference
    SharedPreferences Registration;

    // Editor reference for Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Shared preferences mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    public static final String PREFER_NAME = "Registration";

    // All Shared Preferences Keys
    public static final String IS_USER_LOGIN = "IsUserLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "Name";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "Email";

    // password
    public static final String KEY_PASSWORD = "Password";

    public static final String KEY_BIMBELID = "Id Bimbel";

    // Constructor
    public UserSession(Context context){
        this._context = context;
        Registration = _context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = Registration.edit();
    }

    //Create login session
    public void createUserLoginSession(String uEmail, String uPassword){
        // Storing login value as TRUE
        editor.putBoolean(IS_USER_LOGIN, true);

        // Storing name in preferences
        editor.putString(KEY_EMAIL,  uEmail);
        editor.putString(KEY_PASSWORD,uPassword);

        // commit changes
        editor.commit();
    }

    /**
     * Check login method will check user login status
     * If false it will redirect user to login page
     * Else do anything
     * */
    public boolean checkLogin(){
        // Check login status
        if(!this.isUserLoggedIn()){
            Intent moveToLoginActivity = new Intent(_context, MainActivity.class);
            moveToLoginActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            moveToLoginActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(moveToLoginActivity);

            return true;
        }
        return false;
    }

    public HashMap<String, String> getUserDetails(){

        //Use hashmap to store user credentials
        HashMap<String, String> user = new HashMap<String, String>();

        // user name
        user.put(KEY_NAME, Registration.getString(KEY_NAME, null));

        // user email id
        user.put(KEY_EMAIL, Registration.getString(KEY_EMAIL, null));
        user.put(KEY_PASSWORD, Registration.getString(KEY_PASSWORD,null));
        user.put(KEY_BIMBELID,Registration.getString(KEY_BIMBELID,null));

        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){

        // Clearing all user data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to MainActivity
        Intent i = new Intent(_context, MainActivity.class);

        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }


    // Check for login
    public boolean isUserLoggedIn(){
        return Registration.getBoolean(IS_USER_LOGIN, false);
    }
}
