package com.shevy.lessonservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast
import androidx.annotation.Nullable

class PlayService : Service() {
    lateinit var mPlayer: MediaPlayer

    override fun onBind(intent: Intent): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(
            this, "Служба создана",
            Toast.LENGTH_SHORT
        ).show()
        mPlayer = MediaPlayer.create(this, R.raw.mishka_kosolapyy)
        mPlayer.isLooping = false
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(
            this, "Служба запущена",
            Toast.LENGTH_SHORT
        ).show()
        mPlayer.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(
            this, "Служба остановлена",
            Toast.LENGTH_SHORT
        ).show()
        mPlayer.stop()
    }
}