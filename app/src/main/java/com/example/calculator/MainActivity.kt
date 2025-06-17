package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var etNum1: EditText
    lateinit var etNUm2: EditText
    lateinit var btnAdd: Button
    lateinit var btnSubtract: Button
    lateinit var btnMultiply: Button
    lateinit var btnDivide: Button
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        castViews()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun castViews(){
        etNum1=findViewById(R.id.etNum1)
        etNUm2=findViewById(R.id.etNum2)
        btnAdd=findViewById(R.id.btnAdd)
        btnSubtract=findViewById(R.id.btnSubtract)
        btnMultiply=findViewById(R.id.btnMultiply)
        btnDivide=findViewById(R.id.btnDivide)
        tvResult=findViewById(R.id.tvResult)
    }

    override fun onResume() {
        super.onResume()
        btnAdd.setOnClickListener{
            var num1=etNum1.text.toString()
            var num2=etNUm2.text.toString()
            var sum=num1.toInt()+num2.toInt()
            tvResult.text=sum.toString()

        }
        btnSubtract.setOnClickListener{
            var num1=etNum1.text.toString()
            var num2=etNUm2.text.toString()
            var subtraction=num2.toInt()-num1.toInt()
            tvResult.text=subtraction.toString()
        }
        btnMultiply.setOnClickListener{
            var num1=etNum1.text.toString()
            var num2=etNUm2.text.toString()
            var multiplication=num1.toInt()*num2.toInt()
            tvResult.text=multiplication.toString()
        }
        btnDivide.setOnClickListener{
            var num1=etNum1.text.toString()
            var num2=etNUm2.text.toString()
            if(num2.toInt() == 0){
                tvResult.text = "Cann't divide by zero."
            }
            else{
                var division=num1.toInt()/num2.toInt()
                tvResult.text=division.toString()
            }

        }
    }

}
