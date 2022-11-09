package com.example.appsonsofcalisthenicsbeta

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class StretchesAmateurActivity : AppCompatActivity() {

    private lateinit var vvWeb: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stretches_amateur)

        var vvWeb = findViewById<VideoView>(R.id.vvStretches)
        var mcWeb = MediaController(this)
        var videoDirecc = Uri.parse("android.resource://estiramientos_piernas.mp4" + R.raw.estiramientos_piernas)

            vvWeb.setVideoPath(videoDirecc.toString())

            mcWeb.setAnchorView(vvWeb)
            vvWeb.setMediaController(mcWeb)




    }
}

