package com.example.recyclerdemo1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_row.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_main.setBackgroundColor(Color.YELLOW)

        // Add a layout

        recyclerView_main.layoutManager = LinearLayoutManager(this)

        recyclerView_main.adapter = MainAdapter()
    }
}

class MainAdapter : RecyclerView.Adapter<CustomViewHolder>() {

    val users = listOf(User("John", 58),
        User("Bob", 25),
        User("Sue", 43))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val layoutInflator = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflator.inflate(R.layout.user_row, parent, false)

        return CustomViewHolder(cellForRow)


    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
       // TODO("Not yet implemented")

        holder.itemView.textView.text = users[position].name
        holder.itemView.textView2.text = users[position].age.toString()
    }

    override fun getItemCount(): Int {
      //  TODO("Not yet implemented")

        return users.size;
    }

}

class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

}


