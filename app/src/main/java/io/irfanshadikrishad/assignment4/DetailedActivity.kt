package io.irfanshadikrishad.assignment4

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.irfanshadikrishad.assignment4.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val titleView = findViewById<TextView>(R.id.detailTitle)
        val descriptionView = findViewById<TextView>(R.id.detailDescription)
        val imageView = findViewById<ImageView>(R.id.detailImage)

        // Retrieve data from intent
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val imageResId = intent.getIntExtra("imageResId", 0)

        // Set data
        titleView.text = title
        descriptionView.text = description
        imageView.setImageResource(imageResId)
    }
}
