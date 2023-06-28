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

            //Validação se esta marcado o feminino ou o masculino
            if (!feminno.isChecked && !masculino.isChecked) {
                Toast.makeText(this, msgs, Toast.LENGTH_LONG).show()
            }

            //verifica se a idade está preenchida
            if (idade.text.isEmpty() || idade.text.isNullOrBlank()) {
                idade.error = "preencha sua idade"
            }
            //se não tiver preenchida, validar se é maior de idade
            else if (idade.text.toString().toInt() < 18) {
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
            } else if (idade.text.toString().toInt() > 18) {

                //se for maior de idade, coloca o valor da idade na variavel dblidade
                dblidade = idade.text.toString().toInt();

                //se a pessoa for uma mulher, calcula a regra para mulher
                if (feminno.isChecked) {
                    val quantoTempoFalta = 60 - dblidade

                    //valida se a pessoa ja se aposentou
                    if (quantoTempoFalta <= 0) {
                        Toast.makeText(this, "Você já está aposentada!", Toast.LENGTH_LONG).show()
                    } else {
                        //se ainda faltar alguns anos para ela se aposentar, mostrar quanto falta
                       // Toast.makeText(this, msga + quantoTempoFalta, Toast.LENGTH_LONG).show()
                        resultadoo.setText(msga+quantoTempoFalta+" anos")
                    }

              //se a pessoa for um homem, calcula a regra para homem
                } else if (masculino.isChecked) {
                    val quantoTempoFalta = 65 - dblidade

                    //valida se a pessoa ja se aposentou
                    if (quantoTempoFalta <= 0) {
                        Toast.makeText(this, "Você já está aposentado!", Toast.LENGTH_LONG).show()
                    } else {
                        //se ainda faltar alguns anos para ele se aposentar, mostrar quanto falta
                        //Toast.makeText(this, msga + quantoTempoFalta, Toast.LENGTH_LONG).show()
                        resultadoo.setText(msga+quantoTempoFalta+" anos")
                    }

                }

            }
        }
    }
}
