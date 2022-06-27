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

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);// defines in which language we will work
		Scanner sc = new Scanner(System.in); // object responsible for reading the typed entries 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // object responsible for format the dates
		
		System.out.print("Enter department's name: ");
		String departamentName = sc.nextLine();//department name entry
		
		System.out.println("Enter worker data: ");//typed worker data
		
		System.out.print("Name: ");
		String workerName = sc.nextLine();//worker name entry
		
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();//worker level entry
		
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();//worker salary
		
		/*Instanciando o objeto worker com os parâmetros recebendo as variáveis lidas acima.
		Entre os parâmetro, um objeto (Department) que esta relacionado com a classe Worker e 
		recebe o nome do departamento tambem lido acima. */
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departamentName));
		
		System.out.print("How many contracts to this worker? ");//
		int n = sc.nextInt();// receive the number of workers
		
		/* (for) responsável por realizar a quantidade de leitura de acordo com a quantidade de trabalhadores digitados acima */
		for(int i = 0;i < n;i++) {
			System.out.println("Enter contract #"+i+" data: ");
			System.out.print("Date (dd/mm/yyyy) ");
			
			Date contractDate = sdf.parse(sc.next());//receives the date typed according to the specified format
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();//receives the value per hour
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();//receives the duration of the hours
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);//object that receives the parameters typed above
			worker.addContract(contract);//associating the contract with the worker
			/*todas as vezes que for chamado o add.contract será adicionado (ou serão adicionados) 
			 * os contratos a lista de contartos do Worker */
		}
		
		System.out.println();//skip a line
		System.out.println("Enter month and year to calculate income (mm/yyyy)");
		String monthAndYear = sc.next();//deceives the desired year and month for income calculation
		//os comandos abaixo recorta a string acima digitada e separa o mês em uma variável o a barra e ano na outra variável 
		int month = Integer.parseInt(monthAndYear.substring(0,2));//recebe o mês recortado
		int year = Integer.parseInt(monthAndYear.substring(3));//recebe a barra e o ano recortado
		//imprime o resultado que é: o nome do trabalhador, o nome do departamento, o valor de acordo com a função income na classe worker
		System.out.println("Name: "+ worker.getName()+"\n"+
							"Department: " + worker.getDepartament().getName()+"\n"+
							"Income for "+monthAndYear+": " + String.format("%.2f", worker.income(year, month)));
		
		
		sc.close();
	}

}
