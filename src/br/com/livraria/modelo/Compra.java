package br.com.livraria.modelo;

import java.util.Calendar;

import javax.persistence.Entity;

@Entity
public class Compra {

	private Integer id;
	private Cliente cliente;
	private Livro livro;
	Calendar data;
	
}
