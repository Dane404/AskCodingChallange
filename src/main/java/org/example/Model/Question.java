package org.example.Model;

import java.util.LinkedList;
import java.util.List;

public class Question {
    private String question;
    private List<String> answers;


    public Question() {
    }

    public Question(String question, List<String> answers) {
        setQuestion(question,answers);
    }

    public String getQuestion()
    {
        return this.question;
    }
    public List<String> getAnswers()
    {
        return this.answers;
    }

    public boolean setQuestion(String question,List<String> answerList)
    {
        if(!question.isBlank()&&!answerList.isEmpty()&& answerList.stream().noneMatch(String::isBlank))
        {
            if(question.length()<=255&&answerList.stream().mapToInt(String::length).sum()<=255) {
                this.question = question;
                this.answers = answerList;
                return true;
            }
        }
        return false;
    }

}
