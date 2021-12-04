package com.asl.yourchad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.asl.yourchad.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    lateinit var binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        listeners()
    }

    private fun listeners(){

        //region OnTextChange
        binding.inputMailField.doOnTextChanged{text,_,_,_ ->
            if(Validate.email(text.toString())){
                binding.inputMailHolder.error = null
            } else binding.inputMailHolder.error = "Not Valid Email"
        }
        binding.inputUsernameField.doOnTextChanged(){text,_,_,_ ->
            if(!Validate.username(text.toString())) binding.inputUsernameHolder.error = "Max Character Limit"
            else binding.inputUsernameHolder.error = null
        }
        binding.inputPasswordField.doOnTextChanged{text,_,_,_ ->
            var passErrorText = ""
            if(text.toString().length < 9){passErrorText = "At least 9 characters \n"}
            // Validate.password(input : String, id:Int) {0 : [a-z]; 1 : [A-Z]; 2: [0-9]; 3:[\W] }
            if(!Validate.password(text.toString(),0)){passErrorText += "At least one lowercase character \n"}
            if(!Validate.password(text.toString(),1)){passErrorText += "At least one uppercase character \n"}
            if(!Validate.password(text.toString(),2)){passErrorText += "At least one numeric character \n"}
            if(!Validate.password(text.toString(),3)){passErrorText += "At least one special character \n"}

            binding.inputPasswordHolder.error = passErrorText
        }
        //endregion

        //region On Click Listeners
        binding.btnRegister.setOnClickListener(){
            if(Validate.email(binding.inputMailField.text.toString()) && Validate.password(binding.inputPasswordField.text.toString()) && Validate.username(binding.inputUsernameField.text.toString())){
                if(binding.inputPasswordField.text.toString() != binding.inputCPasswordField.text.toString() ) binding.inputCPasswordHolder.error = "Password not match"
                if(binding.inputUsernameField.text.toString().isEmpty()) binding.inputUsernameHolder.error = "Please enter your username"
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(binding.inputMailField.text.toString(),binding.inputPasswordField.text.toString())
                .addOnCompleteListener{task ->
                    if(task.isSuccessful){
                        val intent = Intent(this,LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        binding.btnToLogin.setOnClickListener(){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        //endregion
    }
}