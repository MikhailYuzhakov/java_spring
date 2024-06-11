package ru.yuzhakov.shop.webclient.models.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Обретка для обращения к API оплаты.
 */
@Component
@ConfigurationProperties("api.payment")
public class Payment {
    private String basicUri;

    public Payment(String basicUri) {
        this.basicUri = basicUri;
    }

    public Payment() {
    }

    public String getBasicUri() {
        return basicUri;
    }

    public void setBasicUri(String basicUri) {
        this.basicUri = basicUri;
    }
}
