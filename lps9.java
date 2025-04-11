import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Stack<Integer> stk=new Stack<>();
		System.out.println("Enter the max capacity of stack");
		int n=sc.nextInt(),c=0;
		System.out.println("Stack Operations :-\n1.Push\n2.Pop\n3.Display\n4.Exit");
		do {
			System.out.print("Enter your choice : ");
			c=sc.nextInt();
			switch(c)
			{
				case 1: if(stk.size()==n)
							{
								System.out.println("Stack Overflow unable to push");
								break;
							}
							System.out.print("Enter the element to push : ");
							stk.push(sc.nextInt());
							break;
				case 2: if(stk.size()==0)
							{
								System.out.println("Stack Underflow unable to pop");
								break;
							}
							System.out.println("Popped Element is "+stk.pop());
							break;
				case 3:	if(stk.size()==0)
							{
								System.out.println("Stack is Empty");
								break;
							}
							System.out.print("The elements on the stack are :- ");
							System.out.println(stk);
							System.out.println();
							break;
				case 4: System.out.println("Exit");
							break;
			}
		}while(c!=4);
	}
}