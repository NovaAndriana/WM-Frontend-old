package com.warehousemart.wm.app

import com.warehousemart.wm.model.Checkout
import com.warehousemart.wm.model.ResponModel
import com.warehousemart.wm.model.rajaongkir.ResponOngkir
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("register")
    fun register(
            @Field("name") name :String,
            @Field("email") email :String,
            @Field("phone") nomortlp :String,
            @Field("password") password :String
    ):Call<ResponModel>

    @FormUrlEncoded
    @POST("login")
    fun login(
            @Field("email") email :String,
            @Field("password") password :String
    ):Call<ResponModel>

    @POST("checkout")
    fun checkout(
            @Body data :Checkout
    ):Call<ResponModel>

    @GET("produk")
    fun getProduk():Call<ResponModel>

    @GET("produkdiskon")
    fun getProdukDiskon():Call<ResponModel>

    @GET("menu")
    fun getMenu():Call<ResponModel>

    @GET("brandpopuler")
    fun getBrand():Call<ResponModel>

    @GET("province")
    fun getProvinsi(
            @Header("key") key :String
    ):Call<ResponModel>

    @GET("city")
    fun getKota(
            @Header("key") key :String,
            @Query("province") id:String
    ):Call<ResponModel>

    @GET("kecamatan")
    fun getKecamatan(
            @Query("id_kota") id:Int
    ):Call<ResponModel>

    @FormUrlEncoded
    @POST("cost")
    fun ongkir(
            @Header("key") key :String,
            @Field("origin") origin :String,
            @Field("destination") destination :String,
            @Field("weight") weight :Int,
            @Field("courier") courier :String
    ):Call<ResponOngkir>
}