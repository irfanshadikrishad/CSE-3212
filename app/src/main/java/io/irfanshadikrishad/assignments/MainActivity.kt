package io.irfanshadikrishad.assignments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Manage Activity Navigation
        val page1Button: Button = findViewById(R.id.button)
        page1Button.setOnClickListener {
            val page1intent = Intent(this, Page1::class.java)
            startActivity(page1intent)
        }
        val page2Button: Button = findViewById(R.id.button2)
        page2Button.setOnClickListener {
            val page2intent = Intent(this, Page2::class.java)
            startActivity(page2intent)
        }
        val page3Button: Button = findViewById(R.id.button3)
        page3Button.setOnClickListener {
            val page3intent = Intent(this, Page3::class.java)
            startActivity(page3intent)
        }
        val page4Button: Button = findViewById(R.id.button4)
        page4Button.setOnClickListener {
            val page4intent = Intent(this, Page4::class.java)
            startActivity(page4intent)
        }

    }

}