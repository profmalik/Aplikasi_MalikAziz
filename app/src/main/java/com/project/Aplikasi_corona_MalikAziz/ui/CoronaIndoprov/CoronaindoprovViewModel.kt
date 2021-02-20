package com.project.Aplikasi_corona_MalikAziz.ui.CoronaIndoprov

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.Aplikasi_corona_MalikAziz.network.NetworkConfig
import com.project.Aplikasi_corona_MalikAziz.ui.CoronaIndoprov.data.Provinsi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CoronaindoprovViewModel : ViewModel() {

    private var data = MutableLiveData<List<Provinsi>>()
    private var status = MutableLiveData<Boolean>()

    init {
        getIndoProv()
    }

    @SuppressLint("CheckResult")
    private fun getIndoProv() {
        status.value = true
        NetworkConfig().api().getProvinsiData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {indoprov ->
                    data.postValue(indoprov)
                    status.postValue(false)
                },
                { error ->
                    status.postValue(false)
                })
    }

    fun getData() : MutableLiveData<List<Provinsi>> {
        return data
    }

    fun getStatus(): MutableLiveData<Boolean> {
        status.value = true
        return status

    }
}
