package ru.yuzhakov.resource_server.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class ResourceController {

    /**
     * Получение изображения кота
     * @return ответ с массивом байт.
     */
    @GetMapping("/cat")
    public ResponseEntity<byte[]> getImageCat() {
        try (InputStream in = new FileInputStream("cat.jpg")) {
            byte[] image = in.readAllBytes();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(image, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
