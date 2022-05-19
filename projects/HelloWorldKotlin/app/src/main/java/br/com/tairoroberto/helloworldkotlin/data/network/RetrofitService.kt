package br.com.tairoroberto.helloworldkotlin.data.network

import br.com.tairoroberto.helloworldkotlin.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitService {

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = "bde8033d3274c91b292a5293c6349052"

        // inicializamos o retrofit com as configurações
        private val retrofit: Retrofit by lazy {

            //Configura parametros de conexão
            val httpClient = OkHttpClient.Builder()
            httpClient.readTimeout(30, TimeUnit.SECONDS)
            httpClient.connectTimeout(30, TimeUnit.SECONDS)
            httpClient.writeTimeout(30, TimeUnit.SECONDS)


            // Se estivermos em modo DEBUG habilitamos os logs
            if (BuildConfig.DEBUG){
                val logInterceptor = HttpLoggingInterceptor()
                logInterceptor.level = HttpLoggingInterceptor.Level.BODY
                httpClient.addInterceptor(logInterceptor)
            }

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
        }


        @JvmStatic
        val apiService: API
         get() = retrofit.create(API::class.java)
    }
}