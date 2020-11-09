package com.calivera.andriod.ageinmin

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val btnDataPicker: Button = findViewById(R.id.btnDataPicker)

        btnDataPicker.setOnClickListener{view ->
            clickDatePicker(view)


        }

    }

    fun clickDatePicker(view:View){
        val dateSelected: TextView = findViewById(R.id.tv_selectDate)
        val dateInMinits: TextView = findViewById(R.id.tv_selectedDateInMin)
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
         val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{View,selectedYear,selectedMonth,selectedDayOfMoth ->
                    Toast.makeText(this, "The chosen year is $selectedYear." +
                            "the month is $selectedMonth and the day is $selectedDayOfMoth"
                            , Toast.LENGTH_SHORT).show()
                    val selectedDate = "$selectedDayOfMoth/${selectedMonth+1}/$selectedYear"

                    dateSelected.text = selectedDate

                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                    val theDate = sdf.parse(selectedDate) //look up parse

                    val selectedDateInMinutes = theDate!!.time /60000
                    val selectedMinTODay = selectedDateInMinutes / 1440

                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                    val currentDateinMinutes = currentDate!!.time / 60000
                    val currentDateinDay = currentDateinMinutes / 1440

                    val  diffInMin = currentDateinMinutes - selectedDateInMinutes

                    val diffinDays = currentDateinDay - selectedMinTODay
                    dateInMinits.text = diffinDays.toString()



                },
                year,
                month,
                day)

        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()

    }

}