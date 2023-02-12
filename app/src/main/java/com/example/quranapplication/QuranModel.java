package com.example.quranapplication;

public class QuranModel {
    private String text;
    private int numberInSurah;
    private int juz;
    private int manzil;
    private int page;
    private int ruku;

    private int hizbQuarter;
    private int sajda;
    private int surah_number;

    private String surah_name;
    private String englishName;
    private String englishNameTranslation;
    private String revelationType;

    private String UrduTranslation;
    private String UrduTafseer;
    private String EnglishTranslation;
    private String Englishtafseer;
    private String SindhiTranslation;
    private String SindhiTafseer;
    private String HindiTranslation;
    private String HindiTafseer;
    private String PushtoTransation;
    private String PushtoTafseer;

//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public int getNumberInSurah() {
//        return numberInSurah;
//    }
//
//    public void setNumberInSurah(int numberInSurah) {
//        this.numberInSurah = numberInSurah;
//    }
//
//    public int getJuz() {
//        return juz;
//    }
//
//    public void setJuz(int juz) {
//        this.juz = juz;
//    }
//
//    public int getManzil() {
//        return manzil;
//    }
//
//    public void setManzil(int manzil) {
//        this.manzil = manzil;
//    }
//
//    public int getPage() {
//        return page;
//    }
//
//    public void setPage(int page) {
//        this.page = page;
//    }
//
//    public int getRuku() {
//        return ruku;
//    }
//
//    public void setRuku(int ruku) {
//        this.ruku = ruku;
//    }
//
//    public int getHizbQuarter() {
//        return hizbQuarter;
//    }
//
//    public void setHizbQuarter(int hizbQuarter) {
//        this.hizbQuarter = hizbQuarter;
//    }
//
//    public int getSajda() {
//        return sajda;
//    }
//
//    public void setSajda(int sajda) {
//        this.sajda = sajda;
//    }
//
//    public int getSurah_number() {
//        return surah_number;
//    }
//
//    public void setSurah_number(int surah_number) {
//        this.surah_number = surah_number;
//    }
//
//    public String getSurah_name() {
//        return surah_name;
//    }
//
//    public void setSurah_name(String surah_name) {
//        this.surah_name = surah_name;
//    }
//
//    public String getEnglishName() {
//        return englishName;
//    }
//
//    public void setEnglishName(String englishName) {
//        this.englishName = englishName;
//    }
//
//    public String getEnglishNameTranslation() {
//        return englishNameTranslation;
//    }
//
//    public void setEnglishNameTranslation(String englishNameTranslation) {
//        this.englishNameTranslation = englishNameTranslation;
//    }
//
//    public String getRevelationType() {
//        return revelationType;
//    }
//
//    public void setRevelationType(String revelationType) {
//        this.revelationType = revelationType;
//    }
//
//    public String getUrduTranslation() {
//        return UrduTranslation;
//    }
//
//    public void setUrduTranslation(String urduTranslation) {
//        UrduTranslation = urduTranslation;
//    }
//
//    public String getUrduTafseer() {
//        return UrduTafseer;
//    }
//
//    public void setUrduTafseer(String urduTafseer) {
//        UrduTafseer = urduTafseer;
//    }
//
//    public String getEnglishTranslation() {
//        return EnglishTranslation;
//    }
//
//    public void setEnglishTranslation(String englishTranslation) {
//        EnglishTranslation = englishTranslation;
//    }
//
//    public String getEnglishtafseer() {
//        return Englishtafseer;
//    }
//
//    public void setEnglishtafseer(String englishtafseer) {
//        Englishtafseer = englishtafseer;
//    }
//
//    public String getSindhiTranslation() {
//        return SindhiTranslation;
//    }
//
//    public void setSindhiTranslation(String sindhiTranslation) {
//        SindhiTranslation = sindhiTranslation;
//    }
//
//    public String getSindhiTafseer() {
//        return SindhiTafseer;
//    }
//
//    public void setSindhiTafseer(String sindhiTafseer) {
//        SindhiTafseer = sindhiTafseer;
//    }
//
//    public String getHindiTranslation() {
//        return HindiTranslation;
//    }
//
//    public void setHindiTranslation(String hindiTranslation) {
//        HindiTranslation = hindiTranslation;
//    }
//
//    public String getHindiTafseer() {
//        return HindiTafseer;
//    }
//
//    public void setHindiTafseer(String hindiTafseer) {
//        HindiTafseer = hindiTafseer;
//    }
//
//    public String getPushtoTransation() {
//        return PushtoTransation;
//    }
//
//    public void setPushtoTransation(String pushtoTransation) {
//        PushtoTransation = pushtoTransation;
//    }
//
//    public String getPushtoTafseer() {
//        return PushtoTafseer;
//    }
//
//    public void setPushtoTafseer(String pushtoTafseer) {
//        PushtoTafseer = pushtoTafseer;
//    }
//
//    @Override
//    public String toString() {
//        return "QuranModel{" +
//                "text='" + text + '\'' +
//                ", numberInSurah=" + numberInSurah +
//                ", juz=" + juz +
//                ", manzil=" + manzil +
//                ", page=" + page +
//                ", ruku=" + ruku +
//                ", hizbQuarter=" + hizbQuarter +
//                ", sajda=" + sajda +
//                ", surah_number=" + surah_number +
//                ", surah_name='" + surah_name + '\'' +
//                ", englishName='" + englishName + '\'' +
//                ", englishNameTranslation='" + englishNameTranslation + '\'' +
//                ", revelationType='" + revelationType + '\'' +
//                ", UrduTranslation='" + UrduTranslation + '\'' +
//                ", UrduTafseer='" + UrduTafseer + '\'' +
//                ", EnglishTranslation='" + EnglishTranslation + '\'' +
//                ", Englishtafseer='" + Englishtafseer + '\'' +
//                ", SindhiTranslation='" + SindhiTranslation + '\'' +
//                ", SindhiTafseer='" + SindhiTafseer + '\'' +
//                ", HindiTranslation='" + HindiTranslation + '\'' +
//                ", HindiTafseer='" + HindiTafseer + '\'' +
//                ", PushtoTransation='" + PushtoTransation + '\'' +
//                ", PushtoTafseer='" + PushtoTafseer + '\'' +
//                '}';
//    }
}
