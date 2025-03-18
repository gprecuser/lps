import java.util.Scanner; 
class ProductionRule { 
    String left, right; 
    ProductionRule(String left, String right) { 
        this.left = left; 
        this.right = right; 
    } 
} 
class Main { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter the number of production rules: "); 
        int ruleCount = sc.nextInt(); 
        sc.nextLine(); 
        ProductionRule[] rules = new ProductionRule[ruleCount]; 
        System.out.println("Enter the production rules (in the form 'left->right'): "); 
        for (int i = 0; i < ruleCount; i++) { 
            String[] temp = sc.nextLine().split("->"); 
            rules[i] = new ProductionRule(temp[0], temp[1]); 
        } 
        System.out.print("Enter the input string: "); 
        String input = sc.nextLine(); 
        String stack = ""; 
        int i = 0; 
        System.out.println("Stack\tInputBuffer\tAction"); 
        while (true) { 
            if (i < input.length()) { 
                char ch = input.charAt(i++); 
                stack += ch; 
                System.out.printf("%s\t%s\t\tShift %c\n", stack, input.substring(i), ch); 
            } 
            boolean reduced = false; 
            for (ProductionRule rule : rules) { 
                int index = stack.indexOf(rule.right); 
                if (index != -1) { 
                    stack = stack.substring(0, index) + rule.left + stack.substring(index + rule.right.length()); 
                    System.out.printf("%s\t%s\t\tReduce %s->%s\n", stack, input.substring(i), rule.left, rule.right); 
                    reduced = true; 
                    break; 
                } 
            } 
            if (stack.equals(rules[0].left) && i == input.length()) { 
                System.out.println("\nAccepted"); 
                break; 
            } 
            if (i == input.length() && !reduced) { 
                System.out.println("\nError");
                break; 
            } 
        }
        sc.close(); 
    } 
}