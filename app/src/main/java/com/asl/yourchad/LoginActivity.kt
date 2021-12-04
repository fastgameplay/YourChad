package com.asl.yourchad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.asl.yourchad.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        onClickListeners()


        
    }
    private fun onClickListeners(){

        //region On Click Listeners
        binding.btnLogin.setOnClickListener(){
            if(!Validate.email(binding.inputLoginField.text.toString())){
                binding.inputLoginHolder.error = "Invalid Email address"
                return@setOnClickListener
            }
            //Sign In
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(binding.inputLoginField.text.toString(),binding.inputPasswordField.text.toString())
                .addOnCompleteListener{task ->
                    if(task.isSuccessful){
                        val intent = Intent(this,YourchatMain::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show()
                    }
                }

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