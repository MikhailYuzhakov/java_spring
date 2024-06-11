package ru.yuzhakov.payment_app.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.yuzhakov.payment_app.models.Account;
import ru.yuzhakov.payment_app.models.Transaction;
import ru.yuzhakov.payment_app.service.PaymentService;

import java.util.List;

@RestController
@AllArgsConstructor
public class PaymentController {
    /**
     * Сервис оплаты.
     */
    private final PaymentService paymentService;

    @GetMapping()
    public ResponseEntity<List<Account>> getAccounts(){
        return ResponseEntity.ok().body(paymentService.getAllAccounts());
    }

    /**
     * Проведение оплаты.
     * @param transaction объект с данными для транзакции.
     * @return ответ с подтверждением.
     */
    @PostMapping()
    public ResponseEntity<Void> transaction(@RequestBody Transaction transaction){
        paymentService.transaction(transaction);
        return ResponseEntity.ok().body(null);
    }

    /**
     * Откат произведенной транзакции.
     * @param transaction объект с данными для транзакции.
     * @return ответ с подтверждением.
     */
    @PostMapping("/rollback")
    public ResponseEntity<Void> rollbackTransaction(@RequestBody Transaction transaction){
        paymentService.rollbackTransaction(transaction);
        return ResponseEntity.ok().body(null);
    }
}
