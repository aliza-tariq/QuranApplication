package com.example.quranapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
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
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;


    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(getApplicationContext(),"Start",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(getApplicationContext(),"End",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView=findViewById(R.id.nav_view);
        drawerLayout=findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.Surah:
                        Toast.makeText(getApplicationContext(),"Retur is Clicked",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, SurahActivity.class);
                        startActivity(intent);
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_return :
                        Toast.makeText(getApplicationContext(),"Retur is Clicked",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.Parah:
                        Toast.makeText(getApplicationContext(),"Laptop is clicked",Toast.LENGTH_LONG).show();
                        Intent intentP = new Intent(MainActivity.this, ParahActivity.class);
                        startActivity(intentP);
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.githubLink:
                        Uri webpage = Uri.parse("https://github.com/aliza-tariq/QuranApplication");
                        Intent intent1 = new
                                Intent(Intent.ACTION_VIEW, webpage);
                        startActivity(intent1);
                        break;
                    case R.id.githubLink1:
                        Uri webpage2 = Uri.parse("https://github.com/aliza-tariq?tab=repositories");
                        Intent intentg = new
                                Intent(Intent.ACTION_VIEW, webpage2);
                        startActivity(intentg);
                        break;


                    case R.id.Manzil:
                        Toast.makeText(getApplicationContext(),"Chrome Reader is clicked",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intentM = new Intent(MainActivity.this, ManzilActivity.class);
                        startActivity(intentM);
                        break;
                }

                return true;
            }
        });

        //t1=findViewById(R.id.text3);
//        btn1=findViewById(R.id.btn1);

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

//
//
//        //MySingleton s=new MySingleton(this);
//        //List<QuranModel> objectList=s.getInstance().getMyList();
//
//
////        for(int i=0;i<10;i++)
////        {
////            t1.setText(t1.getText()+objectList.get(i).getSurah_name());
////        }
//      //  t1.setText(getParahDetail(objectList,1));
//        list=findViewById(R.id.mylistView1);
//        arrayList=JsonHelper.getSurahNames(objectList,30);
//        ArrayAdapter ad=new ArrayAdapter(this,
//                android.R.layout.simple_list_item_1,arrayList);
//        list.setAdapter(ad);
//
//
//
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SurahActivity.class);
//                int number=123456;
//
//                //intent.putExtra("WelcomeMessage","السلام علیکم");
//                //intent.putExtra("nmbr",number);
//               // intent.putExtra("array_list",objectList);
//                //intent.putExtra("objectList", String.valueOf( objectList));
//                startActivity(intent);
//
//            }
//        });
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String item = (String) parent.getItemAtPosition(position);
//                Toast.makeText(MainActivity.this,item +" is Clicked",Toast.LENGTH_LONG).show();
//               String []obj1=item.split(". ");
//                Intent intent = new Intent(MainActivity.this, AyatActivity.class);
//                int number=123456;
//
//                intent.putExtra("WelcomeMessage","السلام علیکم");
//                intent.putExtra("nmbr",number);
//                intent.putExtra("Parah",Integer.parseInt(obj1[0]));
//                intent.putExtra("ParahName",obj1[1]);
//                intent.putExtra("array_list",JsonHelper.getAyatDetail(objectList,Integer.parseInt(obj1[0])));
//                startActivity(intent);
//
//            }
//        });

    }
    public void openWebPage(View view) {
        Uri webpage = Uri.parse("https://github.com/aliza-tariq/MC-A2-LearningApp.git");
        Intent intent = new
                Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

}