package com.travelbudget.travelbudget;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Conner on 11/9/2015.
 */
public class SharedPrefManager {
    public static final String MY_EMP_PREFS = "MySharedPref";

    private static Context mContext;

    private static String mpgs = "";

    private static String food = "";

    private static String hotelPrice = "";

    private static String mileage = "";

    private static String misc = "";

    private static String added = "";

    private static String added1 = "";

    private static String total = "";

    private static Integer finalMPGS = 0;

    public static void Init(Context context){
        mContext = context;
    }
    public static void LoadFromPref()
    {
        SharedPreferences settings = mContext.getSharedPreferences(MY_EMP_PREFS, 0);

        mpgs = settings.getString("MPG's", "");

        food = settings.getString("Food", "");

        hotelPrice = settings.getString("Hotel price", "");

        mileage = settings.getString("Total mileage", "");

        misc = settings.getString("Extra spending", "");

        added = settings.getString("Add food", "");

        added1 = settings.getString("Add other", "");

        total = settings.getString("Totals", "");

        finalMPGS = settings.getInt("Final", 0);
    }

    public static void StoreToPref() {

        SharedPreferences settings = mContext.getSharedPreferences(MY_EMP_PREFS, 0);

        SharedPreferences.Editor editor = settings.edit();

        editor.putString("MPG's", mpgs);
        editor.putString("Food", food);
        editor.putString("Hotel price", hotelPrice);
        editor.putString("Total mileage", mileage);
        editor.putString("Extra spending", misc);
        editor.putString("Add food", added);
        editor.putString("Add other", added1);
        editor.putString("Totals", total);
        editor.putInt("Final", finalMPGS);

        editor.commit();

    }

    public static void DeleteSingleEntryFromPref(String keyName)
    {
        SharedPreferences settings = mContext.getSharedPreferences(MY_EMP_PREFS, 0);

        SharedPreferences.Editor editor = settings.edit();
        editor.remove(keyName);
        editor.commit();
    }

    public static void DeleteAllEntriesFromPref()
    {
        SharedPreferences settings = mContext.getSharedPreferences(MY_EMP_PREFS,0);

        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.commit();
    }

    public static void setMpgs (String a)
    {
        mpgs = a;
    }

    public static void setFood (String b)
    {
        food = b;
    }

    public static void setHotel (String c)
    {
        hotelPrice = c;
    }

    public static void setPeople (String d) {mileage = d;}

    public static void setMisc (String e) {misc = e;}

    public static void setAdded (String f) {added = f;}

    public static void setAdded1 (String g) {added1 = g;}

    public static void setTotal (String h) {total = h;}

    public static void setFinalMPGS (Integer i) {finalMPGS = i;}

    public static String getMpgs() {return mpgs;}

    public static String getFood() {return food;}

    public static String getHotel() { return hotelPrice;}

    public static String getPeople() {return mileage;}

    public static String getMisc() {return misc;}

    public static String getAdded() {return added; }

    public static String getAdded1() {return added1; }

    public static String getTotal() {return total;}

    public static Integer getFinalMPGS() {return finalMPGS;}

}