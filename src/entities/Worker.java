package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name; // variável para recebe o nome do trabalhador
	private WorkerLevel level; // variável que vai receber um dos níveis da classe workLevel
	private Double baseSalary; // variável que vai receber o salario do funciário
	private Department departament; // variável que vai receber o nome do departamento de acordo com a classe department
	private List<HourContract> contracts = new ArrayList<>(); /*array que vai receber a lista de contratos digitados no programa principal
	com o arrayList já estanciado na declaração do array */ 
	
	public Worker() {//construtor vazio 	
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department departament) {//construtor com os argumentos 
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
		//este construtor não pode receber a lista como argumentom, pois ela já está instanciada na própria declaração da lista.
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

	public Department getDepartament() {
		return departament;
	}

	public void setDepartament(Department departament) {
		this.departament = departament;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	/*o método setContracts não pode existir para que a única forma de adicionar ou remover ítens na lista seja
	  pelos métodos add ou remove abaixo*/

	public void addContract(HourContract contract) {//método para adicionar contratos usando a classe HourContracts 
		contracts.add(contract);//faz a associação com a classe HourContarcts
	}
	public void removeContract(HourContract contract) {//método para remover contrato usando a classe HourContracts
		contracts.remove(contract);//desfaz a associação com a classe HourContarcts
	}
	public double income(int year, int month) {//função para calcular as horas trabalhandas em determinado mês e ano
		double sum = baseSalary; //variável (sum) recebe o salário do trabalhador 
		Calendar cal = Calendar.getInstance();
		for(HourContract c : contracts) {/*para cada contrato que eu chamei de (c), dentro da lista de contratos
		será testado se o contrato é do ano e mês digitado, case seja, o salário será somado as horas do contrato acumulado*/
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);//variável que representa o ano do contrato existente
			int c_month = 1 + cal.get(Calendar.MONTH);//variável que representa o mês do contrato existente
			if (year == c_year && month == c_month) {/*condição que testa se o contrato é do mês e ano digitados
			 										são iguais as dos contratos existentes(year and month)*/
				sum += c.totalValue();/*resultado da soma do salario digitado que está na variável sum com 
				o resultado da função (totalValue) da classe hourContracts*/
			} 
		}
		return sum;//retorno da função (income)
	}
	

}
