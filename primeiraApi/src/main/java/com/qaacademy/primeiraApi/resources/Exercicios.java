package com.qaacademy.primeiraApi.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exercicios")
public class Exercicios {

	@GetMapping("/parOuImpar")
	public String parOuImpar(@RequestParam int numero) {
		if (numero % 2 == 0) {
			return "O numero " + (numero) + " é par";
		} // fim se
		else {
			return "O numero " + numero + " é impar";
		} // Fim senão

	}

	@GetMapping("/calculaSalario/{salarioDigitado}")
	public String calculaSalario(@PathVariable(value = "salarioDigitado") double salario) {

		double imposto = calculaImpostoDeRenda(salario);
		double inss = calculaInss(salario);
		double salarioLiquido = (salario - imposto - inss); 
		String mensagem = "Salario bruto = " + salario + "\nSalario liquido = " + salarioLiquido 
				+ "\nINSS =  " + inss
				+ "\nImposto de Renda = " + imposto;

		return mensagem;
	}

	private double calculaInss(double salario) {
		double inss;
		if (salario <= 1045.00) {// abertura if
			inss = salario * 0.075; // 7,5%
		}

		if (salario >= 1045.01 && salario <= 2089.60) {
			inss = salario * 0.09; // 9%
		}
		if (salario >= 2089.61 && salario <= 3134.40) {
			inss = salario * 0.12; // 12%

		}
		if (salario >= 3134.41 && salario < 6101.06) {
			inss = salario * 0.14; // 14%
		} else {
			inss = 6101.06 * 0.14; // 14%;
		}
		return inss;
	}

	private double calculaImpostoDeRenda(double salario) {
		if (salario <= 1903.98) {
			return 0.0;
		}
		if (salario >= 1903.99 && salario <= 2826.65) {
			return (salario * 0.075) - 142.80;
		}
		if (salario >= 2826.66 && salario <= 3751.05) {
			return (salario * 0.15) - 354.80;
		}
		if (salario >= 3751.06 && salario <= 4664.68) {
			return (salario * 0.225) - 636.13;
		} else {
			return (salario * 0.275) - 869.36;
		}
	}

}
