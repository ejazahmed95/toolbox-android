package com.ejazahmed95.toolbox.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ejazahmed95.toolbox.Common.DaggerTestInfo
import com.ejazahmed95.toolbox.R
import com.ejazahmed95.toolbox.dagger.components.DaggerAppComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var info: DaggerTestInfo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerAppComponent.create().poke(this)
        text_view.text = info.text
    }
}
