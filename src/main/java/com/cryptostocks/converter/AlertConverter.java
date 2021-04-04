package com.cryptostocks.converter;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface AlertConverter {

    Object convertTo(String alertType, String json) throws JsonProcessingException;

    String convertToJSON(Object jacksonObject) throws JsonProcessingException;
}
