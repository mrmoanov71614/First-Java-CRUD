
package com.example.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@SpringBootApplication
@RestController
public class CrudApplication {
    private final Map<Integer, String> items = new LinkedHashMap<>();
    private int nextId = 1;

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

    @GetMapping("/api/items")
    public Map<Integer, String> list() {
        return items;
    }

    @PostMapping("/api/items")
    public void add(@RequestParam String name) {
        items.put(nextId++, name);
    }

    @PutMapping("/api/items/{id}")
    public void edit(@PathVariable int id, @RequestParam String name) {
        if (items.containsKey(id)) items.put(id, name);
    }

    @DeleteMapping("/api/items/{id}")
    public void delete(@PathVariable int id) {
        items.remove(id);
    }
}
