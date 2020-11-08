package com.calivera.andriod.ageinmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val btnDataPicker: Button = findViewById(R.id.btnDataPicker)


        btnDataPicker.setOnClickListener{
            Toast.makeText(this,
            "hello world",
            Toast.LENGTH_SHORT).show()

        }












    }

}