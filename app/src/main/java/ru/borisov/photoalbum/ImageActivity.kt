package ru.borisov.photoalbum

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class ImageActivity : AppCompatActivity() {
    lateinit var nextPhotoBTN: Button
    lateinit var photoIV: ImageView
    private var indexPhoto: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        nextPhotoBTN = findViewById(R.id.nextPhotoBTN)
        photoIV = findViewById(R.id.photoIV)
        indexPhoto = intent.getIntExtra("indexPhoto", 0)
        setImage()
        nextPhotoBTN.setOnClickListener {
            startNextActivity()
            nextPhotoBTN.isEnabled = false
        }
    }

    private fun setImage() {
        setScaleType()
        setResource()
    }

    private fun setScaleType() {
        val randomTypeIndex = (0..2).random()
        photoIV.scaleType = when (randomTypeIndex) {
            0 -> ImageView.ScaleType.CENTER
            1 -> ImageView.ScaleType.CENTER_CROP
            2 -> ImageView.ScaleType.CENTER_INSIDE
            else -> ImageView.ScaleType.FIT_XY
        }
    }

    private fun setResource() {
        val randomTypeIndex = (0..2).random()
        when (randomTypeIndex) {
            0 -> photoIV.setImageResource(getPhotoId())

            1 -> photoIV.setImageDrawable(
                ContextCompat.getDrawable(this, getPhotoId())
            )

            2 -> {
                val bitmap: Bitmap =
                    (ResourcesCompat.getDrawable(resources, getPhotoId(), null) as BitmapDrawable)
                        .bitmap
                photoIV.setImageBitmap(bitmap)
            }
        }
    }

    private fun getPhotoId(): Int = PhotoAlbumSample.bestRussianImagesIds[indexPhoto]

    private fun startNextActivity() {
        val intent = if (indexPhoto < PhotoAlbumSample.bestRussianImagesIds.size - 1) {
            Intent(this, ImageActivity::class.java).apply {
                putExtra("indexPhoto", indexPhoto + 1)
            }
        } else {
            Intent(this, FinishActivity::class.java)
        }
        startActivity(intent)
        finish()
    }
}