import java.util.Scanner;
class PerimeterRectangle{
	public static void main(String argts[]){
		Scanner sc=new Scanner(System.in);
		System.out.printf("Enter length=");
		double l=sc.nextDouble();
		System.out.printf("Enter width");
		double w=sc.nextDouble();
		double p=2*(l+w);
		System.out.println("Perimeter="+p);
		
	}
}