package c1475.E;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void c() {
        var main = new Main();

        main.reset();

        assertEquals(1, main.c(5, 0));
        assertEquals(5, main.c(5, 1));
        assertEquals(1, main.c(1, 1));
        assertEquals(6, main.c(4, 2));



    }
}