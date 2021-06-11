package db;

public class Main{
	public static void main(String[] args) {
		 int output = 10;
		 boolean b1 = false;
		 if((b1 == true) && ((output += 10) == 20))
		 {
		     System.out.println("Nous sommes égaux " + output);
		 }
		 else
		 {
		     System.out.println("Pas égaux! " + output);
		 }
	}
}