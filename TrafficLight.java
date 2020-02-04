import java.util.*;
class TrafficLight{
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the colour of the traffic light 1-red,2-yellow,3-green");
		int choice=s.nextInt();
		switch(choice)
		{
			case 1:
			System.out.println("red-The vehicle must STOP");
			break;

			case 2:
			System.out.println("yellow - The vehicle is READY to move");
			break;

			case 3:
			System.out.println("green - The vehicle must GO");
			break;

			default:
			System.out.println("There is no message to display");
			break;

		}
	}
}