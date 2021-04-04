package com.cryptostocks.converter;

import com.cryptostocks.bindings.CoinListingAlert;
import com.cryptostocks.constants.CryptoAlertType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CoinListingAlertConverter implements AlertConverter {
    @Override
    public Object convertTo(String alertType, String json) throws JsonProcessingException {
        if (CryptoAlertType.NEW_COIN_LISTING_ALERT.equalsIgnoreCase(alertType)) {
            return new ObjectMapper().readValue(json, CoinListingAlert.class);
        }
        return null;
    }

    @Override
    public String convertToJSON(Object jacksonObject) throws JsonProcessingException {
        return jacksonObject.toString();
    }
}
