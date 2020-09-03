package com.erikadesu.calculadoradeimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_results.*
import kotlin.math.roundToInt

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val imc = intent.getStringExtra("INTENT_RESULTS")?.toFloat()
        var conclusion = ""

        if (imc != null) {
            if (imc >= 25.0) {
                conclusion = "Você está acima do seu peso ideal. Pare de fazer gordices!"
            } else if (imc < 18.5) {
                conclusion = "Você está abaixo do seu peso ideal. Vá comer um BigMac"
            } else {
                conclusion = "Você está no seu peso ideal. Parabéns!"
            }
        }


        txvResultsIMC.text = imc.toString()
        txvResultsConclusion.text = conclusion

        btnResultsReset.setOnClickListener {
            val mIntent = Intent(this, MainActivity::class.java)
            startActivity(mIntent)
        }

        btnResultsExit.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Tem certeza que quer sair?")
                .setPositiveButton("Sim") {_,_ ->
                    finishAffinity()
                }
                .setNeutralButton("Cancelar") {_,_ -> }
                .setCancelable(false)
                .create()
                .show()
        }
    }
}