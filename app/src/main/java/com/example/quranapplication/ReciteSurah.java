package com.example.quranapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

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
        for(String st: arrayList)
        {
            str1=str1+st+"\n\n";
        }
        h1.setText(String.valueOf(intent.getIntExtra("Parah",2)));
        h2.setText(intent.getStringExtra("SurahName"));
        surah1.setText(str1);

        btnTaf


    }
}