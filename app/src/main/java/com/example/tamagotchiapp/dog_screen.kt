package com.example.tamagotchiapp

import android.media.Image
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.delay
import java.util.Timer
import java.util.TimerTask
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask
import kotlin.time.times

class dog_screen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dog_screen)

        val countDownTimer: CountDownTimer
        val clean = findViewById<Button>(R.id.cleanBtn)
        val play = findViewById<Button>(R.id.playBtn)
        val cleanView = findViewById<TextView>(R.id.cleanStat)
        val happyView = findViewById<TextView>(R.id.happyStat)
        val feed = findViewById<Button>(R.id.feedBtn)
        val healthView = findViewById<TextView>(R.id.healthStat)
        val tvResult = findViewById<TextView>(R.id.resultView)
        val image = findViewById<ImageView>(R.id.imgResult)

        //Stats for the dog
        var healthStat = 12
        var happyStat = 12
        var cleanStat = 12

        feed.setOnClickListener {
            if (healthStat < 20) {
                healthStat += 2
                healthView.text = healthStat.toString()
                image.setImageResource(R.drawable.dog_eat)


                if (healthStat > 20) {
                    healthStat == 20
                }
            } else {

                tvResult.text = "Your dog is already full"
            }
        }

        play.setOnClickListener {
            if (happyStat < 20) {
                happyStat += 2
                happyView.text = happyStat.toString()
                image.setImageResource(R.drawable.dog_play)


                if (happyStat > 20) {
                    happyStat == 20

                }
            } else {

                tvResult.text = "Your dog has had too much fun"
            }
        }

        clean.setOnClickListener {
            if (cleanStat < 20) {
                cleanStat += 2
                cleanView.text = cleanStat.toString()
                image.setImageResource(R.drawable.dog_clean)


                if (cleanStat > 20) {
                    cleanStat == 20
                }
            } else {

                tvResult.text = "Your dog is clean"
            }
        }

        //CountDown Timer
        //https://stackoverflow.com/questions/54095875/how-to-create-a-simple-countdown-timer-in-kotlin
        //Gastón Saillén
        //answered Dec 14, 2019 at 6:03
        val durationInMillis = 600000 // 10 minutes in milliseconds
        countDownTimer = object : CountDownTimer(durationInMillis.toLong(), 15000) {
            //Executes every 0.16666667 Minutes
            override fun onTick(millisUntilFinished: Long) {
                healthStat -=2
                happyStat -=2
                cleanStat -=2

                image.setImageResource(R.drawable.dog)

                tvResult.text = ""

                if (healthStat <= 0) {
                    healthStat = 0

                    tvResult.text = "Your dog died from hunger"
                }
                if (happyStat <= 0) {
                    happyStat = 0

                    tvResult.text = "Your dog died from boredom"
                }
                if (cleanStat <= 0) {
                    cleanStat = 0

                    tvResult.text = "Your dog died for uncleanliness"
                }
                healthView.text = healthStat.toString()
                happyView.text = happyStat.toString()
                cleanView.text = cleanStat.toString()
            }

            override fun onFinish() {

            }
        }

        countDownTimer.start()
        //GameOver
        if (
            healthStat == 0 ||
            happyStat == 0 ||
            cleanStat == 0
        ){

            cleanStat += 0
            happyStat += 0
            cleanStat += 0
           countDownTimer.cancel()
        }
    }
}








