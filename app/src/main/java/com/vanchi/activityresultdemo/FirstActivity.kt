package com.vanchi.activityresultdemo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vanchi.activityresultdemo.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnFinishActivity.setOnClickListener { view ->
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}