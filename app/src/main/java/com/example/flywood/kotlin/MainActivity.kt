package com.example.flywood.kotlin

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintLayout = findViewById(R.id.constraintLayout) as ConstraintLayout
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var id = item.itemId
        when (id) {
            R.id.edit -> Toast.makeText(this, "edit ", Toast.LENGTH_SHORT).show()
            R.id.file -> {
                var check = item.isChecked
                item.setChecked(!check)
                Toast.makeText(this, "file ", Toast.LENGTH_SHORT).show()
            }
            R.id.view -> Toast.makeText(this, "view ", Toast.LENGTH_SHORT).show()
            R.id.help -> Toast.makeText(this, "help ", Toast.LENGTH_SHORT).show()

            else -> { // Note the block
                print("x is neither 1 nor 2")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}