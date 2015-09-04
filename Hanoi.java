import java.util.Scanner;

public class Hanoi {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		System.out.println();
		getResult(n,'A','B','C');
		
	}

	private static void getResult(int n, char a, char b, char c) {
		if(n==1)
			System.out.println("Move the NO."+n+" plate from "+a+" to "+c);
		else{
			getResult(n-1, a, c, b);
			System.out.println("Move the NO."+n+" plate from "+a+" to "+c);
			getResult(n-1, b, a, c);
		}
	}
}
