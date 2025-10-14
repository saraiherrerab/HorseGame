package com.example.horsegame


import android.os.Bundle
import android.util.TypedValue
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Point
import android.view.View
import android.widget.TableRow



@Suppress("DEPRECATION")
class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initScreenGame()
    }

    private fun initScreenGame(){
        setSizeBoard()
        hide_message()
    }
    private fun setSizeBoard(){
        var iv: ImageView

        val display =windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val width = size.x

        val width_dp = (width/ getResources().getDisplayMetrics().density)
        var lateralMarginDP = 0

        val widht_cell =(width_dp - lateralMarginDP)/8
        val heigth_cell= widht_cell

        for (i in 0..7){
            for(j in 0..7){
                iv= findViewById(resources.getIdentifier("c$i$j","id", packageName))

                var height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, heigth_cell, getResources().getDisplayMetrics()).toInt()
                var widht = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, widht_cell, getResources().getDisplayMetrics()).toInt()

                iv.setLayoutParams(TableRow.LayoutParams(width, height))
            }
        }

    }
    private fun hide_message(){
        var lyMessage = findViewById<LinearLayout>(R.id.lyMessage)
        lyMessage.visibility = View.INVISIBLE
    }
}