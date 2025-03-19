import java.util.*;
class Main {
 private static Map<String, String[]> productions = new HashMap<>();
 private static final String END_SYMBOL = "$";
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter the number of productions: ");
 int numProductions = sc.nextInt();
 sc.nextLine();
 System.out.println("Enter the productions that are free from Left Recursion (Use '@' Symbol for Epsilon):");
 for (int i = 0; i < numProductions; i++) {
    String production = sc.nextLine();
    String[] parts = production.split("->");
    String nonTerminal = parts[0].trim();
    String[] rules = parts[1].trim().split("\\|");
    productions.put(nonTerminal, rules);
 }
 System.out.print("Enter the String to Check whether it is accepted or not: ");
 String input = sc.nextLine();
 sc.close();
 if (isAccepted(input)) {
 System.out.println("String is not accepted");
 } else {
     System.out.println("String is accepted");
    }
 }
 private static boolean isAccepted(String input) {
 Stack<String> stack = new Stack<>();
 stack.push(END_SYMBOL);
 stack.push("E");
 String[] tokens = input.split("");
 int index = 0;
 while (!stack.isEmpty()) {
    String top = stack.pop();
    if (top.equals(END_SYMBOL) && index == tokens.length) {
        return true;
    }
    if (top.equals(tokens[index])) {
        index++;
    }
     else if (productions.containsKey(top)) {
        boolean matched = false;
        for (String rule : productions.get(top)) {
            if (rule.equals("@")) {
                matched = true;
        } else if (rule.equals(tokens[index])) {
                matched = true;
                for (int i = rule.length() - 1; i >= 0; i--) {
                    stack.push(String.valueOf(rule.charAt(i)));
                }
                break;
            }
        }
        if (!matched) {
            return false;
        }
    } else {
        return false;
        }
    }
    return false;
    }
}
