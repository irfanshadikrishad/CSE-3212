package io.irfanshadikrishad.assignments

import android.content.Intent
import android.media.Rating
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Builder / Modal / AlertDialog
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Order placed")
        val placeOrder: Button = findViewById(R.id.button7)
        // Checked
        val check = mutableListOf<String>()
        // Checkbox
        val lucc: CheckBox = findViewById(R.id.checkBox)
        val ieee: CheckBox = findViewById(R.id.checkBox2)
        val orphious: CheckBox = findViewById(R.id.checkBox3)
        val bannedc: CheckBox = findViewById(R.id.checkBox4)

        lucc.setOnClickListener {
            if (lucc.isChecked) {
                check.add("LUCC")
            } else {
                check.remove("LUCC")
            }
        }
        ieee.setOnClickListener {
            if (ieee.isChecked) {
                check.add("IEEE SB")
            } else {
                check.remove("IEEE SB")
            }
        }
        orphious.setOnClickListener {
            if (orphious.isChecked) {
                check.add("ORPHIOUS")
            } else {
                check.remove("ORPHIOUS")
            }
        }
        bannedc.setOnClickListener {
            if (bannedc.isChecked) {
                check.add("BANNED C.")
            } else {
                check.remove("BANNED C.")
            }
        }

        // Radio
        val radi: RadioGroup = findViewById(R.id.radio)
        var selectedValue: String? = null
        radi.setOnCheckedChangeListener { _, checkedId ->
            val selectedRadioButton: RadioButton = findViewById(checkedId)
            selectedValue = selectedRadioButton.text.toString()
        }

        // Quantity
        val dec: Button = findViewById(R.id.button5)
        val inc: Button = findViewById(R.id.button6)
        val priceText: TextView = findViewById(R.id.textView10)
        var quantity: Int = 0
        dec.setOnClickListener {
            if (quantity > 0) {
                quantity--
            }
            priceText.text = quantity.toString()
            placeOrder.text = "Place order (" + (quantity * 250).toString() + "tk)"
        }
        inc.setOnClickListener {
            quantity++
            priceText.text = quantity.toString()
            placeOrder.text = "Place order (" + (quantity * 250).toString() + "tk)"

        }

        // Ratings
        val layout: LinearLayout = findViewById(R.id.layout9)
        val ratin: RatingBar = findViewById(R.id.ratingBar2)
        val ratingText: TextView = findViewById(R.id.textView11)
        ratin.setOnRatingBarChangeListener { _, rating, _ ->
            ratingText.text = rating.toString()
        }

        // Place order
        placeOrder.setOnClickListener {
            builder.setMessage(
                "You ordered " + (if (quantity > 0) "${quantity.toString()} " else "") + "${
                    check.joinToString(
                        ", "
                    )
                } T-Shirt(s)" + if (selectedValue != null) " of $selectedValue size" else ""
            )
            // Set positive button
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
                layout.visibility = View.VISIBLE
            }
            // Set negative button
            builder.setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            // Show the dialog
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }


        // Go back functionality
        val backButton: Button = findViewById(R.id.button45)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}