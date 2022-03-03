import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		String res = "";
		int temp = 0;
		
		
		if(input == 11 || input == 12 || input == 13) {
			temp = input;
		}
		else if(input >= 10) {
			temp = input - (input /10) * 10;
		
		}else {
			temp = input;
		}

		if(temp == 1) {
			res = input + "st";
		}else if(temp == 2) {
			res = input + "nd";
		}else if(temp == 3) {
			res = input + "rd";
		}else {
			res = input + "th";
		}
		
		System.out.println(res);
		
	}

}
