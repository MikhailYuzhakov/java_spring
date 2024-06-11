package ru.yuzhakov.product_storage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yuzhakov.product_storage.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
