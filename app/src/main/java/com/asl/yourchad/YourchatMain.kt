package com.asl.yourchad

import android.content.Intent
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
        onClickListeners()
    }

    fun onClickListeners(){
        binding.btnLogout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}