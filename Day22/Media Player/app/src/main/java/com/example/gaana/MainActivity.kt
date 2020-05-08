package com.example.gaana

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   private lateinit var mp3 :MediaPlayer
   private var totalTime:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mp3 = MediaPlayer.create(this,R.raw.jan)
        mp3.isLooping = false
        mp3.setVolume(5f,5f)
        totalTime = mp3.duration

    }

    fun start(view: View){
          if(mp3.isPlaying){
              mp3.pause()
              Toast.makeText(this,"Song is pause",Toast.LENGTH_LONG).show()
              button_pauseSong.text = "Start"
          }else{
              mp3.start()
              Toast.makeText(this,"Song is start",Toast.LENGTH_LONG).show()
              button_pauseSong.text ="Pause"
          }

    }
    fun stop()
    {
            if(mp3.duration<0)
                stop()
        Toast.makeText(this,"Song is stop",Toast.LENGTH_LONG).show()
    }


}
