import java.util.*;
class KilometerToMiles{
	public static void main(String argts[]){
		Scanner sc=new Scanner(System.in);
		System.out.printf("Enter distance(Km)=");
		double k=sc.nextDouble();
		double m=k*0.621371;
		System.out.println("In Miles="+m);
	
	}
}