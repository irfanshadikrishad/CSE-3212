package io.irfanshadikrishad.assignments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val clickedText: TextView = findViewById(R.id.textView)

        val brownButton: Button = findViewById(R.id.button6)
        brownButton.setOnClickListener {
            clickedText.text = "clicked brown!"
            clickedText.visibility = View.VISIBLE
        }
        val greenButton: Button = findViewById(R.id.button7)
        greenButton.setOnClickListener {
            clickedText.text = "clicked green!"
            clickedText.visibility = View.VISIBLE
        }

        // Go back functionality
        val backButton: Button = findViewById(R.id.button15)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}