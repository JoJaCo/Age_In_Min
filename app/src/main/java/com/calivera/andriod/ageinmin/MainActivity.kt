package com.calivera.andriod.ageinmin

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val btnDataPicker: Button = findViewById(R.id.btnDataPicker)
        val dateSelected: TextView = findViewById(R.id.tv_selectDate)
        val dateInMInits: TextView = findViewById(R.id.tv_selectedDateInMin)


        btnDataPicker.setOnClickListener{view ->
            clickDatePicker(view)


        }

    }

    fun clickDatePicker(view:View){
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{View,year,month,dayOfMoth ->
                    Toast.makeText(this, "hello world", Toast.LENGTH_SHORT).show()
                },
                year,
                month,
                day).show()

    }

}