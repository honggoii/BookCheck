package org.honggoii.bookcheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.honggoii.bookcheck.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)

        setContentView(binding.root)
    }
}