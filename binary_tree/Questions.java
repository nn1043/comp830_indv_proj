import java.util.*;

public class Questions {
    private String question;
    private boolean exitOnNo;
    private List<Questions> children = new ArrayList<>(2);

    public Questions(String q, boolean exit)
    {
        question = q;
        exitOnNo = exit;
    }

    public void setChild(String question, boolean exitOnNo)
    {
        Questions child = new Questions(question, exitOnNo);
        this.children.add(child);
    }

    public Questions getChild(int response)
    {
        return children.get(response);
    }

    public String getQuestion()
    {
        return question;
    }

    public boolean getExitBool()
    {
        return exitOnNo;
    }
}