package com.project.Aplikasi_corona_MalikAziz.network

import com.project.Aplikasi_corona_MalikAziz.ui.CoronaGlobal.data.WorldData
import com.project.Aplikasi_corona_MalikAziz.ui.CoronaGlobaldanIndo.data.GlobalMeninggal
import com.project.Aplikasi_corona_MalikAziz.ui.CoronaGlobaldanIndo.data.GlobalPositif
import com.project.Aplikasi_corona_MalikAziz.ui.CoronaGlobaldanIndo.data.GlobalSembuh
import com.project.Aplikasi_corona_MalikAziz.ui.CoronaGlobaldanIndo.data.Indonesia
import com.project.Aplikasi_corona_MalikAziz.ui.CoronaIndoprov.data.Provinsi
import retrofit2.http.GET
import io.reactivex.Single


interface ApiService {

    @GET("api")
    fun getWorldData(): Single<List<WorldData>>

    @GET("indonesia")
    fun getIDNData(): Single<List<Indonesia>>

    @GET("indonesia/provinsi")
    fun getProvinsiData(): Single<List<Provinsi>>

    @GET("meninggal")
    fun getMeninggalData(): Single<GlobalMeninggal>

    @GET("positif")
    fun getPositifData(): Single<GlobalPositif>

    @GET("sembuh")
    fun getSembuhData(): Single<GlobalSembuh>

}