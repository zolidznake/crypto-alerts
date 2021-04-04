package com.cryptostocks.converter;

import com.cryptostocks.bindings.PriceAlert;
import com.cryptostocks.constants.CryptoAlertType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PriceAlertConverter implements AlertConverter {
    @Override
    public Object convertTo(String alertType, String json) throws JsonProcessingException {
        if (CryptoAlertType.PRICE_ALERT.equalsIgnoreCase(alertType)) {
            return new ObjectMapper().readValue(json, PriceAlert.class);
        }
        return null;
    }

    @Override
    public String convertToJSON(Object jacksonObject) throws JsonProcessingException {
        return jacksonObject.toString();
    }
}
