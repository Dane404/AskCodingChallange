import org.example.Model.Question;
import org.example.Repository.QuestionController;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    QuestionController questionController = QuestionController.getInstance();

    @Test
    public void testAddQuestion_validValues()
    {
        //Eine Antwort
        boolean result = questionController.addQuestion("How old am I",List.of("20"));
        assertTrue(result);
        //Mehrere Antworten
        result = questionController.addQuestion("What is Peters favorite food", List.of("Pizza","Spaghetti","Ice Cream"));
        assertTrue(result);
    }

    @Test
    public void testAddQuestion_invalidValues()
    {
        //Liste mit blank values
        boolean result = questionController.addQuestion("How old am I",List.of(""));
        assertFalse(result);
        //Leere Liste
        result = questionController.addQuestion("What is Peters favorite food", List.of());
        assertFalse(result);
        //Zu langer String
        result = questionController.addQuestion(
                "Too long question",
                List.of("_".repeat(256)));
        assertFalse(result);
    }
}
