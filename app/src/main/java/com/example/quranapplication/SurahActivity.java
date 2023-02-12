package com.example.quranapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SurahActivity extends AppCompatActivity {

    private TextView t1;
    ArrayList<String> arrayList =new ArrayList<>();
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);

        list=findViewById(R.id.mylistView1);
        t1=findViewById(R.id.text3);
        List<QuranModel> objectList=MainActivity.objectList;
        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                JsonHelper.getSurahNames(objectList,30));
        list.setAdapter(ad);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                Toast.makeText(SurahActivity.this,item +" is Clicked",Toast.LENGTH_LONG).show();
                String []obj1=item.split(". ");
                Intent intent = new Intent(SurahActivity.this, AyatActivity.class);
                int number=123456;

                intent.putExtra("WelcomeMessage","السلام علیکم");
                intent.putExtra("nmbr",number);
                intent.putExtra("Parah",Integer.parseInt(obj1[0]));
                intent.putExtra("ParahName",obj1[1]);
                intent.putExtra("array_list",JsonHelper.getAyatDetail(objectList,Integer.parseInt(obj1[0])));
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


        //Intent intent = getIntent();
        //List<QuranModel> objectList = (List<QuranModel>) getIntent().getSerializableExtra("objectList");
        //List<QuranModel> objectList = (List<QuranModel>) getIntent().getSerializableExtra("objectList");
        //String str=intent.getStringExtra("objectList");
        //t1.setText(str);


//        for (QuranModel quranModel : objectList) {
//            Log.d("TAG", "Surah Name: " + quranModel.getSurah_name());
//            Log.d("TAG", "Surah Number: " + quranModel.getSurah_number());
//            Log.d("TAG", "Surah Ayat: " + quranModel.getJuz());
//        }
//       ArrayList<String> arrayList = new ArrayList<>();
//       arrayList.add("Red");
//       arrayList.add("green");
//
//        ArrayAdapter ad=new ArrayAdapter(this,
//                android.R.layout.simple_list_item_1,arrayList);
//        list.setAdapter(ad);

//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String item = (String) parent.getItemAtPosition(position);
//                Toast.makeText(SurahActivity.this,item +" is Clicked",Toast.LENGTH_LONG).show();
//                String []obj1=item.split(". ");
//
//            //    Intent intent = new Intent(SurahActivity.this, AyatActivity.class);
//              //  int number=123456;
//
////                intent.putExtra("WelcomeMessage","السلام علیکم");
////                intent.putExtra("nmbr",number);
////                intent.putExtra("Parah",Integer.parseInt(obj1[0]));
////                intent.putExtra("ParahName",obj1[1]);
////                intent.putExtra("array_list",getAyatDetail(objectList,Integer.parseInt(obj1[0])));
//          //      startActivity(intent);
//
////               arrayList.removeAll(arrayList);
//                // t1.setText(getAyatDetail(objectList,78).toString());
//                //t1.setText(getAyatDetail(objectList,78).get(1));
//                //   t1.setText(obj1[0]+"--"+obj1[1]);
////                ArrayAdapter ad1=new ArrayAdapter(MainActivity.this,
////                        android.R.layout.simple_list_item_1,arrayList);
////                list.setAdapter(ad1);
////
//            }
//        });



    }


}