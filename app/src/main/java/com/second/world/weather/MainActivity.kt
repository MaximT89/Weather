package com.second.world.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.second.world.weather.core.bases.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}