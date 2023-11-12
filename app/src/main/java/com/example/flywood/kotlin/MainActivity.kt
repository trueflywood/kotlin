package com.example.flywood.kotlin

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintLayout = findViewById(R.id.constraintLayout) as ConstraintLayout

        var actionBar = supportActionBar
        actionBar!!.setDisplayShowCustomEnabled(true)
        var inflate = this.layoutInflater
        var view = inflate.inflate(R.layout.my_actionbar, null)
        var layoutParams = ActionBar.LayoutParams(
            ActionBar.LayoutParams.MATCH_PARENT,
            ActionBar.LayoutParams.MATCH_PARENT
        )

        actionBar.setCustomView(R.layout.my_actionbar)

    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.my_menu, menu)
//        return super.onCreateOptionsMenu(menu)
//    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

//        var id = item.itemId
//        when (id) {
//            R.id.edit -> Toast.makeText(this, "edit ", Toast.LENGTH_SHORT).show()
//            R.id.file -> {
//                var check = item.isChecked
//                item.setChecked(!check)
//                Toast.makeText(this, "file ", Toast.LENGTH_SHORT).show()
//            }
//            R.id.view -> Toast.makeText(this, "view ", Toast.LENGTH_SHORT).show()
//            R.id.help -> Toast.makeText(this, "help ", Toast.LENGTH_SHORT).show()
//
//            else -> { // Note the block
//                print("x is neither 1 nor 2")
//            }
//        }
        return super.onOptionsItemSelected(item)
    }

    fun showSubMenu(view: View) {
       var popupMenu = PopupMenu( this, view)
//       var menuInflater = popupMenu.menuInflater
//        menuInflater.inflate(R.menu.my_menu, popupMenu.menu)
        var menu = popupMenu.menu;
        var subMenu = menu.addSubMenu("sub 1")
        subMenu.add("sub 2")
        subMenu.add("sub 3")
        menu.add("menu 1")
        menu.add("menu 2")
        menu.add("menu 3")
        popupMenu.show()
    }


}