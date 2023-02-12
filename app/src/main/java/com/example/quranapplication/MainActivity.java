package com.example.quranapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView t1;
    ArrayList<String> arrayList =new ArrayList<>();
    ListView list;

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
      //  t1.setText(getParahDetail(objectList,1));
        list=findViewById(R.id.mylistView1);
        arrayList=getSurahNames(objectList,30);
     //   arrayList.add("Red");
       // arrayList.add("blue");
       // arrayList.add("green");
       // arrayList.add("2. 898888");
        //t1.setText(arrayList.size());

        ArrayAdapter ad=new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,arrayList);
        list.setAdapter(ad);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,item +" is Clicked",Toast.LENGTH_LONG).show();
               String []obj1=item.split(". ");
                Intent intent = new Intent(MainActivity.this, SurahActivity.class);
                int number=123456;

                intent.putExtra("WelcomeMessage","السلام علیکم");
                intent.putExtra("nmbr",number);
                intent.putExtra("Parah",Integer.parseInt(obj1[0]));
                intent.putExtra("ParahName",obj1[1]);
                intent.putExtra("array_list",getAyatDetail(objectList,78));
                startActivity(intent);

//               arrayList.removeAll(arrayList);
               // t1.setText(getAyatDetail(objectList,78).toString());
               //t1.setText(getAyatDetail(objectList,78).get(1));
             //   t1.setText(obj1[0]+"--"+obj1[1]);
//                ArrayAdapter ad1=new ArrayAdapter(MainActivity.this,
//                        android.R.layout.simple_list_item_1,arrayList);
//                list.setAdapter(ad1);
//
            }
        });

    }

    ArrayList<String> getSurahNames(List<QuranModel> list1,int num)
    {
        String str1="";
        ArrayList<String> arrayList=new ArrayList<>();
        for(QuranModel objQuran:list1)
        {
           if(objQuran.getJuz()==num)
            {
                //str1=str1+objQuran.getSurah_number()+". "+objQuran.getSurah_name()+"\n\n\n";
                String st=Integer.toString(objQuran.getSurah_number()) + ". " + objQuran.getSurah_name().toString();
                if(arrayList.indexOf(st)<0)
                {
                    arrayList.add(st);
                }
            }
        }
        return arrayList;
    }

    ArrayList<String> getAyatDetail(List<QuranModel> list1,int num)
    {
        ArrayList<String> arrayList1=new ArrayList<>();
        for(QuranModel objQuran:list1)
        {
            if(objQuran.getSurah_number()==num)
            {
                //str1=str1+objQuran.getSurah_number()+". "+objQuran.getSurah_name()+"\n\n\n";
                String st=objQuran.getText();
                if(arrayList1.indexOf(st)<0)
                {
                    arrayList1.add(st);
                }
            }
        }
        return arrayList1;
    }



}