package krasnikov.project.drawableimageapp

import android.graphics.*
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import java.io.ByteArrayOutputStream


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.ivBitmap).setImageBitmap(createBitmap())

        loadImage()
    }

    private fun createBitmap(): Bitmap {

        // create bitmap
        val bitmapOp = BitmapFactory.Options().apply { inMutable = true }
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.porsche, bitmapOp)

        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.color = Color.rgb(77, 0, 77);

        // draw circle on bitmap
        canvas.drawCircle(777f, 777f, 256f, paint)

        // convert bitmap to ByteArray
        val outStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outStream)

        return bitmap
    }

    private fun loadImage() {
        val imageView = findViewById<View>(R.id.ivGlide) as ImageView

        Glide.with(this)
            .load("https://autobant.ru/img/4671399_1160.jpg")
            .placeholder(R.drawable.ic_loading)
            .circleCrop()
            .into(imageView)
    }
}