package com.erikadesu.calculadoradeimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainCalculate.setOnClickListener {
            val weight = edtMainWeight.text.toString()
            val height = edtMainHeight.text.toString()

            if (weight.isEmpty() || height.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
                if (weight.isEmpty()) {
                    edtMainWeight.error = "Campo requerido"
                    edtMainWeight.requestFocus()
                } else {
                    edtMainHeight.error = "Campo requerido"
                    edtMainHeight.requestFocus()
                }
            } else {
                val results = weight.toFloat() / (height.toFloat() * height.toFloat())
                val mIntent = Intent(this, ResultsActivity::class.java)
                val formattedResults = String.format("%.1f", results)

                mIntent.putExtra("INTENT_RESULTS", formattedResults)
                startActivity(mIntent)
            }
        }
    }
}