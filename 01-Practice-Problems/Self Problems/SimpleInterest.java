import java.util.Scanner;
class SimpleInterest{
	public static void main(String argts[]){
		Scanner sc=new Scanner(System.in);
		System.out.printf("Enter Principal=");
		double p=sc.nextDouble();
		System.out.printf("Enter Rate=");
		double r=sc.nextDouble();
		System.out.printf("Enter Time");
		double t=sc.nextDouble();
		double s=(p*r*t)/100;
		System.out.println("Simple Interest=" +s);
	}
}