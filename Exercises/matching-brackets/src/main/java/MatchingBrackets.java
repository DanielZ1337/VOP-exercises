import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MatchingBrackets {


    public static void main(String[] args) throws FileNotFoundException {
        MatchingBrackets pc = new MatchingBrackets();
        String expression = "";

        boolean bonus = true;
        if (!bonus) {
            Scanner in = new Scanner(System.in);
            do {
                System.out.println("Enter an expression with { [ ( ) ] }: ('q' to stop)");
                expression = in.nextLine();
                if (!expression.equalsIgnoreCase("q")) {
                    boolean b = pc.checkBrackets(expression);
                    System.out.println(expression + " has balanced brackets: " + b);
                }
            } while (!expression.equalsIgnoreCase("q"));
        } else {
            Scanner in = new Scanner(new File("C:\\Users\\danielz\\Documents\\SDU\\VOP\\VOP-exercises\\Exercises\\matching-brackets\\brackets.txt"));
            while (in.hasNextLine()) {
                expression = in.nextLine();
                boolean b = pc.checkBrackets(expression);
                System.out.println(expression + " has balanced brackets: " + b);
            }
        }
    }

    public boolean checkBrackets(String expression) {
        boolean task1 = false;
        if (task1) {
            Stack<Character> characterStack = new Stack<>();
            expression.chars().forEach(c -> {
                if (c == '(') {
                    characterStack.push((char) c);
                } else if (c == ')') {
                    characterStack.pop();
                }
            });
            return characterStack.isEmpty();
        } else {
            List<Character> characterList = new ArrayList<>();
            expression.chars().forEach(c -> {
                if (c == '(') {
                    characterList.add((char) c);
                } else if (c == ')') {
                    characterList.remove(0);
                }
            });
            return characterList.isEmpty();
        }
    }
}
