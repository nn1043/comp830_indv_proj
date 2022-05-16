import java.io.*;
import java.util.*;

public class Game {
    private Questions root;
    private Questions current;
    private Scanner scan;
    private String response;
    private boolean quit;

    public Game(Questions q)
    {
        root = q;
        quit = false;
    }

    public void start()
    {
        current = root;
        showQuestion();
        
        do {
            askQuestions();
        } while  (quit == false);
    }

    private void askQuestions()
    {
        scan = new Scanner(System.in);
        response = scan.nextLine();
        if (response.equals("yes")) { answerYes(); }
        else if (response.equals("no")) { answerNo(); }
        else { response = ""; }
    }

    private void showQuestion()
    {
        System.out.println(current.getQuestion());
    }

    private void answerYes()
    {
        if (current.getExitBool() == true) {
            start();
        }
        else {
            current = current.getChild(1);
            showQuestion();
        }
    }

    private void answerNo()
    {
        if (current.getExitBool() == true) {
            endGame();
        }
        else {
            current = current.getChild(0);
            showQuestion();
        }
    }

    private void endGame()
    {
        System.out.println("Goodbye.");
        quit = true;
    }
}