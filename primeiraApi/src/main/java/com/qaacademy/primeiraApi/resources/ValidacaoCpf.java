package com.qaacademy.primeiraApi.resources;

import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exercicios")
public class ValidacaoCpf {

	@GetMapping("/validarCpf")
	public String validarCpf(@RequestParam String cpf) {
		
		int priveiroDigitoVerificadorDigitado = Integer.parseInt(cpf.substring(9, 10)); 
		int segundoDigitoVerificadorDigitado = Integer.parseInt(cpf.substring(10, 11));
		int primeiroDigitoVerificadorCalculado = validarPrimeiroDigito(cpf);
		int segundoDigitoVerificadorCalculado = validarSegundoDigito(cpf, primeiroDigitoVerificadorCalculado);


		if (primeiroDigitoVerificadorCalculado == priveiroDigitoVerificadorDigitado
				&& segundoDigitoVerificadorCalculado == segundoDigitoVerificadorDigitado) {
			return "CPF Valido";
		} else {
			return "CPF Invalido";
		}

	}

	private int validarSegundoDigito(String cpf, int primeiroDigitoVerificador) {
		int segundoDigitoVerificador = 0;
		int somaCalculo = 0;		
		int vetorMultiplicadorSegundoDigito[] = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
		
		for (int i = 0; i < 9; i++) {

			somaCalculo = somaCalculo
					+ (vetorMultiplicadorSegundoDigito[i] * Integer.parseInt(cpf.substring(i, i + 1)));

		}
		somaCalculo = somaCalculo + (vetorMultiplicadorSegundoDigito[9] * primeiroDigitoVerificador);

		somaCalculo = somaCalculo % 11; // Resto da divisão

		if (somaCalculo < 2) {
			segundoDigitoVerificador = 0;

		} else if (somaCalculo >= 2) {
			segundoDigitoVerificador = 11 - somaCalculo;

		}
		return segundoDigitoVerificador;
	}

	private int validarPrimeiroDigito(String cpf) {
		int primeiroDigitoVerificadorCalculado = 0;
		int somaCalculo = 0;
		int vetorMultiplicadorPrimeiroDigito[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
		
		for (int i = 0; i < 9; i++) {

			somaCalculo = somaCalculo
					+ (vetorMultiplicadorPrimeiroDigito[i] * Integer.parseInt(cpf.substring(i, i + 1)));

		}

		somaCalculo = somaCalculo % 11; // Resto da divisão

		if (somaCalculo < 2) {
			primeiroDigitoVerificadorCalculado = 0;

		} else if (somaCalculo >= 2) {
			primeiroDigitoVerificadorCalculado = 11 - somaCalculo;

		}

		return primeiroDigitoVerificadorCalculado;
	}

}
