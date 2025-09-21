package com.bossmg.android.unittestproject.uitest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.bossmg.android.unittestproject.MyApplication
import com.bossmg.android.unittestproject.R

class InputActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val editText = findViewById<EditText>(R.id.input_edit_text)
        val button = findViewById<Button>(R.id.transform_button)

        button.setOnClickListener {
            val input = editText.text.toString()
            (application as MyApplication).transformer.transform(input) { result ->
                startActivity(ResultActivity.newIntent(this, result))
            }
        }
    }
}
