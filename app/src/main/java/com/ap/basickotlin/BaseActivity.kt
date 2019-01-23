package com.ap.basickotlin

import android.support.v7.app.AppCompatActivity
import android.widget.Toast

open class BaseActivity : AppCompatActivity() {

    fun showToastMessage() {
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
    }

    fun validInteger(value: String): Int {
        if (value == null || value.equals("") || value.toLowerCase().equals("null")) {
            return 0;
        }
        return Integer.parseInt(value);
    }
}
