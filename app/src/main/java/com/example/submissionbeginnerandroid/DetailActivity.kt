package com.example.submissionbeginnerandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.submissionbeginnerandroid.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val photo = intent.getIntExtra(EXTRA_PHOTO, -1)

        binding.tvDetailName.text = name
        binding.tvDetailDescription.text = description
        binding.imgDetailPhoto.setImageResource(photo)

        binding.imgBack.setOnClickListener {
            onBackPressed()
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PHOTO = "extra_photo"
    }
}