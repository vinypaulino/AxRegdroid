package br.com.anestech.axreg_droid.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    private val _data = MutableLiveData<String>()
    val data: LiveData<String>
    get() = _data

    init {
        _data.value = "Hello, Jetpack"
    }
}
