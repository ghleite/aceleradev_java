package br.com.codenation.calculadora;


import javax.xml.ws.FaultAction;

public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-

		double taxedSalary = 0.0;
		salarioBase = calcularInss(salarioBase);

		if(salarioBase < 1039.00) {
			return (int) 0.0;
		}

		if(salarioBase <= 3000.00) {
			taxedSalary = salarioBase;
		}
		else if(salarioBase >= 3000.01 && salarioBase <= 6000.00) {
			taxedSalary = salarioBase * 0.925;
		}
		else if(salarioBase > 6000.00) {
			taxedSalary = salarioBase * 0.85;
		}

		return (int) (Math.round(taxedSalary));
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {

		double discountedSalary = 0.0;

		if(salarioBase <= 1500.00){
			discountedSalary = salarioBase * 0.92;
		}

		else if(salarioBase >= 1500.01 && salarioBase <= 4000.00){
			discountedSalary = salarioBase * 0.91;
		}

		else if(salarioBase > 4000.00) {
			discountedSalary = salarioBase * 0.89;
		}

		return discountedSalary;
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/