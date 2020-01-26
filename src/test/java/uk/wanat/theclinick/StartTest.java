package uk.wanat.theclinick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class StartTest {

    @Test
    public void chcekIfHello() {
        Start start = new Start();
        String sayHello = start.sayHello();
        Assertions.assertEquals(sayHello, "hello!!");

    }

}