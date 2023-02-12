package com.example.quranapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ParahActivity extends AppCompatActivity {

    ArrayList<String> arrayList =new ArrayList<>();
    ListView list;
    TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parah);

        list=findViewById(R.id.mylistView1);
        t2=findViewById(R.id.heading1);
        List<QuranModel> objectList=MainActivity.objectList;
        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                JsonHelper.getParahNames(objectList));
        list.setAdapter(ad);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(ParahActivity.this, SurahActivity.class);
                String []obj1=item.split(". ");
                t2.setText(String.valueOf(Integer.parseInt(obj1[1])));
                int number=123456;

                intent.putExtra("WelcomeMessage","السلام علیکم");
                intent.putExtra("parahNumber",Integer.parseInt(obj1[1]));
                //startActivity(intent);

            }
        });


    }
}