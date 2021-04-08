package com.cryptostocks.coinmarketcap.client;

import okhttp3.Interceptor;
import okhttp3.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class AuthInterceptor implements Interceptor {

    @ConfigProperty(name = "coinmarketcap.token")
    private String coinMarketCapToken;

    @Override
    public Response intercept(Chain chain) throws IOException {
        var authenticationRequest = chain.request()
                .newBuilder().
                        addHeader("X-CMC_PRO_API_KEY", coinMarketCapToken).build();
        return chain.proceed(authenticationRequest);
    }
}
