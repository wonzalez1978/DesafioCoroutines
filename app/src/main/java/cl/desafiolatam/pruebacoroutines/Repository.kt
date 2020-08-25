package cl.desafiolatam.pruebacoroutines

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

class Repository {

    var url = ("https://apod.nasa.gov/apod/image/1908/M61-HST-ESO-S1024.jpg")
    suspend fun downloadImageFromNetwork(url: String): Bitmap? = withContext(Dispatchers.IO){
        val result = downloadImageFromNetwork(url)
        val urldisplay = url
        var bmp: Bitmap? = null

        val inputStream = URL(urldisplay).openStream()
        bmp = BitmapFactory.decodeStream(inputStream)
        bmp
    }
}