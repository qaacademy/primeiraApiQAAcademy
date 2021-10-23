package com.qaacademy.primeiraApi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.qaacademy.primeiraApi.resources.ValidacaoCpf;

@SpringBootTest
class PrimeiraApiApplicationTests {

	@Test
	void contextLoads() {
		
		ValidacaoCpf validaCpf = new ValidacaoCpf(); 
		validaCpf.validarCpf("35651721851");
		
	}

}
