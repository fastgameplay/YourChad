package com.asl.yourchad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.asl.yourchad.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        listeners()


        
    }
    private fun listeners(){

        //region On Click Listeners
        binding.btnLogin.setOnClickListener(){
            Toast.makeText(this, "s", Toast.LENGTH_SHORT).show()
        }
        binding.btnToRegister.setOnClickListener(){
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.btnRecovery.setOnClickListener(){
            val intent = Intent(this, RecoveryActivity::class.java)
            startActivity(intent)
        }
        //endregion
    }

}