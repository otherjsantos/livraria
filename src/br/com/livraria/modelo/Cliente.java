package br.com.livraria.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	String Nome;
	String CadastroPessoa;
	Endereco endereco;
	Contato contato;
	List<Compra> compras;
	
	

}
