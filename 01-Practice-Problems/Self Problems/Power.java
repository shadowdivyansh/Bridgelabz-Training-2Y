import java.util.*;
class Power{
	public static void main(String argts[]){
		Scanner sc=new Scanner(System.in);
		System.out.printf("Enter base=");
		double a=sc.nextDouble();
		System.out.printf("Enter exponent=");
		int x=sc.nextInt();
		double i=Math.pow(a,x);
		System.out.println("Result="+i);
	}
}