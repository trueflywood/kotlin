package com.example.flywood.kotlin

import android.content.Context
import android.graphics.Typeface
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraCharacteristics.*
import android.hardware.camera2.CameraManager
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
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var button_2_id: Int = 0
    private var button_1_id: Int = 0
    private var count: Int = 0

    private var flashLightStatus: Boolean = false
    private var isFlash = false
    private var cameraId = ""
    private lateinit var cameraManager: CameraManager

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
        button_1.setBackgroundResource(R.drawable.button_shape)
        button_1.setTextColor(ContextCompat.getColor(this, R.color.white))
        button_1.textSize = 40f
        button_1.setTypeface(null, Typeface.BOLD_ITALIC); // for Bold and Italic

        constraintLayout.addView(button_1)

        // Создаем  вторую кнопку
        val button_2 = Button(this)
        button_2.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        button_2.text = getString(R.string.minus_button)
        button_2_id =Button.generateViewId()
        button_2.id =button_2_id
        button_2.setOnClickListener(this)
        button_2.setBackgroundResource(R.drawable.button_shape)
        button_2.setTextColor(ContextCompat.getColor(this, R.color.white))
        button_2.textSize = 40f

        constraintLayout.addView(button_2)

        // выравнивание кнопок

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

         val horizontalGL_2 = Guideline(this)
        horizontalGL_2.id = Guideline.generateViewId()
        val lp_2 = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        lp_2.orientation = ConstraintLayout.LayoutParams.HORIZONTAL
        horizontalGL_2.layoutParams = lp_2
        horizontalGL_2.setGuidelineBegin(20)
        constraintLayout.addView(horizontalGL_2)



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
        constraintSet.connect(
            button_1.id,
            ConstraintSet.TOP,
            horizontalGL_2.id,
            ConstraintSet.BOTTOM,
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

        // определение камеры со вспышкой

        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        var cameraIndex = 0

        Log.i("Flywood", "Camera count: " + cameraManager.cameraIdList.size)

        while (!isFlash && cameraIndex < cameraManager.cameraIdList.size) {

            cameraId = cameraManager.cameraIdList[cameraIndex++]
            val cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraId)
            isFlash = cameraCharacteristics.get(FLASH_INFO_AVAILABLE) === true
        }
        Log.i("flywood", "Is flash: $isFlash")

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
            R.id.flash_button -> {
                Toast.makeText(applicationContext, "Flash button Click", Toast.LENGTH_SHORT).show()


//                val cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraId)
//                isFlash = cameraCharacteristics.get(FLASH_MODE_OFF) === true


                if (isFlash && cameraId.isNotEmpty()) {
                    if (!flashLightStatus) {
                        try {
                            cameraManager.setTorchMode(cameraId, true)
                            flashLightStatus = true

                        } catch (e: CameraAccessException) {
                        }
                    } else {
                        try {
                            cameraManager.setTorchMode(cameraId, false)
                            flashLightStatus = false
                        } catch (e: CameraAccessException) {
                        }
                    }
                } else {
                    Toast.makeText(applicationContext, "Flash not found", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}