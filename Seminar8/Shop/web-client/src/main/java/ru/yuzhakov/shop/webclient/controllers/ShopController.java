package ru.yuzhakov.shop.webclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.yuzhakov.shop.webclient.models.Product;
import ru.yuzhakov.shop.webclient.services.ShopService;

import java.math.BigDecimal;

@Controller
public class ShopController {
    private final ShopService service;

    public ShopController(ShopService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String homePage(Model model, @RequestParam(value = "confirm", required = false) String confirm) {
        model.addAttribute("products", service.getAll());
        if (confirm != null) {
            model.addAttribute("confirm", confirm);
        }
        return "home";
    }

    @PostMapping("/buy/{id}")
    public String buyProduct(@PathVariable("id") Long id, @RequestParam("amount") Integer amount,
                             RedirectAttributes redirectAttributes) {
        Product product = service.getAll()
                .stream()
                .filter(prod -> prod.getId().equals(id))
                .findFirst()
                .orElse(null);
        assert product != null;
        BigDecimal sum = product.getPrice().multiply(new BigDecimal(amount));
        service.buyProduct(product.getId(), amount, sum, 1L);
        redirectAttributes.addAttribute("confirm", "Покупка успешна");
        return "redirect:/";
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public String errorPage(HttpMediaTypeException e, Model model) {
        model.addAttribute("message", e.getMessage());
        model.addAttribute("products", service.getAll());
        return "home";
    }
}
