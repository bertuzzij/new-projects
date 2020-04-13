package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class WorkValue {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = scan.nextLine();
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = scan.nextLine();
		
		System.out.print("Level: ");
		String workerLevel = scan.nextLine();
		
		System.out.print("Name: ");
		double baseSalary = scan.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.print("How many contracts to this worker? ");
		int n = scan.nextInt();
		
		for (int i =0; i < n; i++) {
			scan.nextLine();
			System.out.println("Enter contract #"+ i +" data:");
			System.out.print("Date: DD/MM/YYYY: ");
			Date contractDate = sdf.parse(scan.next());
			System.out.print("Value per hour: ");
			double valuePerHour = scan.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = scan.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);//instancia os contratos
			worker.addContract(contract); //associa o contrato "HourContract contrat" ao contrado do "Worker" 
		}
		System.out.println();
		
		System.out.print("Enter month and year to calculate income(MM/YYYY): ");
		String monthAndYear = scan.next();
		
		int month = Integer.parseInt(monthAndYear.substring(0, 2)); //recortando o mês da data recebida
		int year = Integer.parseInt(monthAndYear.substring(3)); //recortando o ano da data recebida
		
		System.out.println("Name: "+ worker.getName());
		System.out.println("Department: "+ worker.getDepartment().getName());
		System.out.println("Income for "+ monthAndYear + ": "+ String.format("%.2f", worker.income(year, month)));
		
		scan.close();
	}

}
