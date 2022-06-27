package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name; // vari�vel para recebe o nome do trabalhador
	private WorkerLevel level; // vari�vel que vai receber um dos n�veis da classe workLevel
	private Double baseSalary; // vari�vel que vai receber o salario do funci�rio
	private Department departament; // vari�vel que vai receber o nome do departamento de acordo com a classe department
	private List<HourContract> contracts = new ArrayList<>(); /*array que vai receber a lista de contratos digitados no programa principal
	com o arrayList j� estanciado na declara��o do array */ 
	
	public Worker() {//construtor vazio 	
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department departament) {//construtor com os argumentos 
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
		//este construtor n�o pode receber a lista como argumentom, pois ela j� est� instanciada na pr�pria declara��o da lista.
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
	/*o m�todo setContracts n�o pode existir para que a �nica forma de adicionar ou remover �tens na lista seja
	  pelos m�todos add ou remove abaixo*/

	public void addContract(HourContract contract) {//m�todo para adicionar contratos usando a classe HourContracts 
		contracts.add(contract);//faz a associa��o com a classe HourContarcts
	}
	public void removeContract(HourContract contract) {//m�todo para remover contrato usando a classe HourContracts
		contracts.remove(contract);//desfaz a associa��o com a classe HourContarcts
	}
	public double income(int year, int month) {//fun��o para calcular as horas trabalhandas em determinado m�s e ano
		double sum = baseSalary; //vari�vel (sum) recebe o sal�rio do trabalhador 
		Calendar cal = Calendar.getInstance();
		for(HourContract c : contracts) {/*para cada contrato que eu chamei de (c), dentro da lista de contratos
		ser� testado se o contrato � do ano e m�s digitado, case seja, o sal�rio ser� somado as horas do contrato acumulado*/
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);//vari�vel que representa o ano do contrato existente
			int c_month = 1 + cal.get(Calendar.MONTH);//vari�vel que representa o m�s do contrato existente
			if (year == c_year && month == c_month) {/*condi��o que testa se o contrato � do m�s e ano digitados
			 										s�o iguais as dos contratos existentes(year and month)*/
				sum += c.totalValue();/*resultado da soma do salario digitado que est� na vari�vel sum com 
				o resultado da fun��o (totalValue) da classe hourContracts*/
			} 
		}
		return sum;//retorno da fun��o (income)
	}
	

}
