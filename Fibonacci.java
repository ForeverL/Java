import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		
		int m=getResult(n);
		System.out.println(m);
	}

	private static int getResult(int n) {
		if(n==1||n==2)
			return 1;
		else
			return getResult(n-1)+getResult(n-2);
	}
}
