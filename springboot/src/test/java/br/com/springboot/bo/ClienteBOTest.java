package br.com.springboot.bo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.springboot.model.Cliente;
import br.com.springboot.model.Sexo;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class ClienteBOTest {
	
	@Autowired 
	private ClienteBO bo;
	
	@Test
	@Order(1)
	public void insere() {
		Cliente cliente = new Cliente();
		cliente.setNome("Jose da Silva");
		cliente.setCpf("12345678912");
		cliente.setDateDeNascimento(LocalDate.of(2000, 1, 8));
		cliente.setSexo(Sexo.MASCULINO);
		cliente.setTelefone("123456789");
		cliente.setTelefone("1234567890");
		cliente.setAtivo(true);
		cliente.setEmail("teste@gmail.com");
		bo.insere(cliente);
		
				
		
	}
	@Test
	@Order(2)
	public void pesquisaPeloId() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		System.out.println(cliente);
		
	}
	
	@Test
	@Order(3)
	public void atualiza() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		bo.atualiza(cliente);
	}

}
