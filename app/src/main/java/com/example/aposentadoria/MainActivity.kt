package com.example.aposentadoria

import android.icu.util.IslamicCalendar.CalculationType
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val feminno = findViewById<RadioButton>(R.id.radiof)
        val masculino = findViewById<RadioButton>(R.id.radiom)
        val idade = findViewById<EditText>(R.id.editidade)
        val calcular = findViewById<Button>(R.id.button)
        val resultadoo = findViewById<TextView>(R.id.resultado)
        
        var dblidade = 0
        var msg = "você é menor de idade"
        var msgs = "selecione o sexo"
        var msga = "para a sua aposentadoria falta "

        feminno.setOnClickListener {
            masculino.isChecked = false
        }
        masculino.setOnClickListener {
            feminno.isChecked = false
        }

        calcular.setOnClickListener {

            dblidade = idade.text.toString().toInt()

            if (idade.text.isEmpty()) {
                idade.error = "preencha sua idade"
            }
            if (!feminno.isChecked || !masculino.isChecked) {

                //feminno.error= "selecione o sexo"
                // masculino.error= "seleione o sexo"
                Toast.makeText(this, msgs, Toast.LENGTH_LONG).show()
            }
            if (dblidade < 18) {

                Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

            }else if (feminno.isChecked) {

                dblidade = dblidade - 60
                Toast.makeText(this, msga + dblidade, Toast.LENGTH_LONG).show()

            }else if(masculino.isChecked){
                dblidade= dblidade - 65
                Toast.makeText(this, msga + dblidade, Toast.LENGTH_LONG).show()
            }


        }
    }
}
