package br.com.livraria.modelo;

import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NOME", length = 32, nullable = false)
	String nome;

	// Testar: Como PK
	@Column(name = "CADASTRO_PESSOA", length = 14, nullable = false)
	String cadastroPessoa;

	/*
	 * Testar:
	 * 
	 * @Table( name="EMP",
	 * uniqueConstraints={@UniqueConstraint(columnNames={"EMP_BDAY", "EMP_NAME"})})
	 */
	@JoinColumn(name = "ENDERECO_ID", unique = true)
	@OneToOne
	Endereco endereco;

	@JoinColumn(name = "CONTATO_ID", unique = true)
	@OneToOne
	Contato contato;

	@OneToMany(mappedBy = "cliente")
	List<Compra> compras;

	/*
	 * Método que substitue o setCompras. Isso foi feito no intuito de manter a
	 * consistência, pois sempre que uma compra for persistida ela precisa pertencer
	 * a um cliente
	 */
	public void adicionaCompra(Compra compra) {
		compra.setCliente(this);
		this.compras.add(compra);
	}

	/*
	 * Com o intuito de manter a concistência será devolvido uma lista imutável dos
	 * objetos. Sendo assim não será possível alterar(add ou remove) nossa lista.
	 */
	public List<Compra> getCompras() {
		List<Compra> listaSegura = Collections.unmodifiableList(this.compras);
		return listaSegura;
	}

	/*
	 * Esse metódo foi comentado para evitar o acesso direto as compras e assim
	 * manter a consistência. Para inserir uma compra será usado o metodo
	 * adicionaCompra()
	 * 
	 * public void setCompras(List<Compra> compras) { this.compras = compras; }
	 */

	@ManyToMany
	List<Livro> livros;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCadastroPessoa() {
		return cadastroPessoa;
	}

	public void setCadastroPessoa(String cadastroPessoa) {
		this.cadastroPessoa = cadastroPessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	// hashCode and equals - cadastroPessoa
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cadastroPessoa == null) ? 0 : cadastroPessoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cadastroPessoa == null) {
			if (other.cadastroPessoa != null)
				return false;
		} else if (!cadastroPessoa.equals(other.cadastroPessoa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cadastroPessoa=" + cadastroPessoa + "]";
	}
}
