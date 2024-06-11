package ru.yuzhakov.shop.webclient.models.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Обертка для обращения к API склада товаров.
 */
@Component
@ConfigurationProperties("api.storage")
public class Storage {
    private String basicUri;

    public Storage(String basicUri) {
        this.basicUri = basicUri;
    }

    public Storage() {
    }

    public String getBasicUri() {
        return basicUri;
    }

    public void setBasicUri(String basicUri) {
        this.basicUri = basicUri;
    }
}
