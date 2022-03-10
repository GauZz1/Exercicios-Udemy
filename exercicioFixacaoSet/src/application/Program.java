package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Set <Integer> set = new HashSet<Integer>();
		String courses[] = {"A", "B", "C"};
		
		for(int i=0;i<3;i++) {
			System.out.print("How many students for course " + courses[i] + "?");
			Integer quantStudents = sc.nextInt();
			for(int x=0; x<quantStudents;x++) {
				Integer numberStudent = sc.nextInt();
				set.add(numberStudent);
			}
		}
		
		System.out.println("Total Students: " + set.size());
		
		
		sc.close();
	}

}
