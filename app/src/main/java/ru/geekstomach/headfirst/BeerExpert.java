package ru.geekstomach.headfirst;

import java.util.ArrayList;
import java.util.List;

class BeerExpert {

    List<String> getBrands(String color) {
        List<String> brands = new ArrayList<>();

        if (color.equals("amber")) {
            brands.add("Jack Amber");
            brands.add("Red Moose");
        } else {
            if (color.equals("light")) {
                brands.add("Bitter Ale");
                brands.add("Blonde Ale");
            } else {
                if (color.equals("brown")) {
                    brands.add("Styrian Goldings");
                    brands.add("East Kent Goldings");
                } else {
                    if (color.equals("dark")) {
                        brands.add("Jail Pale Ale");
                        brands.add("Gout Stout");
                    }

                }
            }
        }
        return brands;
    }
}
