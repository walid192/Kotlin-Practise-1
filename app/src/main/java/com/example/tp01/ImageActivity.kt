package com.example.tp01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.tp01.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var binding: ActivityImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageView = binding.imageView
        val btnChooseImage = binding.pickImage

        btnChooseImage.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        val imgPick = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        getResult.launch(imgPick)
    }

    private val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data: Intent? = result.data
            val imageUri = data?.data
            imageView.setImageURI(imageUri)
        }
    }
}