package com.upworkscraper.upworkscraper.helpers;

import java.util.List;

public class Util {

    public static boolean isListNullOrEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }
}
