import java.util.*;
class Average{
	public static void main(String argts[]){
		Scanner sc=new Scanner(System.in);
		System.out.printf("Enter 1st=");
		double x=sc.nextDouble();
		System.out.printf("Enter 2nd=");
		double y=sc.nextDouble();
		System.out.printf("Enter 3rd=");
		double z=sc.nextDouble();
		double avg=(x+y+z)/3;
		System.out.println("Average="+avg);
	}
}