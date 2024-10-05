package com.example.submissionbeginnerandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.submissionbeginnerandroid.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvUserName.text = getString(R.string.user_name)
        binding.tvUserEmail.text = getString(R.string.user_email)
        binding.imgProfile.setImageResource(R.drawable.selfphoto)
    }
}
