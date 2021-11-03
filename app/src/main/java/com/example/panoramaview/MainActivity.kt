package com.example.panoramaview

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.panoramaview.databinding.ActivityMainBinding
import com.google.vr.sdk.widgets.pano.VrPanoramaView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initView()
    }

    private fun initView() {

        // transfer drawable to bit map
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.andes)

        val options = VrPanoramaView.Options()

        // set input image type
        options.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER

        // load image to vrPanoramaView
        binding.vrPanoramaView.loadImageFromBitmap(bitmap, options)

        // enable touch screen to rotate image
        binding.vrPanoramaView.setPureTouchTracking(true)

        // disable cardboard mode
        binding.vrPanoramaView.setStereoModeButtonEnabled(false)

        // disable more info button
        binding.vrPanoramaView.setInfoButtonEnabled(false)

        // enable full screen
        binding.vrPanoramaView.setFullscreenButtonEnabled(true)
    }
}