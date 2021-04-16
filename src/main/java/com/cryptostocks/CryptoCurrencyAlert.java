package com.cryptostocks;

import com.cryptostocks.coinmarketcap.client.CoinMarketCapService;
import com.cryptostocks.converter.ConverterService;
import com.cryptostocks.services.CryptoAlertingService;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/crypto")
public class CryptoCurrencyAlert {


    @Inject
    ConverterService converterService;

    @Inject
    CoinMarketCapService coinMarketCapService;

    @Inject
    CryptoAlertingService cryptoAlertingService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/alert")
    public Response postAlert(String json) throws JsonProcessingException {
        return cryptoAlertingService.processAlert(json);
    }
}


