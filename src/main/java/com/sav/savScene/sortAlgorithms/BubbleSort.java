package com.sav.savScene.sortAlgorithms;

import com.sav.savScene.Sav;

public class BubbleSort {
    private final int [] arr;
    private final Sav sav;
    
    public BubbleSort(int [] arr, Sav sav) {
        this.arr = arr;
        this.sav = sav;
    }

    public void sort () {
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr.length - 1; k++) {
                if (arr[k] > arr[k + 1]) {
                    int tempHeight = arr[k + 1];
                    arr[k + 1] = arr[k];
                    arr[k] = tempHeight;
                    sav.movePane(k, k + 1);
                }
            }
        }
    }
}
