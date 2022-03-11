package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.next();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path));) {
			
			List<Employee> employees = new ArrayList<>();
			
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				
				line = br.readLine();
			}
			
			System.out.print("Enter Salary: ");
			double salaryCompare = sc.nextDouble();
			
			List<String> emails = employees.stream().
					filter(p -> p.getSalary() >= salaryCompare)
					.map(p -> p.getEmail()).sorted()
					.collect(Collectors.toList());
			
			System.out.println("Email of people whose salary is more than " + String.format("%.2f", salaryCompare));
			
			emails.forEach(System.out::println);
			
			double sum = employees.stream()
					.filter(p -> p.getName().charAt(0) == 'M')
					.map(p -> p.getSalary()).reduce(0.0, (x, y) -> x+y);
			
			System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));
			
			
		}
		catch(IOException e) {
			System.out.println("Error" + e.getMessage());
		}
		
		sc.close();
	}
}
