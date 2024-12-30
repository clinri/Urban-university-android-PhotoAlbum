package ru.borisov.photoalbum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var startViewBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startViewBTN = findViewById(R.id.startViewBTN)
        startViewBTN.setOnClickListener {
            startActivity(Intent(this, ImageActivity::class.java))
            finish()
            startViewBTN.isEnabled = false
        }
    }
}