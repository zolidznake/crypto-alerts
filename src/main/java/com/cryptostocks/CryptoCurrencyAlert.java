package com.cryptostocks;

import com.cryptostocks.bindings.BitcoinMempoolAlert;
import com.cryptostocks.bindings.CoinListingAlert;
import com.cryptostocks.coinmarketcap.client.CoinMarketCapService;
import com.cryptostocks.constants.CryptoAlertType;
import com.cryptostocks.converter.AlertConverter;
import com.cryptostocks.converter.ConverterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.vertx.core.json.JsonObject;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;

@Path("/crypto")
public class CryptoCurrencyAlert {


    @Inject
    ConverterService converterService;

    @Inject
    CoinMarketCapService coinMarketCapService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/alert")
    public Response postAlert(String json) throws JsonProcessingException {

        JsonObject obj = new JsonObject(json);
        String value = obj.getString(CryptoAlertType.TYPE);


        AlertConverter alertConverter
                = converterService.getAlertConverter(CryptoAlertType.NEW_COIN_LISTING_ALERT);
       Object object =  alertConverter.convertTo(value, json);

        CoinListingAlert coinListingAlert
                = (CoinListingAlert) alertConverter.convertTo(value, json);

        System.out.println(coinListingAlert.toString());

        if (!Objects.isNull(coinListingAlert)) {
            return Response.ok().build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/cmc")
    public Response getLatestListing(){

      //  coinMarketCapService.callLatestListing();
        coinMarketCapService.callAllTokensMap();
        return Response.ok().build();
    }

}


