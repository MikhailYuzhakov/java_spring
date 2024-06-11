package ru.yuzhakov.payment_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yuzhakov.payment_app.models.Account;

@Repository
public interface PaymentRepository extends JpaRepository<Account, Long> {
    Account findByNumber(Long number);
}
