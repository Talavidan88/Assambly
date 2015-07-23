package il.ac.shenkar.assambly;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
	//global reader
	static Scanner input = new Scanner(System.in);
	
	//Fill Array from user
	public static ArrayList<Integer> fillArray(){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		while (true){
			int grade=0;
			System.out.println("Please Enter A Grade, Enter -1 To Finish:");
			try{
				grade = input.nextInt();
				if (grade >=0 && grade <=100){
					temp.add(grade);
				}
				else if (grade == -1){
					return temp;
				}
				else{
					System.out.println("Wrong Input!");
				}
			} catch (InputMismatchException e){
				input.nextLine();
			}
		}

	}
	
	//Fill frequencies array
	public static int[] getFrequencies(ArrayList<Integer> arr){
		int[] temp = new int[10];
		for(Integer i: arr){
			if (i >=0 && i<=9){
				temp[0]++;
			}
			if (i >=10 && i<=19){
				temp[1]++;
			}
			if (i >=20 && i<=29){
				temp[2]++;
			}
			if (i >=30 && i<=39){
				temp[3]++;
			}
			if (i >=40 && i<=49){
				temp[4]++;
			}
			if (i >=50 && i<=59){
				temp[5]++;
			}
			if (i >=60 && i<=69){
				temp[6]++;
			}
			if (i >=70 && i<=79){
				temp[7]++;
			}
			if (i >=80 && i<=89){
				temp[8]++;
			}
			if (i >=90 && i<=100){
				temp[9]++;
			}	
		}
		return temp;
	}
	//
	public static double getAvarage(ArrayList<Integer> arr){
		double avg =0;
		for (Integer i:arr){
			avg += i;
		}
		return avg/arr.size();
	}
	public static int getMax(ArrayList<Integer> arr){
		int max=0;
		for (Integer i:arr){
			if (i > max){
				max = i;
			}
		}
		return max;
	}
	public static int getMin(ArrayList<Integer> arr){
		int min=100;
		for (Integer i:arr){
			if (i < min){
				min = i;
			}
		}
		return min;
	}
	
	
	public static void main(String[] args) {
		
		//array for holding grades
		ArrayList<Integer> gradesArray = new ArrayList<Integer>();
		//frequencies array
		int[] frequencies = new int[10];
		//used for getting user's choice.
		int checkMe =0;
		//starting program
		while (true){
			System.out.println("Please Enter 1 For Printing Random Array, 2 For Filling Out The Array, -1 To Exit:");
			try{
				checkMe = input.nextInt();
			} catch (InputMismatchException e){
				//catching wrong input and flushing the buffer
				input.nextLine();
			}
			switch (checkMe) {
			case 1:
				for (int i=0;i<20;i++){
					gradesArray.add((int) (Math.random() * 100));
				}
				System.out.println("The Avarage Of The Array Is: "+getAvarage(gradesArray) + " The Maximum Is: " + getMax(gradesArray)+ " The Minimum Is: "+getMin(gradesArray));
				frequencies = getFrequencies(gradesArray);
				break;
			case 2:
				gradesArray = fillArray();
				System.out.println("The Avarage Of The Array Is: "+getAvarage(gradesArray) + " The Maximum Is: " + getMax(gradesArray)+ " The Minimum Is: "+getMin(gradesArray));
				frequencies = getFrequencies(gradesArray);
				break;
			case -1:
				input.close();
				System.out.println("GoodBye!");
				return;
			default:
				System.out.println("Wrong Input!");
				break;
			}
		}
		

	
	}

}
