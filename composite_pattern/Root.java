public class Root implements Question {
    private String question;
    private boolean exit;
    
    public Root(String q, boolean e)
    {
        question = q;
        exit = e;
    }

    public String getQuestion()
    {
        return question;
    }

    public boolean getExitBool()
    {
        return exit;
    }

    // create child nodes as needed
    public Questions getYes()
    {
        Question yes = new Question(
            "Does it provide the object creation mechanism that enhance the flexibilities of existing code?",
            no
        );
    }

    // should never be hit, exit game on no for root
    public Questions getNo()
    {
        return this;
    }
}