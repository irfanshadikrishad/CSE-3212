package io.irfanshadikrishad.a1087

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

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
        // Place departments with setAdapter in dropdown
        val departments: Array<String> = arrayOf("CSE", "BBA", "BuA", "THM", "ENG", "ARCH", "EEE")
        val adapter = ArrayAdapter(
            this,
            com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
            departments
        )
        val department: AutoCompleteTextView = findViewById(R.id.autoComplete1)
        department.setAdapter(adapter)
        //
        department.setOnItemClickListener { _, _, _, _ ->
            department.error = null
        }
        // Get the values
        val name: TextInputEditText = findViewById(R.id.name)
        val email: TextInputEditText = findViewById(R.id.email)
        val phone: TextInputEditText = findViewById(R.id.phone)
        val submit: Button = findViewById(R.id.button)
        // validation
        val namePattern: Regex = Regex("^[A-Za-z\\s]+\$")
        val emailPattern: Regex = Regex("^(bua|cse|thm|arch|eee|bba|eng)_(\\d{13,16})@lus.ac.bd$")
        val phonePattern: Regex = Regex("^01[793685]\\d{8}\$") // for only BD without country code
        // On Submit
        submit.setOnClickListener {
            if (name.getText().toString().isEmpty()) {
                name.error = "Name cannot be empty!"
                name.requestFocus()
            } else if (!namePattern.matches(name.getText().toString())) {
                name.error = "Name can only contain letter or space!"
                name.requestFocus()
            } else if (email.getText().toString().isEmpty()) {
                email.error = "Email cannot be empty!"
                email.requestFocus()
            } else if (!emailPattern.matches(email.getText().toString())) {
                email.error = "Invalid email!"
                email.requestFocus()
            } else if (phone.getText().toString().isEmpty()) {
                phone.error = "Phone number cannot be empty!"
                phone.requestFocus()
            } else if (!phonePattern.matches(phone.text.toString())) {
                phone.error = "Invalid phone number!"
                phone.requestFocus()
            } else if (department.text.toString().isEmpty()) {
                department.error = "Select a department!"
                department.requestFocus()
            } else {
                val builder = AlertDialog.Builder(this)
                // Set the title and message
                builder.setTitle("Submitted")
                builder.setMessage(
                    "Your form submitted successfully.\n${
                        name.getText().toString()
                    } \n${email.getText().toString()} \n${phone.getText().toString()} \n${
                        department.text.toString()
                    }"
                )
                builder.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                val alertDialog = builder.create()
                alertDialog.show()
            }

        }
    }
}