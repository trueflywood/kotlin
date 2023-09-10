package com.example.flywood.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
    }

    fun goToMain(view: View) {
        finish()
    }
    fun goActivity_1(view: View) {
        startActivity(Intent(this, Activity1::class.java))
        finish()
    }
    fun goActivity_2(view: View) {
        startActivity(Intent(this, Activity2::class.java))
        finish()
    }
    fun goActivity_4(view: View) {
        startActivity(Intent(this, Activity4::class.java))
        finish()
    }
}