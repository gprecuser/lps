import java.util.regex.*; 
import java.util.Scanner; 
 
class Main { 
    private static final String K = "int|float|char|else|if|while|return|system"; 
    private static final String I = "[a-zA-Z][a-zA-Z0-9]*";  
    private static final String N = "\\d+";  
    private static final String O = "[+\\-*/=<>!]+"; 
    private static final String S = "[();{}\\[\\]]"; 
    private static final String LIT = "\"[^\"]*\"";  
 
    public static void main(String args[]) { 
        Scanner sc = new Scanner(System.in);  
        String op; 
 
        do { 
            System.out.print("Enter the input String: "); 
            String in = sc.nextLine();  
            System.out.println("Input String: " + in);  
            int tokens = tokenize(in);  
            System.out.println("Total tokens: " + tokens); 
            System.out.print("Do you want to perform another operation (yes/no): "); 
            op = sc.next();  
            sc.nextLine();  
        } while (op.equalsIgnoreCase("yes"));  
 
        sc.close(); 
    } 
    public static int tokenize(String in) { 
        String p = String.format("(%s)|(%s)|(%s)|(%s)|(%s)|(%s)", K, I, N, O, S, LIT); 
        Pattern cp = Pattern.compile(p);  
        Matcher m = cp.matcher(in);  
        int tc = 0; 
        while (m.find()) { 
            if (m.group(1) != null) 
                System.out.println("Keyword: " + m.group(1)); 
            else if (m.group(2) != null) 
                System.out.println("Identifier: " + m.group(2)); 
            else if (m.group(3) != null) 
                System.out.println("Number: " + m.group(3)); 
            else if (m.group(4) != null) 
                System.out.println("Operator: " + m.group(4)); 
            else if (m.group(5) != null) 
                System.out.println("Separator: " + m.group(5)); 
            else if (m.group(6) != null) 
                System.out.println("String Literal: " + m.group(6)); 
            tc++; 
        } 
        return tc; 
    } 
}