package com.ejazahmed95.toolbox.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ejazahmed95.toolbox.Common.DaggerTestInfo
import com.ejazahmed95.toolbox.R
import com.ejazahmed95.toolbox.dagger.components.DaggerAppComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import android.content.Intent
import android.app.Activity
import android.util.Log
//import com.google.zxing.integration.android.IntentIntegrator


class MainActivity : AppCompatActivity() {

    @Inject lateinit var info: DaggerTestInfo

//    lateinit var barScan: IntentIntegrator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerAppComponent.create().poke(this)
        text_view.text = info.text
//        barScan = IntentIntegrator(this)
        scanBarcode.setOnClickListener {
            startBarcodeScanner()
        }
    }

    private fun startBarcodeScanner() {
//        val intent = Intent("com.google.zxing.client.android.SCAN")
//        startActivityForResult(intent, 0);
//        barScan.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.d("Scanner", "RequestedCode::$requestCode")
        if(requestCode == 0) {
            if (resultCode == Activity.RESULT_OK) {
                // contents contains whatever was encoded
                val contents = intent.getStringExtra("SCAN_RESULT")

                // Format contains the type of code i.e. UPC, EAN, QRCode etc...
                val format = intent.getStringExtra("SCAN_RESULT_FORMAT")
                Log.d("Scanner", "Contents::$contents and format::$format")
            }
        }
    }
}
