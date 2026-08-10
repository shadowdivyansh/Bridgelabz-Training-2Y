import java.util.Scanner;
class VolumeOfCylinder{
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	System.out.printf("Enter radius=");
	double c=sc.nextInt();
	System.out.printf("Enter height=");
	double h=sc.nextInt();
	double f=3.14 * (c*c) * h;
	System.out.println(f);
	}
	}