package com.swkang.restingplaces.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.swkang.restingplaces.R

/**
 * @author kangsungwoo
 * @since 5/18/2020
 */
class RestingPlaceActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restingplaces_activity)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

}