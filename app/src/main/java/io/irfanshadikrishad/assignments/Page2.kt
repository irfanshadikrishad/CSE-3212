package io.irfanshadikrishad.assignments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Change Image
        val changeImage: Button = findViewById(R.id.button8)
        val image: ImageView = findViewById(R.id.imageView)
        changeImage.setOnClickListener {
            if (image.drawable.constantState ==
                this.resources.getDrawable(R.drawable.dumb2, null).constantState
            ) {
                image.setImageResource(R.drawable.dumb1)
            }
        }

        // Go back functionality
        val backButton: Button = findViewById(R.id.button25)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
