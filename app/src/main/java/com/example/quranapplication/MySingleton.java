package com.example.quranapplication;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MySingleton {
    private static MySingleton instance;
    private List<QuranModel> myList;
    Context context;


    private MySingleton() {
        String jsondata="";
        AssetManager assetManager = context.getAssets();
        try {

            InputStream is = assetManager.open("QuranMetaData.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsondata = new String(buffer, "UTF-8");
            System.out.println(jsondata);
            // t1.setText(jsondata.toString());
            // t1.setText("qwerty");
        }
        catch (Exception ex)
        {
            System.out.println("Exception ocuur");
        }

        Gson gson = new Gson();
        Type listType = new TypeToken<List<QuranModel>>(){}.getType();
        myList = gson.fromJson(jsondata, listType);
       // myList = new ArrayList<QuranModel>();

    }


    public MySingleton(Context context){
        this.context = context;
    }


    public static synchronized MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }

        return instance;
    }

    public List<QuranModel> getMyList() {
        return myList;
    }

    public void setMyList(List<QuranModel> myList) {
        this.myList = myList;
    }
}
