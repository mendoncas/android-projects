package com.example.rgbpicker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private lateinit var colorView: View
    private  lateinit var redPicker: SeekBar
    private  lateinit var greenPicker: SeekBar
    private  lateinit var bluePicker: SeekBar
    private var red = 0
    private  var green =0;
    private var blue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorView = findViewById(R.id.main_view_color)
        colorView.setBackgroundColor(Color.BLACK)

        redPicker = findViewById(R.id.rSeekBar)
        redPicker.setOnSeekBarChangeListener(this)

        bluePicker = findViewById(R.id.bSeekBar)
        bluePicker.setOnSeekBarChangeListener(this)

        greenPicker = findViewById(R.id.gSeekBar)
        greenPicker.setOnSeekBarChangeListener(this)
    }

    private fun updateColor(){
        colorView.setBackgroundColor(Color.argb(255, red, green, blue))
    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

        when(seekBar.getId()){
            R.id.rSeekBar -> this.red = progress;
            R.id.gSeekBar -> this.green = progress
            R.id.bSeekBar -> this.blue = progress
        }

        updateColor();
        Log.i("app","progrss: $progress")
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }
}