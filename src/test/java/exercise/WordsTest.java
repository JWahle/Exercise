package exercise;

import static org.junit.Assert.*;
import org.junit.Test;

public class WordsTest {

    @Test
    public void thisIsJustAFailingExampleTest() {
        assertTrue(
                !new Words("test words").asString().isEmpty()
        );
    }

}