package com.ap.basickotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showToast(view: View) {
        showToastMessage();
    }

    fun sum(view: View) {
        val etInputA = findViewById<EditText>(R.id.etInputA)
        val etInputB = findViewById<EditText>(R.id.etInputB)

        val a = validInteger(etInputA.text.toString())
        val b = validInteger(etInputB.text.toString())
        val add = a + b;
        findViewById<TextView>(R.id.txtResult).setText("" + add)
    }

    fun max(view: View) {
        val etInputA = findViewById<EditText>(R.id.etInputA)
        val etInputB = findViewById<EditText>(R.id.etInputB)

        val a = validInteger(etInputA.text.toString())
        val b = validInteger(etInputB.text.toString())
        findViewById<TextView>(R.id.txtResult).setText("" + maxValue(a, b))
    }

    fun maxValue(elementA: Int, elementB: Int): Int? {
        val x: IntArray = intArrayOf(elementA, elementB)
        return x.max();
    }

    fun printStrings(view: View) {
        var allStrings = ""

        val items = listOf("apple", "banana", "kiwifruit")
        for (index in items.indices) {
            println("item at $index is ${items[index]}")
            allStrings +=  items[index]
            allStrings +=  "\n"
        }
        findViewById<TextView>(R.id.txtStrings).setText(allStrings)

    }

    fun openListScreen(view: View){
        val intent = ListItemActivity.newIntent(view.context)
        startActivity(intent)
    }
}
