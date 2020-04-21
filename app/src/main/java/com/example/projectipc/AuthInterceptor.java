package com.example.projectipc;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {
    @NotNull
    private String tokenAuth;
    AuthInterceptor(String tokenAuth){
        this.tokenAuth=tokenAuth;
    }
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request ori= chain.request();
        Request.Builder builder = ori.newBuilder()
                .header("Authorization",tokenAuth);
        Request request = builder.build();

        return chain.proceed(request);
    }
}
