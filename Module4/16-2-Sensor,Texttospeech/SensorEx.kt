package com.example.a

import android.annotation.SuppressLint
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class SensorEx : AppCompatActivity(), SensorEventListener
{
    lateinit var txt1: TextView
    lateinit var sensorManager: SensorManager
    var lastupdate=58468468
    var color=false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_ex)

        txt1 = findViewById(R.id.txt1)
        //view.setBackgroundColor(Color.RED)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        lastupdate = System.currentTimeMillis().toInt()


        txt1.setBackgroundColor(Color.GREEN)


    }

    override fun onSensorChanged(event: SensorEvent?)
    {
            if(event!!.sensor.type == Sensor.TYPE_ACCELEROMETER)
            {
                getaccelarometer(event)
            }
    }

    private fun getaccelarometer(p0: SensorEvent)
    {

        val values = p0.values

        val x = values[0]
        val y = values[1]
        val z = values[2]

        var accelationSquareRoot = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH)

        var actualTime = p0.timestamp


        if(accelationSquareRoot >= 2)
        {
            if(actualTime - lastupdate < 200)
            {
                return
            }
            lastupdate = actualTime.toInt()

            Toast.makeText(applicationContext,"Device Was Shuffled",Toast.LENGTH_LONG).show()

            if(color)
            {
                txt1.setBackgroundColor(Color.GREEN)
            }
            else
            {
                txt1.setBackgroundColor(Color.RED)
            }

            color = !color
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int)
    {

    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}