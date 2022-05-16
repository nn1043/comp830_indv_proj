import java.io.*;

public class Main {
    // this recursion is currently broken, and will not fully parse the text file. I've spent hours trying to debug
    // this and have yet to figure out what I'm doing wrong, however the logic 'recurse full left, up and right then
    // left, etc.' should work if I were able to set up the text file appropriately
    private static void setTree(Questions current, BufferedReader br, File file) throws IOException
    {
        String line = br.readLine();
        boolean isFinal;

        // known bug where this prevents 'yes' from properly recursing
        if (line.charAt(0) == '.')
            return;

        // no
        if (line.substring(line.length() - 1).equals("0")) {
            isFinal = true;
        } else { isFinal = false; }
 
        current.setChild(line, isFinal);
        setTree(current.getChild(0), br, file);
        if (isFinal)
            return;


        // yes
        line = br.readLine();
        if (line.charAt(0) == '.')
            return;
        if (line.substring(line.length() - 1).equals("0")) {
            isFinal = true;
        } else { isFinal = false; }

        current.setChild(line, isFinal);
        setTree(current.getChild(1), br, file);
    }

    public static void main(String args[]) throws IOException
    {
        File file = new File("questions-test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        Questions q = new Questions("Welcome to the game! Think of a design pattern and answer these following yes/no questions. Ready?", false);
        
        setTree(q, br, file);

        Game game = new Game(q);
        game.start();
    }
}