package com.ap.basickotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ListItemActivity : BaseActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.adapter = RecyclerAdapter()
    }


    fun addRow(view: View) {
        if (recyclerView.adapter is RecyclerAdapter) {
            (recyclerView.adapter as RecyclerAdapter).addItem();
        }
    }

    companion object {

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ListItemActivity::class.java)
            return intent
        }
    }

    class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.PhotoHolder>() {

        var noOfRow = 10

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PhotoHolder {
            val inflatedView = LayoutInflater.from(p0.context).inflate(R.layout.item_row, p0, false)
            return PhotoHolder(inflatedView)

        }


        override fun getItemCount(): Int {
            return noOfRow;
        }

        fun addItem() {
            noOfRow++;
            notifyDataSetChanged()
        }

        override fun onBindViewHolder(placeHolder: PhotoHolder, p1: Int) {
            placeHolder.txtData.text = "${p1}"
        }

        class PhotoHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

            var txtData = v.findViewById<TextView>(R.id.txtData)

            init {
                v.setOnClickListener(this)
            }

            override fun onClick(v: View) {
                Log.d("RecyclerView", "CLICK!")
            }

            companion object {
                //5
            }
        }

    }

}
