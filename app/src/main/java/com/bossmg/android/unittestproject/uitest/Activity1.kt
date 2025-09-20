package com.bossmg.android.unittestproject.uitest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bossmg.android.unittestproject.R
import android.widget.Button
import com.bossmg.android.unittestproject.MyApplication

class Activity1: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)
        findViewById<Button>(R.id.activity_1_button).setOnClickListener {
            (application as MyApplication).synchronizer.executeAfterDelay {
                startActivity(Activity2.newIntent(this, it))
            }
        }
    }
}