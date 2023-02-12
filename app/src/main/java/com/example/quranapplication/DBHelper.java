package com.example.quranapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String number = "number";
    public static final String text = "text";

    public static final String numberInSurah = "numberInSurah";
    public static final String juz = "juz";
    public static final String manzil = "manzil";
    public static final String page = "page";
    public static final String ruku = "ruku";
    public static final String hizbQuarter = "hizbQuarter";
    public static final String sajda = "sajda";
    public static final String surah_number = "surah_number";


    public static final String surah_name = "surah_name";
    public static final String englishName = "englishName";
    public static final String englishNameTranslation = "englishNameTranslation";
    public static final String revelationType = "revelationType";

    public static final String sajdaId= "sajda.id";
    public static final String sajdaRecommended= "sajda.recommended";
    public static final String sajdaObligatory= "sajda.obligatory";


    public static final String UrduTranslation = "UrduTranslation";
    public static final String UrduTafseer = "UrduTafseer";
    public static final String EnglishTranslation = "EnglishTranslation";
    public static final String Englishtafseer = "Englishtafseer";
    public static final String SindhiTranslation = "SindhiTranslation";
    public static final String SindhiTafseer = "SindhiTafseer";
    public static final String HindiTranslation = "HindiTranslation";
    public static final String HindiTafseer = "HindiTafseer";
    public static final String PushtoTransation = "PushtoTransation";
    public static final String PushtoTafseer = "PushtoTafseer";


    public static final String QURAN_TABLE = "QuranMetaData";

    public DBHelper(@Nullable Context context) {
        super(context, "QuranDB.db", null, 4);
        System.out.println("constructor called");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSTatement = "CREATE TABLE " + QURAN_TABLE + "(" + number +
                " Integer PRIMARY KEY AUTOINCREMENT, " + text + " Text, " +

                numberInSurah + " Int, " +juz + " Int, " +manzil + " Int, " + page + " Int, " +
                ruku + " Int, " +hizbQuarter + " Int, " +sajda + " Int, " + surah_number + " Int, " +

                surah_name + " Text, " +englishName + " Text, " +englishNameTranslation + " Text, " +
                revelationType + " Text, " +sajdaId + " Text, " +sajdaRecommended + " Text, " +
                sajdaObligatory + " Text, " +
                UrduTranslation + " Text, " +UrduTafseer + " Text, " +
                EnglishTranslation + " Text, " +Englishtafseer + " Text, " +
                SindhiTranslation + " Text, " +SindhiTafseer + " Text, " +

                HindiTranslation + " Text, " +HindiTafseer + " Text, " +
                PushtoTransation + " Text, " +PushtoTafseer + " Text) ";

        db.execSQL(createTableSTatement);
        System.out.println("db made successfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + QURAN_TABLE);
        onCreate(sqLiteDatabase);
    }
}
