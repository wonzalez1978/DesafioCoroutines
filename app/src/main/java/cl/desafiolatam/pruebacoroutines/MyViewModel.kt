package cl.desafiolatam.pruebacoroutines

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel:ViewModel() {
    val repository = Repository()

    val url = "https://apod.nasa.gov/apod/image/1908/M61-HST-ESO-S1024.jpg"

    private val imageLiveData  = MutableLiveData<Bitmap>()

    fun getImage() : LiveData<Bitmap>{
        viewModelScope.launch {
           val result = repository.downloadImageFromNetwork(url)
            Log.d(tag, result.toString())
            imageLiveData.postValue(result)
        }
            return imageLiveData
    }
}