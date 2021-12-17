package com.asl.yourchad

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.asl.yourchad.databinding.ActivityYourchatMainBinding
import com.google.firebase.auth.FirebaseAuth

class YourchatMain : AppCompatActivity() {
    lateinit var binding : ActivityYourchatMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYourchatMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        onClickListeners()                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ;val uriPath = "android.resource://com.asl.yourchad/" + R.raw.ic_splash_screen; val uri: Uri = Uri.parse(uriPath); binding.imageView.setVideoURI(uri); binding.imageView.requestFocus();binding.imageView.start() // at least
    }

    fun onClickListeners(){

        //log out
        binding.btnLogout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}