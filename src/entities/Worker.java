package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	//composição de objetos
	private Department department; //associação com a classe "Department"
	private List<HourContract> contracts = new ArrayList<>(); //associação com a classe "HourContract", por ter * então é criado a partir  de uma lista a associação
	
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
	
	//métodos
	
	public void addContract(HourContract contract) {
		contracts.add(contract);//irá adicionar na lista o contrato que for recebido no argumento de HourContract
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);//irá remover da lista o contrato que for recebido no argumento de HourContract
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		
		for (HourContract c : contracts) {
			cal.setTime(c.getDate()); //atribui as datas recebida na lista de contratos 'c' ao método do calendário para ser utilizado porteriormente
			
			int c_year = cal.get(Calendar.YEAR);//atribui o ano recebido no método 'cal' para poder ser comparado
			int c_month = cal.get(Calendar.MONTH);//atribui o mês recebido no método 'cal' para poder ser comparado
			
			if (year == c_year && month == c_month) {//faz a comparação do ano e o mês recebidos como argumento com os que são da lista de contratos
				sum = sum + c.totalValue();//recebe os valores que entrem na condição 'if'
			}
		}
		return sum;
	}
	
}
