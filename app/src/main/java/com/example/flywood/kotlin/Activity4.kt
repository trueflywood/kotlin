package com.example.flywood.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Activity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)
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
    fun goActivity_3(view: View) {
        startActivity(Intent(this, Activity3::class.java))
        finish()
    }
}