package ru.viktorpenkin.fibonacci.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.viktorpenkin.fibonacci.dto.NumDTO;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FibControllerTest {
    private RestTemplate template = new RestTemplate();
    private Random r = new Random();

    @Test
    public void TestGetFib() {
        int i = r.nextInt(10);
        ResponseEntity<NumDTO> forEntity = template.getForEntity("http://localhost:8082/fibonacci/" + i,
                NumDTO.class);
        Integer actual = forEntity.getBody().getValue();

        int a = 0;
        int b = 1;
        int expected = 0;
        for (int j = 3; j <= i; j++) {
            expected = b + a;
            a = b;
            b = expected;
        }
        assertEquals(expected, actual);
    }
}
