package com.asl.yourchad

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.asl.yourchad.databinding.ActivityValidateUserBinding
import com.google.firebase.auth.FirebaseAuth


class ValidateUserActivity : AppCompatActivity() {
    var isFirstTime: Boolean = true
    lateinit var binding : ActivityValidateUserBinding
    var pStack : MutableList<Int> = mutableListOf()
    var pin : String? = LoadPin()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValidateUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        onClickListeners()
    }
    fun onClickListeners() {
        binding.btn0.setOnClickListener {
            if (pStack.count() < 4) pStack.add(0)
            setPinText(pStack.count() - 1)
        }
        binding.btn1.setOnClickListener {
            if (pStack.count() < 4) pStack.add(1)
            setPinText(pStack.count() - 1)
        }
        binding.btn2.setOnClickListener {
            if (pStack.count() < 4) pStack.add(2)
            setPinText(pStack.count() - 1)
        }
        binding.btn3.setOnClickListener {
            if (pStack.count() < 4) pStack.add(3)
            setPinText(pStack.count() - 1)
        }
        binding.btn4.setOnClickListener {
            if (pStack.count() < 4) pStack.add(4)
            setPinText(pStack.count() - 1)
        }
        binding.btn5.setOnClickListener {
            if (pStack.count() < 4) pStack.add(5)
            setPinText(pStack.count() - 1)
        }
        binding.btn6.setOnClickListener {
            if (pStack.count() < 4) pStack.add(6)
            setPinText(pStack.count() - 1)
        }
        binding.btn7.setOnClickListener {
            if (pStack.count() < 4) pStack.add(7)
            setPinText(pStack.count() - 1)
        }
        binding.btn8.setOnClickListener {
            if (pStack.count() < 4) pStack.add(8)
            setPinText(pStack.count() - 1)
        }
        binding.btn9.setOnClickListener {
            if (pStack.count() < 4) pStack.add(9)
            setPinText(pStack.count() - 1)
        }
        binding.btnFingerprint.setOnClickListener {

        }
        binding.btnDelete.setOnClickListener {
            pStack.removeLastOrNull()
            setPinText(pStack.count())
        }
    }

    fun CheckPass() {
        var tempPass = ""
        if (pStack.count() == 4) {
            if(pin == "") {
                for (i in 1..4) {
                    tempPass += pStack[0]
                    pStack.removeFirst()
                }
                savePin(tempPass)
                pin = tempPass
                setPinText(0)
                return
            }
            else{
                for (i in 1..4) {
                    tempPass += pStack[0]
                    pStack.removeFirst()
                }
                if (tempPass == pin) {
                    // Go To MainPage
                }
                else {
                    //change pin(0,1,2,3) color to red for 2000 ms
                    Toast.makeText(this, "Incorrect Pin, Don't be mad. \n Try again chad", Toast.LENGTH_SHORT).show()
                    setPinText(0)
                }

            }
        }
    }

    //region Save & Load
    fun setPinText(value: Int){
        var text = R.string.Dot.toString()
        for(i in 0..4){
            if(i == value) text = R.string.UnderLine.toString()
            when (value){
                1 -> binding.pin0.text = text
                2 -> binding.pin1.text = text
                3 -> binding.pin2.text = text
                4 -> binding.pin3.text = text
            }
        }

    }

    private fun savePin(value : String){
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putString("pin", value)
        }.apply()
    }
    private fun LoadPin() : String?{
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getString("pin","")
    }
    //endregion
}
