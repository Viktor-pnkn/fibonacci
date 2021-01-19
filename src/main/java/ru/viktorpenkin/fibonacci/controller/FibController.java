package ru.viktorpenkin.fibonacci.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.viktorpenkin.fibonacci.dto.CommonDTO;
import ru.viktorpenkin.fibonacci.dto.NumDTO;

@RestController
@RequestMapping("fibonacci")
public class FibController {

    @GetMapping("/{val}")
    public CommonDTO getValue(@PathVariable Long val) {
        return new CommonDTO("FIB", getFib(val));
    }

    private Long getFib(Long val) {
        Long a = 0L;
        Long b = 1L;
        Long current = 0L;
        for (Long i = 3L; i <= val; i++) {
            current = b + a;
            a = b;
            b = current;
        }
        return current;
    }
}
