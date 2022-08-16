package com.shevy.lessonservice

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.shevy.lessonservice.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnStart: Button = binding.buttonStart
        val btnStop: Button = binding.buttonStop

        // запуск службы
        btnStart.setOnClickListener {
            // используем явный вызов службы
            startService(
                Intent(this@MainActivity, PlayService::class.java)
            )
        }

        // остановка службы
        btnStop.setOnClickListener {
            stopService(
                Intent(this@MainActivity, PlayService::class.java)
            )
        }
    }
}