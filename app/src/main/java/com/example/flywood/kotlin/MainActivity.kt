package com.example.flywood.kotlin

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintLayout = findViewById(R.id.constraintLayout) as ConstraintLayout

        // Create a horizontal & vertical guidelines and add them to the constraintLayout.
//        val verticalGL = getGuideline(this, ConstraintLayout.LayoutParams.VERTICAL)
//        val horizontalGL = getGuideline(this, ConstraintLayout.LayoutParams.HORIZONTAL)
//        constraintLayout.addView(verticalGL)
//        constraintLayout.addView(horizontalGL)

        // Set the position of the guidelines.
//        verticalGL.setGuidelineBegin(x) // absolute x position
//        horizontalGL.setGuidelineBegin(y) // absolute y position






        val button_dynamic = Button(this)
        button_dynamic.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
//        button_dynamic.gravity = RelativeLayout.ALIGN_PARENT_RIGHT

        button_dynamic.text = "Dynamic Button"
        button_dynamic.id =333
        button_dynamic.setOnClickListener(this)
//        val constraintLayout = findViewById(R.id.mylayout);
//
        constraintLayout.addView(button_dynamic)


    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            333 -> Log.i("flywood", "333 click!")
        }
        Log.i("flywood", "click " + v.id.toString())
//        TODO("Not yet implemented")
    }

    private fun getGuideline(context: Context, orientation: Int): Guideline {
        val guideline = Guideline(context)
        guideline.id = Guideline.generateViewId()
        val lp = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        lp.orientation = orientation
        guideline.layoutParams = lp
        return guideline
    }
}