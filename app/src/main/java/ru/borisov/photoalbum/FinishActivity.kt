package ru.borisov.photoalbum

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FinishActivity : AppCompatActivity() {
    lateinit var exitBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        exitBTN = findViewById(R.id.exitBTN)
        exitBTN.setOnClickListener {
            finish()
        }
    }
}