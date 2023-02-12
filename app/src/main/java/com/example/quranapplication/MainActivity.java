package com.example.quranapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.text1);
        String jsondata="";
        try {

            InputStream is = getAssets().open("QuranMetaData.json");
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
        List<QuranModel> objectList = gson.fromJson(jsondata, listType);

//        for(int i=0;i<10;i++)
//        {
//            t1.setText(t1.getText()+objectList.get(i).getSurah_name());
//        }
        t1.setText(getParahDetail(objectList,1));

    }

    String getParahDetail(List<QuranModel> list1,int num)
    {
        String str1="";
        for(QuranModel objQuran:list1)
        {
            if(objQuran.getJuz()==num)
            {
                str1=str1+objQuran.getSurah_number()+". "+objQuran.getSurah_name()+"\n\n\n";
            }
        }
        return str1;
    }



}