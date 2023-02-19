package com.example.timer

import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    var time:Int = 0

    var edit_text:EditText? = null
    var text_view:TextView?=null
    var start_button:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit_text = findViewById(R.id.editTextNumber)
        text_view = findViewById(R.id.textView)
        start_button = findViewById(R.id.button)

        start_button?.setOnClickListener{

            calc()
        }

    }

    fun calc()
    {

        time = edit_text?.getText().toString().toInt()
        edit_text?.setVisibility(View.GONE);

        object : CountDownTimer(((time+1)*1000).toLong(), 1000) {

            override fun onTick(millisUntilFinished: Long) {
                text_view?.setText("" + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                val toneGen1 = ToneGenerator(AudioManager.STREAM_MUSIC, 100)
                toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP, 150)
                text_view?.setText("done!")
            }
        }.start()






    }
}