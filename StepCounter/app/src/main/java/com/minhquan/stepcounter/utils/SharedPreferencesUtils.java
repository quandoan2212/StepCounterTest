package com.minhquan.stepcounter.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.minhquan.stepcounter.App;

public class SharedPreferencesUtils {
    private static final String PREF_NAME = "Step_History";
    private static SharedPreferencesUtils mInstance;
    private SharedPreferences mSharedPreferences;

    private SharedPreferencesUtils(){
        mSharedPreferences = App.self().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPreferencesUtils getInstance(){
        if(mInstance == null){
            mInstance = new SharedPreferencesUtils();
        }
        return mInstance;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> anonymousClass){
        if(anonymousClass == String.class){
            return (T) mSharedPreferences.getString(key, "");
        }else if(anonymousClass == Boolean.class){
            return (T) Boolean.valueOf(mSharedPreferences.getBoolean(key,false));
        }else if(anonymousClass == Float.class){
            return (T) Float.valueOf(mSharedPreferences.getFloat(key,0));
        }else if(anonymousClass == Integer.class){
            return  (T) Integer.valueOf(mSharedPreferences.getInt(key,0));
        }else if(anonymousClass == Long.class){
            return (T) Long.valueOf(mSharedPreferences.getLong(key,0));
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> anonymousClass, Object dataDef){
        if(anonymousClass == String.class){
            return (T) mSharedPreferences.getString(key, (String) dataDef);
        }else if(anonymousClass == Boolean.class){
            return (T) Boolean.valueOf(mSharedPreferences.getBoolean(key,(Boolean) dataDef));
        }else if(anonymousClass == Float.class){
            return (T) Float.valueOf(mSharedPreferences.getFloat(key,(Float) dataDef));
        }else if(anonymousClass == Integer.class){
            return  (T) Integer.valueOf(mSharedPreferences.getInt(key,(Integer) dataDef));
        }else if(anonymousClass == Long.class){
            return (T) Long.valueOf(mSharedPreferences.getLong(key,(Long) dataDef));
        }
        return null;
    }

    public <T> void put(String key, T data){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        if(data instanceof String){
            editor.putString(key, (String) data);
        }else if(data instanceof Boolean){
            editor.putBoolean(key,(Boolean) data);
        }else if(data instanceof Integer){
            editor.putInt(key,(Integer) data);
        }else if(data instanceof Float) {
            editor.putFloat(key, (Float) data);
        }else if(data instanceof Long) {
            editor.putLong(key, (Long) data);
        }
        editor.apply();
    }

    public void clear(){
        mSharedPreferences.edit().clear().apply();
    }
}
