package com.example.inixvideoplayer

import android.net.Uri
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.MediaController
import android.widget.VideoView
import com.example.inixvideoplayer.databinding.ActivityMainBinding
import java.util.logging.Level.parse

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val videoView = findViewById<VideoView>(binding.testVideoView.id)
        //creating the media controller
        val mediaContoller = MediaController(this)
        mediaContoller.setAnchorView(videoView)

        //setting the location for a resource folder for a video
        val uri: Uri = Uri.parse("android.resource://" + packageName + "/raw/test")

        //Setting the MediaController and URI and starting the video
        videoView.setMediaController(mediaContoller)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }

}