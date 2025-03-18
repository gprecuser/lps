import java.util.Scanner; 
class Main { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter the String:"); 
        String str = sc.nextLine(); 
        dfa(str); 
        sc.close();  
    } 
    static void dfa(String data) {  
        int n = data.length(); 
        int q = 0;  
        for (int i = 0; i < n; i++) {  
            if (data.charAt(i) != 'a' && data.charAt(i) != 'b' && data.charAt(i) != 'c') { 
                System.out.println("Given string is invalid."); 
                return; 
            }           
            switch (q) { 
                case 0: 
                    q = (data.charAt(i) == 'a') ? 1 : 0; 
                    break; 
                case 1: 
                    q = (data.charAt(i) == 'b') ? 2 : (data.charAt(i) == 'a') ? 1 : 0; 
                    break; 
                case 2: 
                    q = (data.charAt(i) == 'c') ? 3 : (data.charAt(i) == 'a') ? 1 : 0; 
                    break; 
                case 3: 
                    q = (data.charAt(i) == 'a') ? 1 : 0; 
                    break; 
            } 
        }         
        if (q == 3) 
            System.out.println("Accepted"); 
        else 
            System.out.println("Not Accepted"); 
    } 
}