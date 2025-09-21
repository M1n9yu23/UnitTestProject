package com.bossmg.android.unittestproject.uitest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bossmg.android.unittestproject.R

class ResultActivity : AppCompatActivity() {
    companion object {
        private const val EXTRA_RESULT = "extra_result"
        fun newIntent(context: Context, result: String) =
            Intent(context, ResultActivity::class.java).putExtra(EXTRA_RESULT, result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        findViewById<TextView>(R.id.result_text_view).text =
            getString(R.string.result, intent.getStringExtra(EXTRA_RESULT) ?: "")
    }
}
