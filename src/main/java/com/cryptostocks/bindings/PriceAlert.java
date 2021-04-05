package com.cryptostocks.bindings;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "message",
        "currency",
        "direction",
        "price",
        "target_currency",
        "exchange"
})
@Generated("jsonschema2pojo")
public class PriceAlert {

    @JsonProperty("type")
    private String type;
    @JsonProperty("message")
    private String message;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("direction")
    private String direction;
    @JsonProperty("price")
    private String price;
    @JsonProperty("target_currency")
    private String targetCurrency;
    @JsonProperty("exchange")
    private String exchange;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PriceAlert() {
    }

    /**
     * @param targetCurrency
     * @param price
     * @param currency
     * @param exchange
     * @param type
     * @param message
     * @param direction
     */

    @JsonCreator
    public PriceAlert( @JsonProperty("type") String type,
                       @JsonProperty("message") String message,
                       @JsonProperty("currency") String currency,
                       @JsonProperty("direction") String direction,
                       @JsonProperty("price") String price,
                       @JsonProperty("target_currency") String targetCurrency,
                       @JsonProperty("exchange") String exchange) {
        super();
        this.type = type;
        this.message = message;
        this.currency = currency;
        this.direction = direction;
        this.price = price;
        this.targetCurrency = targetCurrency;
        this.exchange = exchange;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    @JsonProperty("direction")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("target_currency")
    public String getTargetCurrency() {
        return targetCurrency;
    }

    @JsonProperty("target_currency")
    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    @JsonProperty("exchange")
    public String getExchange() {
        return exchange;
    }

    @JsonProperty("exchange")
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @Override
    public String toString() {
        return "PriceAlert{" +
                "type='" + type + '\'' +
                ", message='" + message + '\'' +
                ", currency='" + currency + '\'' +
                ", direction='" + direction + '\'' +
                ", price='" + price + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", exchange='" + exchange + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}