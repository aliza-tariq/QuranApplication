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

    public static List<QuranModel> objectList = new ArrayList<>();

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.text3);
        btn1=findViewById(R.id.btn1);

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
        objectList = gson.fromJson(jsondata, listType);



        //MySingleton s=new MySingleton(this);
        //List<QuranModel> objectList=s.getInstance().getMyList();


//        for(int i=0;i<10;i++)
//        {
//            t1.setText(t1.getText()+objectList.get(i).getSurah_name());
//        }
      //  t1.setText(getParahDetail(objectList,1));
        list=findViewById(R.id.mylistView1);
        arrayList=JsonHelper.getSurahNames(objectList,30);
        ArrayAdapter ad=new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,arrayList);
        list.setAdapter(ad);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SurahActivity.class);
                int number=123456;

                //intent.putExtra("WelcomeMessage","السلام علیکم");
                //intent.putExtra("nmbr",number);
               // intent.putExtra("array_list",objectList);
                //intent.putExtra("objectList", String.valueOf( objectList));
                startActivity(intent);

            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,item +" is Clicked",Toast.LENGTH_LONG).show();
               String []obj1=item.split(". ");
                Intent intent = new Intent(MainActivity.this, AyatActivity.class);
                int number=123456;

                intent.putExtra("WelcomeMessage","السلام علیکم");
                intent.putExtra("nmbr",number);
                intent.putExtra("Parah",Integer.parseInt(obj1[0]));
                intent.putExtra("ParahName",obj1[1]);
                intent.putExtra("array_list",JsonHelper.getAyatDetail(objectList,Integer.parseInt(obj1[0])));
                startActivity(intent);

            }
        });

    }

}