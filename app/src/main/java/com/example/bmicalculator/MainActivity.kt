package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btncalculate.setOnClickListener {

            if(editweight.text.toString() != "" && editheight1.text.toString() != "" && editheight2.text.toString() != "" ){

                var w = (editweight.text.toString()).toDouble()
                var h1 = (editheight1.text.toString()).toDouble()
                var h2 = (editheight2.text.toString()).toDouble()

                var totalInch = (h1*12) + h2
                var totalCent = totalInch*2.5
                var meter = (totalCent)/100

                var bmi = w/(meter*meter)
                txtcal.text = "${bmi.toInt()}"
                txtresult.text = "Result"

                if(bmi>25){
                    txtstatus.text = resources.getString(R.string.overw)
                    llmain.setBackgroundColor(resources.getColor(R.color.red))
                }else if(bmi<18){
                    txtstatus.text = resources.getString(R.string.underw)
                    llmain.setBackgroundColor(resources.getColor(R.color.yellow))
                }else{
                    txtstatus.text = resources.getString(R.string.perw)
                    llmain.setBackgroundColor(resources.getColor(R.color.green))
                }

            }
            else{

                Toast.makeText(this,"Please Fill all Values",Toast.LENGTH_LONG).show()
            }



        }

    }
}