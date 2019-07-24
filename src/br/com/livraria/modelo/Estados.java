package br.com.livraria.modelo;

public enum Estados {

	AC("Acre", "AC"),
	AL("Alagoas", "AL"),
	AP("Amap�", "AP"),
	AM("Amazonas", "AM"),
	BA("Bahia", "BA"),
	CE("Cear�", "CE"),
	DF("Distrito Federal", "DF"),
	ES("Esp�rito Santo", "ES"),
	GO("Goi�s", "GO"),
	MA("Maranh�o", "MA"),
	MT("Mato Grosso", "MT"),
	MS("Mato Grosso do Sul", "MS"),
	MG("Minas Gerais", "MG"),
	PA("Par�", "PA"),
	PB("Para�ba", "PB"),
	PR("Paran�", "PR"),
	PE("Pernambuco", "PE"),
	PI("Piau�", "PI"),
	RJ("Rio de Janeiro", "RJ"),
	RN("Rio Grande do Norte", "RN"),
	RS("Rio Grande do Sul", "RS"),
	RO("Rond�nia", "RO"),
	RR("Roraima", "RR"),
	SC("Santa Catarina", "SC"),
	SP("S�o Paulo", "SP"),
	SE("Sergipe", "SE"),
	TO("Tocantins", "TO");

	private String nome;
	private String sigla;

	private Estados(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}
}
