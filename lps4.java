import java.util.*;
class Main
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter production");
		String production=sc.nextLine();
		String leftright[]=production.split("->");
		String rightparts[]=leftright[1].split("\\|");
		String prefix=prefixcalc(rightparts);
		System.out.println("After eliminating left factoring : ");
		if(rightparts.length==1 || prefix.length()==0)
		{
			System.out.println(production);
			return;
		}
		System.out.print(leftright[0]+" -> "+prefix+leftright[0]+"'");
		String ans="";
		for(int i=0;i<rightparts.length;i++)
		{
			if(rightparts[i].matches("[a-z]"))
				System.out.print("| "+rightparts[i]);
			else if(rightparts[i].startsWith(prefix))
			{
				String x=rightparts[i].substring(prefix.length());
				if(x.length()==0)
					x="epsilon";
				if(ans.length()!=0)
					ans+="|";
				ans+=x;
			}
		}
		System.out.println("\n"+leftright[0]+"' -> "+ans);
		
	}
	public static String prefixcalc(String[] rightparts)
	{
		String check=rightparts[0];
		for(int i=0;i<rightparts.length;i++)
		{
			if(rightparts[i].matches("[a-z]+"))
					continue;
			 while(!rightparts[i].startsWith(check))
			{
				if(rightparts[i].matches("[a-z]+"))
					break;
				check=check.substring(0,check.length()-1);
				if(check.length()==0)
					return "";
				System.out.println(check);
			}
		}
		return check;
	}
}