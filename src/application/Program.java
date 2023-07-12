package application;

import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Nome do departamento: ");
		String nome = sc.next();
		
		System.out.println("Dia do pagamento: ");
		int dia = sc.nextInt();
		
		System.out.println("Email: ");
		String email = sc.next();
		
		System.out.println("Telefone: ");
		String telefone = sc.next();
		
		Address address = new Address(email, telefone);

		Department department = new Department(nome, dia, address);
		
		System.out.print("Quantos funcionários tem o departamento?");
		int fun = sc.nextInt();
		
		for(int i=1;  i<=fun; i++) {
			System.out.println("Dados do funcionário " + i);
			System.out.println("Nome:");
			String nomefun = sc.next();
			System.out.println("Salário:");
			Double sala = sc.nextDouble();
			
			Employee employee = new Employee(nomefun, sala);
			department.addEmployee(employee);
		}
		
		System.out.println();
		showReport(department);
		
		sc.close();
	}
	
	private static void showReport(Department department) {
		System.out.println("FOLHA DE PAGAMENTO");
		System.out.println("Departamento " + department.getName() + " = R$ " + department.payroll());
		System.out.println("Pagamento realizado no dia " + department.getPayDay());
		System.out.println("Funcionários:");
		
		for(Employee employee : department.getEmployees()) 
			System.out.println(employee.getName());
		
		System.out.println("Para dúvidas favor entrar em contato: " + department.getAddress().getEmail());
		
	}

}
