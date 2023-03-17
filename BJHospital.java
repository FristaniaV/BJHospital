package bjhospital;

import java.util.ArrayList;
import java.util.Scanner;

public class BJHospital {

	Scanner scan = new Scanner(System.in);

	ArrayList<String> patientsNameList = new ArrayList<String>();
	ArrayList<String> patientsGenderList = new ArrayList<String>();
	ArrayList<String> patientsRoomType = new ArrayList<String>();
	
	int choose;
	String name;
	String gender;
	String roomType;
	
	public BJHospital() {

		menu();
		
	}
	
	public void menu() {
		
		do {	
			System.out.println("===============");
			System.out.println(": BJ Hospital :");
			System.out.println("===============");
			System.out.println();
			System.out.println("1. Add Patient");
			System.out.println("2. View Patient");
			System.out.println("3. Exit");
			System.out.print("Choose >> ");
			try {
				choose = scan.nextInt();
			} catch (Exception e) {
				choose = -1;
			} 
			scan.nextLine();
		} while (choose < 1 || choose > 3);
		
		if (choose == 1) {
			addPatient();
		} else if (choose == 2) {
			viewPatient();
		} else if (choose == 3) {
			System.out.println("-^ Thanks for using this program... ^-");
			System.exit(0);
		}
		
	}
	
	public void addPatient() {
		
		do {
			System.out.print("Input your name [starts with 'Mr.' or 'Mrs.']: ");
			name = scan.nextLine();
		} while (!name.startsWith("Mr.") && !name.startsWith("Mrs."));
		
		do {
			System.out.print("Input your gender ['Male' or 'Female' [Case Insensitive]]: ");
			gender = scan.nextLine();
		} while (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female"));
		
		do {
			System.out.print("Choose your room type ['VIP' or 'Normal']: ");
			roomType = scan.nextLine();
		} while (!roomType.equals("VIP") && (!roomType.equals("Normal")));
		
		patientsNameList.add(name);
		patientsGenderList.add(gender);
		patientsRoomType.add(roomType);
		
		System.out.println();
		System.out.println("Patient has been added !");
		System.out.println();
		menu();
	}
	
	public void viewPatient() {
		
		if(patientsNameList.isEmpty()) {
			System.out.println("No Patient !");
		} else {
			for (int i = 0; i < patientsNameList.size(); i++) {
				System.out.println((i + 1) + "." + patientsNameList.get(i) + ", " + patientsGenderList.get(i) + ", " + patientsRoomType.get(i));
			}
		}
		menu();
	}
	

	public static void main(String[] args) {
		new BJHospital();

	}

}
