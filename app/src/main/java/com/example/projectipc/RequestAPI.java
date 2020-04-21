package com.example.projectipc;

import android.text.Annotation;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.UUID;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public  class RequestAPI {

    public static final String BASE_URL="https://192.168.100.5/PTJPPI/Mesin/";
    public static final String LOGIN_URL="https://192.168.100.5/PTJPPI/Login/";


    public static Retrofit retro;



    public static Retrofit getAPI() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient Client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        if(retro==null) {

            retro = new Retrofit.Builder()
                    .baseUrl(BASE_URL).client(unsafeHTTP().build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }return retro;
    }

    public static OkHttpClient.Builder unsafeHTTP() {

        try {
            TrustManager[] trustCert = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {

                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {

                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }

                        public java.security.cert.X509Certificate[] AcceptedIssue() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null,trustCert, new java.security.SecureRandom());
            final SSLSocketFactory socketFactory =sslContext.getSocketFactory();
            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
            clientBuilder.sslSocketFactory(socketFactory,(X509TrustManager)trustCert[0]);
            clientBuilder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session)
                {
                    return true;
                }
            });

            return  clientBuilder;
        } catch (Exception e) {
            throw new RuntimeException();
        }


    }




}