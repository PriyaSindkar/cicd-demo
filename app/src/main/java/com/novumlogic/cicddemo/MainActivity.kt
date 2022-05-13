package com.novumlogic.cicddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.text.isDigitsOnly
import androidx.databinding.DataBindingUtil
import com.novumlogic.cicddemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(binding) {
            btnSum.setOnClickListener {
                if (firstNumber.validate() && secondNumber.validate()) {
//                    btnSum.text = (firstNumber.getNumber().plus(secondNumber.getNumber())).toString()
                    btnSum.text = (firstNumber.getNumber() + (secondNumber.getNumber())).toString()
                }
            }
        }
    }

    private fun AppCompatEditText.validate(): Boolean {
        return if (text.isNullOrEmpty()) {
            error = "Cannot be empty"
            false
        } else if (!text!!.isDigitsOnly()) {
            error = "Should only be a number"
            false
        } else true

    }

    private fun AppCompatEditText.getNumber() = text.toString().toInt()
}