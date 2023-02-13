package com.example.quranapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ReciteSurah extends AppCompatActivity {

    TextView h1,h2,surah1;
    Button btnTaf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recite_surah);
        h1=findViewById(R.id.headingParah);
        h2=findViewById(R.id.headingSurah);
        surah1=findViewById(R.id.surahText);
        btnTaf=findViewById(R.id.btnTaf);

        Intent intent = getIntent();
        ArrayList<String> arrayList = (ArrayList<String>) intent.getSerializableExtra("array_list");

        String str1="";
        int c=1;
        for(String st: arrayList)
        {
            str1=str1+String.valueOf(c)+".  "+st+"\n\n";
            c++;
        }

        h1.setText("Parah Number :  "+String.valueOf(intent.getIntExtra("parahNum",1)));
        if(intent.getIntExtra("parahNum",0)==0)
        {
        h1.setText("");
        }
        h2.setText("Surah Name :  "+intent.getStringExtra("SurahName"));
        surah1.setText(str1);
       List<QuranModel> objectList=MainActivity.objectList;
        btnTaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent22 = new Intent(ReciteSurah.this, AyatActivity.class);
                int number=123456;

                intent22.putExtra("parahNum",intent.getIntExtra("parahNum",2));
                intent22.putExtra("SurahName",intent.getStringExtra("SurahName"));

                intent22.putExtra("array_list",JsonHelper.getAyatDetail( objectList,
                        intent.getIntExtra("parahNum",1)));
                startActivity(intent22);

            }
        });


    }
}