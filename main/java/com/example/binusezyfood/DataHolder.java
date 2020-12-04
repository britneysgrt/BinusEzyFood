package com.example.binusezyfood;

import java.util.ArrayList;

class DataHolder {
    final ArrayList<OrderAttributes> orderList = new ArrayList<>();

    public DataHolder(){}

    static DataHolder getInstance(){
        if (instance == null){
            instance = new DataHolder();
        }
        return instance;
    }

    private static DataHolder instance;
}
