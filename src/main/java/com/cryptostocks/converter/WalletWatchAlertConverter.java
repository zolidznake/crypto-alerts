package com.cryptostocks.converter;

import com.cryptostocks.bindings.WalletWatchAlert;
import com.cryptostocks.constants.CryptoAlertType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WalletWatchAlertConverter implements AlertConverter {
    @Override
    public Object convertTo(String alertType, String json) throws JsonProcessingException {
        if (CryptoAlertType.WALLET_WATCH_ALERT.equalsIgnoreCase(alertType)) {
            return new ObjectMapper().readValue(json, WalletWatchAlert.class);
        }
        return null;
    }

    @Override
    public String convertToJSON(Object jacksonObject) throws JsonProcessingException {
        return jacksonObject.toString();
    }
}
