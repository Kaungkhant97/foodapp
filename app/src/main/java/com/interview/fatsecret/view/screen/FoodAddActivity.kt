package com.interview.fatsecret.view.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.palette.graphics.Palette
import com.interview.fatsecret.util.FOODADD_EXTRA_DATA
import com.interview.fatsecret.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodAddActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_add)
        val type = intent.getIntExtra(FOODADD_EXTRA_DATA,0);

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FoodAddFragment.newInstance(type))
                .commitNow()
        }
    }
}