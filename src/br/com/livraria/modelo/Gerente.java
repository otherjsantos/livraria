package br.com.livraria.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Gerente {

	@Column(name = "NOME_GERENTE", nullable = false)
	private String name;
	
	@Column(name = "TELEFONE_GERENTE", nullable = false)
	private String telefone;
}
