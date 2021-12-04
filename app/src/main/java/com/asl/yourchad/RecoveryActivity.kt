package com.asl.yourchad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.asl.yourchad.databinding.ActivityRecoveryBinding

class RecoveryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecoveryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecoveryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        listeners()
    }

    fun listeners(){

        //region On Click Listeners

        binding.btnToLogin.setOnClickListener(){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnToRegister.setOnClickListener(){
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnSendRecovery.setOnClickListener(){
            if (Validate.email(binding.inputRecoveryField.text.toString())){
                Toast.makeText(this, "Recovery instructions sent to your Email \n Please check inbox", Toast.LENGTH_LONG).show()
            }else binding.inputRecoveryHolder.error = "Invalid Email"
        }    //endregion

    }

}