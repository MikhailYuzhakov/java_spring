package ru.yuzhakov.homework7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.yuzhakov.homework7.service.AdminService;
import ru.yuzhakov.homework7.service.HomeService;
import ru.yuzhakov.homework7.service.UserService;

@Controller
public class HomeController {
    private final HomeService homeService;
    private final UserService userService;
    private final AdminService adminService;

    public HomeController(HomeService homeService, UserService userService, AdminService adminService) {
        this.homeService = homeService;
        this.userService = userService;
        this.adminService = adminService;
    }

    @GetMapping("/private-data")
    public String privateData() {
        return "private-data";
    }

    @GetMapping("/public-data")
    public String publicData() {
        return "public-data";
    }

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }
}
