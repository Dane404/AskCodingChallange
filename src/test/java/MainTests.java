import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTests {


    @Test
    public void testFormatAndAddInput_validValues()
    {
        boolean result = Main.formatAndAddInput("How old am I?\"20\"");
        assertTrue(result);
        result = Main.formatAndAddInput("What is Peters favorite food? \"Pizza\"\"Spaghetti\" \"Ice cream\"");
        assertTrue(result);
    }
    @Test
    public void testFormatAndAddInput_invalidValues()
    {
        boolean result = Main.formatAndAddInput("How old am I?\"\"");
        assertFalse(result);
        result = Main.formatAndAddInput("? \"Pizza\"\"Spaghetti\" \"Ice cream\"");
        assertFalse(result);
    }
}
