package application;

import java.util.Scanner;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class AumentoSalario {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int quantFunc = sc.nextInt();
		
		List<Employee> listFunc = new ArrayList<>();
		
		for(int i=0; i < quantFunc; i++) {
			System.out.println("Employee #" + (i+1) + ":");
			System.out.print("Id: ");
			int ID = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String nome = sc.nextLine();
			System.out.print("Salary: ");
			double salario = sc.nextDouble();
			
			Employee func = new Employee(ID, nome, salario);
			
			listFunc.add(func);
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		int idPesquisa = sc.nextInt();
		
		Employee emp = listFunc.stream().filter(x -> x.getId() == idPesquisa).findFirst().orElse(null);
			if(emp == null) {
				System.out.println("This id does not exist!");
			}
			else {
				System.out.print("Enter the percentage: ");
				double porcentage = sc.nextDouble();
				emp.increaseSalary(porcentage);
			}
		
		System.out.println("List of employees:");
		for(Employee x : listFunc) {
			x.printEmployee();
		}
		
		
		sc.close();
	}

}
