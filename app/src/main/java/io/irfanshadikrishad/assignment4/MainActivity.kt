package io.irfanshadikrishad.assignment4

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.irfanshadikrishad.assignment4.adapter.CustomAdapter
import io.irfanshadikrishad.assignment4.models.DataModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.customListView)
        val selectedItemView = findViewById<TextView>(R.id.selectedItemView)

        // Sample data
        val dataList = listOf(
            DataModel("Jack", "Level 1", R.drawable.c1),
            DataModel("Arthur", "Level 2", R.drawable.c2),
            DataModel("Conoe", "Level 3", R.drawable.c3),
            DataModel("Marston", "Level 3", R.drawable.c4),
            DataModel("Abigail", "Level 3", R.drawable.c5)
        )

        // Set adapter
        val adapter = CustomAdapter(this, dataList)
        listView.adapter = adapter

//         Handle item click
//        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
//            val selectedItem = dataList[position]
//            selectedItemView.text = buildString {
//                append("Selected: ")
//                append(selectedItem.title)
//                append("\n")
//                append(selectedItem.description)
//            }
//        }
        // Handle item click
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedItem = dataList[position]
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("title", selectedItem.title)
                putExtra("description", selectedItem.description)
                putExtra("imageResId", selectedItem.imageResId)
            }
            startActivity(intent)
        }

    }
}
