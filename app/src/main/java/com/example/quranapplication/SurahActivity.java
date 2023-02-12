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
        t1=findViewById(R.id.heading1);

//        Intent intentParah=new Intent();
//        int parahNum=(int)intentParah.getIntExtra("parahNumber",30);
//
//        String msg=(String)intentParah.getStringExtra("WelcomeMessage");

        Intent intentParah=getIntent();
        int parahNum=intentParah.getIntExtra("parahNumber", 0);
        String msg=intentParah.getStringExtra("WelcomeMessage");
        t1.setText("PARAH : "+String.valueOf(parahNum));

        List<QuranModel> objectList;
        ArrayAdapter ad;
        if(parahNum==0)
        {
             objectList=MainActivity.objectList;
            ad=new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                    JsonHelper.getAllSurahNames(objectList));
            list.setAdapter(ad);

        }
        else {

            objectList = MainActivity.objectList;
            ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                    JsonHelper.getSurahNames(objectList, parahNum));
            list.setAdapter(ad);
        }


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                Toast.makeText(SurahActivity.this,item +" is Clicked",Toast.LENGTH_LONG).show();
                String []obj1=item.split(". ");
                Intent intent = new Intent(SurahActivity.this, ReciteSurah.class);
                int number=123456;

                intent.putExtra("WelcomeMessage","السلام علیکم");
                intent.putExtra("nmbr",number);
                intent.putExtra("Parah",Integer.parseInt(obj1[0]));
                intent.putExtra("SurahName",obj1[1]);

                intent.putExtra("array_list",JsonHelper.getAyatDetail(objectList,Integer.parseInt(obj1[0])));
                startActivity(intent);
            }
        });

    }


}