package com.example.calculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RelativeLayout
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var number1: EditText
    lateinit var number2: EditText
    lateinit var layout: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1=findViewById<EditText>(R.id.edit_num1)
        number2=findViewById<EditText>(R.id.edit_num2)
        layout=findViewById<RelativeLayout>(R.id.mainlayout)

        button_add.setOnClickListener{
            var num1 = Integer.parseInt(number1.text.toString())
            var num2 = Integer.parseInt(number2.text.toString())
            addition(num1,num2)
        }
        button_sub.setOnClickListener{
            var num1 = Integer.parseInt(number1.text.toString())
            var num2 = Integer.parseInt(number2.text.toString())
            sub(num1,num2)
        }

        button_mul.setOnClickListener{
            var num1 = Integer.parseInt(number1.text.toString())
            var num2 = Integer.parseInt(number2.text.toString())
            multiplication(num1,num2)
        }

        button_div.setOnClickListener{
            var num1 = Integer.parseInt(number1.text.toString())
            var num2 = Integer.parseInt(number2.text.toString())
            division(num1,num2)
        }

    }


    fun addition(num1: Int, num2: Int) {
        var add :Int = num1 + num2
      //  Snackbar.make(layout,"Addition is $add",Snackbar.LENGTH_LONG).show()
    }

    fun sub(num1: Int,num2: Int){
         var add :Int = num1 - num2
        Snackbar.make(layout,"Subtraction is $add",Snackbar.LENGTH_LONG).show()
    }
    fun multiplication(num1:Int, num2: Int){
        var add :Int = num1 * num2
        Snackbar.make(layout,"Multiplication is $add",Snackbar.LENGTH_LONG).show()
    }
    fun division(num1:Int,num2:Int){
        var add :Int = num1 / num2
        Snackbar.make(layout,"Division  is $add",Snackbar.LENGTH_LONG).show()
    }
}
