package com.cryptostocks;

import com.cryptostocks.bindings.PriceAlert;
import com.cryptostocks.constants.CryptoAlertType;
import com.cryptostocks.converter.AlertConverter;
import com.cryptostocks.converter.ConverterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.vertx.core.json.JsonObject;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/crypto")
public class CryptoCurrencyAlert {


    @Inject
    ConverterService converterService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/alert")
    public Response postAlert(String json) throws JsonProcessingException {

        JsonObject obj = new JsonObject(json);
        String value = obj.getString(CryptoAlertType.TYPE);


        AlertConverter alertConverter
                = converterService.getAlertConverter(CryptoAlertType.PRICE_ALERT);
       Object object =  alertConverter.convertTo(value, json);

       if(object instanceof PriceAlert){
           object.toString();

        return Response.ok().build();
       }


        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}


