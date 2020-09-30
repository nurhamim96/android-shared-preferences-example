package com.tutorial.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.tutorial.sharedpreferences", Context.MODE_PRIVATE);

        ArrayList<String> products = new ArrayList<>();

        products.add("Apple");
        products.add("Samsung");
        products.add("Huawei");
        products.add("Xiomi");
        products.add("vivo");
        products.add("Oppo");

        try {

            sharedPreferences.edit().putString("products", ObjectSerializer.serialize(products)).apply();

        } catch (IOException e) {

            e.printStackTrace();

        }

        ArrayList<String> newProducts = new ArrayList<>();
        try {

            newProducts = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("products", ObjectSerializer.serialize(new ArrayList<String>())));

        } catch (IOException e) {

            e.printStackTrace();

        }

        Log.e("newProducts", newProducts.toString());
        // sharedPreferences.edit().putString("username", "Ibad Nurhamim").apply();

        // String username = sharedPreferences.getString("username", "");

        // Log.e("username", username);
    }
}