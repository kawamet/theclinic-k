package uk.wanat.theclinick;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class StartTest {

    @Test
    public void chcekIfHello() {
        Start start = new Start();
        String sayHello = start.sayHello();
        Assert.assertEquals(sayHello, "hello!!");

    }


}