package org.example;

import org.example.Model.Question;
import org.example.Repository.QuestionController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static QuestionController questionController = QuestionController.getInstance();
    public static int indentionIndex = 0;

    public static void main(String[] args) {
        boolean continueBoolean = true;

        while(continueBoolean)
        {
            System.out.println("Do you want to ask or add a question?");
            System.out.println("1: Ask");
            System.out.println("2: Add");
            String optionInput = scanner.nextLine();
            try{
                int option = Integer.parseInt(optionInput);
                indentionIndex++;
                switch(option)
                {
                    case 1: askQuestion();
                        break;
                    case 2: addQuestion();
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            }
            catch(Exception ex){
                System.out.println("Input has to be a number");
                scanner.nextLine();
            }
            System.out.println("Continue?(Y or N)");
            String continueInput = scanner.nextLine();
            if(continueInput.equals("N"))
            {
                continueBoolean=false;
            }
            indentionIndex=0;
        }
    }

    private static void addQuestion()
    {
        System.out.println("Adding question(format : <question>? “<answer1>” “<answer2>” “<answerX>”):");
        String questionInput = scanner.nextLine();
        if(questionInput.isBlank())
        {
            System.out.println("Invalid Input");
        }
        else{
            boolean answersValid = formatAndAddInput(questionInput);
            if(answersValid)
            {
                System.out.println("Question Added!");
            }
            else{
                System.out.println("Invalid Input");
            }
        }

    }
    public static boolean formatAndAddInput(String questionInput)
    {
        String [] splitQuestionInput = questionInput.split("\\?");
        if(splitQuestionInput.length==2)
        {
            String questionString = splitQuestionInput[0];
            String answerString = splitQuestionInput[1];
            List<String> answersList = Arrays.stream(answerString.split("\"")).filter(s -> !s.isBlank()).toList();
            return questionController.addQuestion(questionString,answersList);
        }
        return false;
    }
    public static void askQuestion()
    {
        System.out.println("Asking a question which is in the system:");
        String questionInput = scanner.nextLine();
        List<String> answers = questionController.findAnswers(questionInput);
        printAnswers(answers);
    }
    public static void printAnswers(List<String> answers)
    {
        System.out.println("    ".repeat(indentionIndex)+"Answer will be:");
        indentionIndex++;
        answers.forEach(a-> System.out.println("    ".repeat(indentionIndex)+a));
    }
}