package com.example.quranapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ManzilParahActivity extends AppCompatActivity {

    ArrayList<String> arrayList =new ArrayList<>();
    ListView list;
    TextView t2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manzil_parah);

        list=findViewById(R.id.mylistView1);
        t2=findViewById(R.id.heading1);
        btn1=findViewById(R.id.btnManzil);

        Intent intentParah=getIntent();
        int manzilNum=intentParah.getIntExtra("manzilNumber", 0);
        btn1.setText("Manzil : "+String.valueOf(manzilNum));

        List<QuranModel> objectList=MainActivity.objectList;
        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                JsonHelper.getManzilParahNames(objectList,manzilNum));
        list.setAdapter(ad);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                String []obj1=item.split(". ");
                //t2.setText("-"+obj1[1].toString()+"-");
                int number=Integer.parseInt(obj1[1].toString().strip());

                Intent intent11 = new Intent(ManzilParahActivity.this, SurahActivity.class);
                Toast.makeText(getApplicationContext(),String.valueOf(number),Toast.LENGTH_LONG).show();

                intent11.putExtra("parahNumber", number);
                intent11.putExtra("WelcomeMessage", "Hello World herer!");
                startActivity(intent11);

            }
        });

    }

}