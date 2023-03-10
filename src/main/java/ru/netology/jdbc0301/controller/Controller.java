package ru.netology.jdbc0301.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdbc0301.repository.Repo;

import java.util.List;


@RestController
@AllArgsConstructor
public class Controller {
    Repo repo;

    @GetMapping("/products/fetch-product")
    private ResponseEntity<List> get(@RequestParam("name") String name) {
        return new ResponseEntity<>(repo.getProductName(name), HttpStatus.OK);
    }
}
