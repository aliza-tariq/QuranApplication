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
                String []obj1=item.split(". ");
                t2.setText("-"+obj1[1].toString()+"-");
                 int number=Integer.parseInt(obj1[1].toString().strip());

                Intent intent11 = new Intent(ParahActivity.this, SurahActivity.class);
                Toast.makeText(getApplicationContext(),String.valueOf(number),Toast.LENGTH_LONG).show();

                intent11.putExtra("WelcomeMessage","السلام علیکم");
                intent11.putExtra("parahNumber",number);
                startActivity(intent11);

            }
        });


    }
}