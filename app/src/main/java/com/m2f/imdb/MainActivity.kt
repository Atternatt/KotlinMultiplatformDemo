package com.m2f.imdb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.m2f.IMDB.core.di.CoreComponent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    @Inject
    lateinit var coreComponent: CoreComponent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swiperefresh.setOnRefreshListener {
        }
    }


}