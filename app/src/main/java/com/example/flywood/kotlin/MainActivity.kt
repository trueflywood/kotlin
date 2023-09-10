package com.example.flywood.kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintLayout = findViewById(R.id.constraintLayout) as ConstraintLayout
    }

    fun goActivity_1(view: View) {
        // start your activity by passing the intent
        startActivity(Intent(this, Activity1::class.java))
    }
    fun goActivity_2(view: View) {
        startActivity(Intent(this, Activity2::class.java))
    }
    fun goActivity_3(view: View) {
        startActivity(Intent(this, Activity3::class.java))
    }
    fun goActivity_4(view: View) {
        startActivity(Intent(this, Activity4::class.java))
    }

}