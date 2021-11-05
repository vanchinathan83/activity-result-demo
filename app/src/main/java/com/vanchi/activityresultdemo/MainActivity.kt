package com.vanchi.activityresultdemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.vanchi.activityresultdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    companion object {
        private const val FIRST_ACTIVITY_REQUEST_CODE = 1
        private const val SECOND_ACTIVITY_REQUEST_CODE = 2

        const val NAME = "name"
        const val EMAIL = "email"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnFirstActivity.setOnClickListener { view ->
            val firstActivity: Intent = Intent(this, FirstActivity::class.java)
            startActivityForResult(firstActivity, FIRST_ACTIVITY_REQUEST_CODE)
        }

        binding.btnSecondActivity.setOnClickListener { view ->
            val secondActivityIntent = Intent(this, SecondActivity::class.java)
            startActivityForResult(secondActivityIntent, SECOND_ACTIVITY_REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == FIRST_ACTIVITY_REQUEST_CODE){
                binding.tvFirstActivityResult.text = "First Activity Result Success"
            }else if (requestCode == SECOND_ACTIVITY_REQUEST_CODE){
                val name = data!!.getStringExtra(NAME)
                val email = data!!.getStringExtra(EMAIL)
                binding.tvSecondActivityResult.text = "${name.toString()}: ${email.toString()}"
            }
        } else if (resultCode ==  Activity.RESULT_CANCELED){
            Toast.makeText(this, "Result Activity Cancelled.", Toast.LENGTH_SHORT).show()
        }
    }
}