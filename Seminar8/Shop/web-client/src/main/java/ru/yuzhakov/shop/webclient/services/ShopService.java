package ru.yuzhakov.shop.webclient.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ru.yuzhakov.shop.webclient.models.Order;
import ru.yuzhakov.shop.webclient.models.Product;
import ru.yuzhakov.shop.webclient.models.Transaction;
import ru.yuzhakov.shop.webclient.models.api.Payment;
import ru.yuzhakov.shop.webclient.models.api.Storage;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShopService {
    private final Payment paymentApi;
    private final Storage storageApi;
    private final String shopAccount;

    public ShopService(Payment paymentApi, Storage storageApi, @Value("3") String shopAccount) {
        this.paymentApi = paymentApi;
        this.storageApi = storageApi;
        this.shopAccount = shopAccount;
    }

    public List<Product> getAll() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Product>> response = template.exchange(storageApi.getBasicUri(),
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });
        return response.getBody();
    }

    /**
     * Метод покупки товара. На каждом этапе происходит проверка,
     * в случае получения исключения происходит откат транзакций
     * @param productId идентификатор продукта
     * @param amount количество заказанного продукта
     * @param sum сумма заказа
     * @param numberCredit номер счет для списания
     */
    public void buyProduct(Long productId, int amount, BigDecimal sum, Long numberCredit) {
        productReserve(productId, amount);
        try {
            payOrder(sum, numberCredit);
            try {
                productBuy(productId, amount);
            } catch (HttpClientErrorException e) {
                rollbackPayOrder(sum, numberCredit);
                productReserveRollback(productId, amount);
                throw e;
            }
        } catch (HttpClientErrorException e) {
            productReserveRollback(productId, amount);
            throw e;
        }
    }

    private void productReserve(Long id, int amount) throws HttpClientErrorException {
        RestTemplate template = new RestTemplate();
        String path = storageApi.getBasicUri() + id + "/reserve";
        Order order = new Order();
        order.setAmount(amount);
        template.postForEntity(path, order, Object.class);
    }

    private void productReserveRollback(Long id, int amount) throws HttpClientErrorException {
        RestTemplate template = new RestTemplate();
        String path = storageApi.getBasicUri() + id + "/reserve/rollback";
        Order order = new Order();
        order.setAmount(amount);
        template.postForEntity(path, order, Object.class);
    }

    private void productBuy(Long id, int amount) throws HttpClientErrorException {
        RestTemplate template = new RestTemplate();
        Order order = new Order();
        order.setAmount(amount);
        template.postForEntity(storageApi.getBasicUri() + id, order, Object.class);
    }

    private void rollbackPayOrder(BigDecimal sum, Long numberCredit) throws HttpClientErrorException {
        RestTemplate template = new RestTemplate();
        String path = paymentApi.getBasicUri() + "/rollback";
        Transaction transaction = new Transaction();
        transaction.setSum(sum);
        transaction.setCreditNumber(numberCredit);
        transaction.setDebitNumber(Long.parseLong(shopAccount));
        template.postForEntity(path, transaction, Object.class);
    }

    private void payOrder(BigDecimal sum, Long numberCredit) {
        RestTemplate template = new RestTemplate();
        Transaction transaction = new Transaction();
        transaction.setCreditNumber(numberCredit);
        transaction.setDebitNumber(Long.parseLong(shopAccount));
        transaction.setSum(sum);
        template.postForEntity(paymentApi.getBasicUri(), transaction, Object.class);
    }
}
