package com.example.flywood.kotlin

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Guideline

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var button_2_id: Int = 0
    private var button_1_id: Int = 0
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Получаем наш лейаут
        val constraintLayout = findViewById(R.id.constraintLayout) as ConstraintLayout


        // Создаем  первую кнопку
        val button_1 = Button(this)
        button_1.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        button_1.text = getString(R.string.plus_button)

        button_1_id =Button.generateViewId()
        button_1.id =button_1_id

        button_1.setOnClickListener(this)

        constraintLayout.addView(button_1)

        // Создаем  вторую кнопку
        val button_2 = Button(this)
        button_2.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        button_2.text = getString(R.string.minus_button)
        button_2_id =Button.generateViewId()
        button_2.id =button_2_id
        button_2.setOnClickListener(this)

        constraintLayout.addView(button_2)



        // Create a horizontal & vertical guidelines and add them to the constraintLayout.
//        val verticalGL = getGuideline(this, ConstraintLayout.LayoutParams.VERTICAL)
//        val horizontalGL = getGuideline(this, ConstraintLayout.LayoutParams.HORIZONTAL)
//        constraintLayout.addView(verticalGL)
//        constraintLayout.addView(horizontalGL)

        // Set the position of the guidelines.
//        verticalGL.setGuidelineBegin(x) // absolute x position
//        horizontalGL.setGuidelineBegin(y) // absolute y position

        val horizontalGL = Guideline(this)
        horizontalGL.id = Guideline.generateViewId()
        val lp = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        lp.orientation = ConstraintLayout.LayoutParams.HORIZONTAL
        horizontalGL.layoutParams = lp
        horizontalGL.setGuidelineBegin(300)
        constraintLayout.addView(horizontalGL)






        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.connect(
            button_1.id,
            ConstraintSet.RIGHT,
            R.id.constraintLayout,
            ConstraintSet.RIGHT,
            0
        )
        constraintSet.connect(
            button_1.id,
            ConstraintSet.LEFT,
            R.id.constraintLayout,
            ConstraintSet.LEFT,
            0
        )
        constraintSet.applyTo(constraintLayout)

         val constraintSet_2 = ConstraintSet()
        constraintSet_2.clone(constraintLayout)
        constraintSet_2.connect(
            button_2.id,
            ConstraintSet.RIGHT,
            R.id.constraintLayout,
            ConstraintSet.RIGHT,
            0
        )
        constraintSet_2.connect(
            button_2.id,
            ConstraintSet.LEFT,
            R.id.constraintLayout,
            ConstraintSet.LEFT,
            0
        )
        constraintSet_2.connect(
            button_2.id,
            ConstraintSet.TOP,
            horizontalGL.id,
            ConstraintSet.BOTTOM,
            200
        )

        constraintSet_2.applyTo(constraintLayout)




    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            button_1_id -> {
                Log.i("flywood", "plus click!")
                val toast = Toast.makeText(applicationContext, getString(R.string.increment_peffix) + " ("+(++count).toString() + ")" , Toast.LENGTH_SHORT)
                toast.show()
            }
            button_2_id -> {
                Log.i("flywood", "minus click!")
                val toast = Toast.makeText(applicationContext, getString(R.string.increment_peffix) + " (" + (--count).toString() + ")" , Toast.LENGTH_SHORT)
                toast.show()
            }
        }
        Log.i("flywood", "click " + v.id.toString())
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