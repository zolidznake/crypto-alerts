package com.cryptostocks.converter;

import com.cryptostocks.bindings.BitcoinMempoolAlert;
import com.cryptostocks.constants.CryptoAlertType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BitcoinMempoolAlertConverter implements AlertConverter {


    @Override
    public Object convertTo(String alertType, String json) throws JsonProcessingException {
        if (CryptoAlertType.BITCOIN_MEMPOOL_ALERT.equalsIgnoreCase(alertType)) {
            return new ObjectMapper().readValue(json, BitcoinMempoolAlert.class);
        }
        return null;
    }

    @Override
    public String convertToJSON(Object jacksonObject) throws JsonProcessingException {
        return jacksonObject.toString();
    }


}
