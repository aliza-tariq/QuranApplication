package com.example.quranapplication;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSTatement = "CREATE TABLE " + QURAN_TABLE + "(" + number +
                " Integer PRIMARY KEY AUTOINCREMENT, " + text + " Text, " +

                numberInSurah + " Int, " +juz + " Int, " +manzil + " Int, " + page + " Int, " +
                ruku + " Int, " +hizbQuarter + " Int, " +sajda + " Int, " + surah_number + " Int, " +

                OPTION_SELECTED + " Int, " +RESULT + " Int, "+STATUS + " Text) ";

        db.execSQL(createTableSTatement);
        System.out.println("db made successfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + QURAN_TABLE);
        onCreate(sqLiteDatabase);
    }
}
