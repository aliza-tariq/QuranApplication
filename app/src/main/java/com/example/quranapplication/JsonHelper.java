package com.example.quranapplication;

import java.util.ArrayList;
import java.util.List;

public class JsonHelper {

   public static ArrayList<String>  getSurahNames(List<QuranModel> list1, int num)
    {
        String str1="";
        ArrayList<String> arrayList=new ArrayList<>();
        for(QuranModel objQuran:list1)
        {
            if(objQuran.getJuz()==num)
            {
                //str1=str1+objQuran.getSurah_number()+". "+objQuran.getSurah_name()+"\n\n\n";
                String st=Integer.toString(objQuran.getSurah_number()) + ". " + objQuran.getSurah_name().toString();
                if(arrayList.indexOf(st)<0)
                {
                    arrayList.add(st);
                }
            }
        }
        return arrayList;
    }


    public static ArrayList<String>  getParahNames(List<QuranModel> list1)
    {
        ArrayList<String> arrayList=new ArrayList<>();
        ArrayList<String> counter=new ArrayList<>();

        int i=0;
        for(QuranModel objQuran:list1)
        {
            if(counter.indexOf(String.valueOf(objQuran.getJuz()))<0)
            {
                //str1=str1+objQuran.getSurah_number()+". "+objQuran.getSurah_name()+"\n\n\n";
                String st=Integer.toString(objQuran.getJuz()) + ". "+"\n" + objQuran.getEnglishName().toString()+
                        "\n"+objQuran.getEnglishNameTranslation()+"\n"+objQuran.getRevelationType();
                counter.add(String.valueOf(objQuran.getJuz()));
                if(arrayList.indexOf(st)<0)
                {
                    arrayList.add("\n\tPARAH  "+st+"\n");
                    if(i==30)
                        break;
                }
            }
        }
        return arrayList;
    }



    public static ArrayList<String> getAyatDetail(List<QuranModel> list1,int num)
    {
        ArrayList<String> arrayList1=new ArrayList<>();
        int i=0;
        for(QuranModel objQuran:list1)
        {
            if(i==0) {
                i++;
                continue;

            }
            if(objQuran.getSurah_number()==num)
            {
                //str1=str1+objQuran.getSurah_number()+". "+objQuran.getSurah_name()+"\n\n\n";
                String st=objQuran.getText();
                if(arrayList1.indexOf(st)<0)
                {
                    arrayList1.add("\n"+st+"\n\n");
                }
            }
        }
        return arrayList1;
    }
}
