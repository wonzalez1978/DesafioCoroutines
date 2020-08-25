package cl.desafiolatam.pruebacoroutines

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

class Repository {

    suspend fun downloadImageFromNetwork(url: String): Bitmap? = withContext(Dispatchers.Default){

        val urldisplay = url
        var bmp: Bitmap? = null

        val inputStream = URL(urldisplay).openStream()
        bmp = BitmapFactory.decodeStream(inputStream)
        bmp
    }
}