package com.cryptostocks.converter;

import com.cryptostocks.bindings.BlockchainAlert;
import com.cryptostocks.constants.CryptoAlertType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BlockchainAlertConverter implements AlertConverter {
    @Override
    public Object convertTo(String alertType, String json) throws JsonProcessingException {


        if (CryptoAlertType.BLOCKCHAIN_ALERT.equalsIgnoreCase(alertType)) {
            return new ObjectMapper().readValue(json, BlockchainAlert.class);
        }
        return null;
    }

    @Override
    public String convertToJSON(Object jacksonObject) throws JsonProcessingException {
        jacksonObject.toString();
        return null;
    }
}
