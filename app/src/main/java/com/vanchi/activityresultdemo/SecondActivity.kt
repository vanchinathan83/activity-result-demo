package com.vanchi.activityresultdemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vanchi.activityresultdemo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener { view ->
            val intent = Intent()
            intent.putExtra(MainActivity.NAME,binding.tvName.text.toString())
            intent.putExtra(MainActivity.EMAIL, binding.tvEmail.text.toString())
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}