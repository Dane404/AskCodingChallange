import org.example.Model.Question;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {

    @Test
    public void testCreateQuestion_valid_values()
    {
        Question question = new Question("How old am I", List.of("20"));
        assertEquals(List.of("20"),question.getAnswers());
        question =new Question("What is Peters favorite food", List.of("Pizza","Spaghetti","Ice Cream"));
        assertEquals(List.of("Pizza","Spaghetti","Ice Cream"),question.getAnswers());
    }

    @Test
    public void testCreateQuestion_invalidValues()
    {
        Question question = new Question();
        //Liste mit blank values
        boolean result = question.setQuestion("How old am I",List.of(""));
        assertFalse(result);
        //Leere Liste
        result = question.setQuestion("What is Peters favorite food", List.of());
        assertFalse(result);
        //Zu langer String
        result = question.setQuestion(
                "Too long question",
                List.of("_".repeat(256)));
        assertFalse(result);
    }


}
