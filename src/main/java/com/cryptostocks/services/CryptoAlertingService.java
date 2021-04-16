package com.cryptostocks.services;


import com.cryptostocks.bindings.CoinListingAlert;
import com.cryptostocks.bindings.PercentPriceAlert;
import com.cryptostocks.collections.CoinListingAlertDocument;
import com.cryptostocks.collections.PercentPriceAlertDocument;
import com.cryptostocks.constants.CryptoAlertType;
import com.cryptostocks.converter.AlertConverter;
import com.cryptostocks.converter.ConverterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.vertx.core.json.JsonObject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

@ApplicationScoped
public class CryptoAlertingService {

    @Inject
    ConverterService converterService;



    public Response  processAlert(String json) throws JsonProcessingException {

        if(json.contains("Confirmation message from Cryptocurrency Alerting!")){
            return Response.ok().build();
        }

        JsonObject obj = new JsonObject(json);
        String value = obj.getString(CryptoAlertType.TYPE);

        if(CryptoAlertType.NEW_COIN_LISTING_ALERT.equalsIgnoreCase(value)){

            AlertConverter alertConverter
                    = converterService.getAlertConverter(CryptoAlertType.NEW_COIN_LISTING_ALERT);

            CoinListingAlert coinListingAlert
                    = (CoinListingAlert) alertConverter.convertTo(value, json);


            CoinListingAlertDocument coinListingAlertDocument = new CoinListingAlertDocument();
            coinListingAlertDocument.type = coinListingAlert.getType();
            coinListingAlertDocument.message = coinListingAlert.getMessage();
            coinListingAlertDocument.currency = coinListingAlert.getCurrency();
            coinListingAlertDocument.exchange = coinListingAlert.getExchange();
            coinListingAlertDocument.insertedDateTime = LocalDateTime.now().toString();
            coinListingAlertDocument.persist();
            return Response.ok().build();
        }

        if(CryptoAlertType.PERCENT_PRICE_ALERT.equalsIgnoreCase(value)){

            AlertConverter alertConverter
                    = converterService.getAlertConverter(CryptoAlertType.PERCENT_PRICE_ALERT);
            PercentPriceAlert percentPriceAlert
                    =(PercentPriceAlert) alertConverter.convertTo(value, json);

            PercentPriceAlertDocument percentPriceAlertDocument = new PercentPriceAlertDocument();
            percentPriceAlertDocument.type = percentPriceAlert.getType();
            percentPriceAlertDocument.currency = percentPriceAlert.getCurrency();
            percentPriceAlertDocument.percent = percentPriceAlert.getPercent();
            percentPriceAlertDocument.current_price = percentPriceAlert.getCurrentPrice();
            percentPriceAlertDocument.direction = percentPriceAlert.getDirection();
            percentPriceAlertDocument.message = percentPriceAlert.getMessage();
            percentPriceAlertDocument.exchange = percentPriceAlert.getExchange();
            percentPriceAlertDocument.window = percentPriceAlert.getWindow();
            percentPriceAlertDocument.persist();

        }

        return Response.status(Response.Status.BAD_REQUEST).build();

    }

    public void postProcessAlert(){
        // to be triggered by scheduler to create links between documents.
    }
}
