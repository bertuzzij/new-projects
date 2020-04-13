package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	//composi��o de objetos
	private Department department; //associa��o com a classe "Department"
	private List<HourContract> contracts = new ArrayList<>(); //associa��o com a classe "HourContract", por ter * ent�o � criado a partir  de uma lista a associa��o
	
	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	//m�todos
	
	public void addContract(HourContract contract) {
		contracts.add(contract);//ir� adicionar na lista o contrato que for recebido no argumento de HourContract
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);//ir� remover da lista o contrato que for recebido no argumento de HourContract
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		
		for (HourContract c : contracts) {
			cal.setTime(c.getDate()); //atribui as datas recebida na lista de contratos 'c' ao m�todo do calend�rio para ser utilizado porteriormente
			
			int c_year = cal.get(Calendar.YEAR);//atribui o ano recebido no m�todo 'cal' para poder ser comparado
			int c_month = cal.get(Calendar.MONTH);//atribui o m�s recebido no m�todo 'cal' para poder ser comparado
			
			if (year == c_year && month == c_month) {//faz a compara��o do ano e o m�s recebidos como argumento com os que s�o da lista de contratos
				sum = sum + c.totalValue();//recebe os valores que entrem na condi��o 'if'
			}
		}
		return sum;
	}
	
}
