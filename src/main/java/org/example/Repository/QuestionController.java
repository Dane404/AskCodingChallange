package org.example.Repository;

import org.example.Model.Question;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class QuestionController {
    private List<Question> questions;

    private static QuestionController questionControllerSingleton;

    public QuestionController() {
        questions = new LinkedList<>();
    }

    public static QuestionController getInstance()
    {
        if(questionControllerSingleton==null)
        {
            questionControllerSingleton=  new QuestionController();
        }
        return questionControllerSingleton;
    }


    public boolean addQuestion(String question, List<String> answers) {
        Question newQuestion= new Question();
        boolean isValid = newQuestion.setQuestion(question,answers);
        if(isValid)
        {
            questions.add(newQuestion);
            return true;
        }
        return false;
    }

    public List<String> findAnswers(String question)
    {
        Optional<Question> questionToFind = questions.stream().filter(q->q.getQuestion().equals(question)).findFirst();
        if(questionToFind.isPresent())
        {
            return questionToFind.get().getAnswers();
        }
        return List.of("the answer to life, universe and everything is 42");
    }

}
