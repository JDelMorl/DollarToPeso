package com.example.dollartopeso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//      taking the input number
        val convertNum = findViewById<EditText>(R.id.idConvertNumber)
        val rbDllrToPeso = findViewById<RadioButton>(R.id.idDollarToPeso)
        val rbPesoToDllr = findViewById<RadioButton>(R.id.idPesoToDollar)
        val txtResult = findViewById<TextView>(R.id.txtResults)
        val convertIt = findViewById<Button>(R.id.idConvertButton)

        convertIt.setOnClickListener {
            val tenth = DecimalFormat("$###,###,###.##")
            val dblMeasure = convertNum.text.toString().toDouble()
            val dollarToPesoConversionRate = 20.05
            val convertMeasureNum: Double?

            if (rbDllrToPeso.isChecked) {
                if (dblMeasure <= 10000) {
                    convertMeasureNum = dblMeasure * dollarToPesoConversionRate
                    txtResult.text = tenth.format(convertMeasureNum)
                }else{
                    Toast.makeText(this@MainActivity, "Please Keep It Under $10,000",Toast.LENGTH_LONG).show()
                }
            }else if (rbPesoToDllr.isChecked){
                if (dblMeasure <= 10000) {
                    convertMeasureNum = dblMeasure / dollarToPesoConversionRate
                    txtResult.text = tenth.format(convertMeasureNum)
                }else{
                    Toast.makeText(this@MainActivity, "Please Keep It Under $10,000",Toast.LENGTH_LONG).show()
                }
            }
            }
        }

    }
