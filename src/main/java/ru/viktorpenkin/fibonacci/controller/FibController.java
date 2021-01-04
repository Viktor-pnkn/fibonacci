package ru.viktorpenkin.fibonacci.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.viktorpenkin.fibonacci.dto.NumDTO;

@RestController
@RequestMapping("fibonacci")
public class FibController {

    @GetMapping("/{val}")
    public NumDTO getValue(@PathVariable Integer val) {
        return new NumDTO(getFib(val));
    }

    private Integer getFib(Integer val) {
        int a = 0;
        int b = 1;
        int current = 0;
        for (int i = 3; i <= val; i++) {
            current = b + a;
            a = b;
            b = current;
        }
        return current;
    }
}
