package com.paeqw.utils;

import com.paeqw.interfaces.Sortable;

import java.util.Collections;
import java.util.List;

public class Sorter {
    public static void sort(List<? extends Sortable> list) {
        Collections.sort(list, (a, b) -> a.compare(b));
    }
}
