package com.huylv.uniplayer.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;

import com.google.firebase.database.FirebaseDatabase;
import com.huylv.uniplayer.model.Song;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by HuyLV-CT on 18-Aug-16.
 */
public class Config {

    public static final String Firebase_Url = "https://uniplayer-849b7.firebaseio.com/";
    public static final String CSN_URL = "http://chiasenhac.vn/";
    public static File rootFolder = new File(Environment.getExternalStorageDirectory() + File.separator + "music");
    public static ArrayList<Song> localSongList = new ArrayList<>();
    public static ArrayList<Song> serverSongList = new ArrayList<>();
    public static ArrayList<Song> songToDownload = new ArrayList<>();
    public static ArrayList<Song> songToDelete = new ArrayList<>();
    public static FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    public static Song playingSong;

    public static String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }

    public static Bitmap StringToBitMap(String encodedString){
        try {
            byte [] encodeByte= Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static boolean isOnline(Context c) {
        ConnectivityManager cm =
                (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static void createRootFolder() {
        //create root directory
        boolean success = true;
        if (!rootFolder.exists()) {
            success = rootFolder.mkdir();
        } else {
            Log.e("cxz", "root folder exist");
        }
        if (success) {
            Log.e("cxz", "root folder created");
        } else {
            Log.e("cxz", "create error");
        }
    }
}
