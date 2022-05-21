package com.interview.fatsecret.view.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.interview.fatsecret.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.home_container, HomeFragment.newInstance())
                .commitNow()
        }
    }
}