package CRRW.MyPlushie.models;

import java.util.ArrayList;

public class PlushieData {
    public static ArrayList<Plushie> findByColumnAndValue(String column, String value, Iterable<Plushie> allplushies) {


        ArrayList<Plushie> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")) {
            return (ArrayList<Plushie>) allplushies;
        }

        if (column.equals("all")) {
            results = findByValue(value, allplushies);
            return results;
        }
        for (Plushie plushie : allplushies) {

            String aValue = getFieldValue(plushie, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(plushie);
            }
        }

        return results;
    }

    public static String getFieldValue(Plushie plushie, String fieldName) {
        String theValue;
        if (fieldName.equals("name")) {
            theValue = plushie.getName();
        } else if (fieldName.equals("emblem")) {
            theValue = plushie.getEmblem().toString();
        } else {
            theValue = plushie.getPhoto().toString();
        }

        return theValue;
    }

    public static ArrayList<Plushie> findByValue(String value, Iterable<Plushie> allplushies)
    {
        ArrayList<Plushie> results = new ArrayList<>();

        for (Plushie plushie : allplushies)
            {

            if (plushie.getName().toLowerCase().contains(value.toLowerCase())) {
                results.add(plushie);
            } else if (plushie.getEmblem().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(plushie);
            }
            //else if (plushie.getSkills().toString().toLowerCase().contains(value.toLowerCase())) {
            //    results.add(job);
            //}

        }

        return results;
    }
}
