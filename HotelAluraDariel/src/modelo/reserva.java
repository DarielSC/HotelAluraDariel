package modelo;

import java.time.LocalDate;

public class reserva {
	
	private Integer id;
	private LocalDate dataE;
	private LocalDate dataS;
	private String valor;
	private String formadePago;

	public reserva(LocalDate dataE, LocalDate dataS, String valor, String formadePago) {
		super();
		this.dataE = dataE;
		this.dataS = dataS;
		this.valor = valor;
		this.formadePago = formadePago;
	}
	
	public reserva(Integer id, LocalDate dataE, LocalDate dataS, String valor, String formadePago) {
		super();
		this.id = id;
		this.dataE = dataE;
		this.dataS = dataS;
		this.valor = valor;
		this.formadePago = formadePago; 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataE() {
		return dataE;
	}

	public void setDataE(LocalDate dataE) {
		this.dataE = dataE;
	}

	public LocalDate getDataS() {
		return dataS;
	}

	public void setDataS(LocalDate dataS) {
		this.dataS = dataS;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFormadePago() {
		return formadePago;
	}

	public void setFormadePago(String formadePago) {
		this.formadePago = formadePago;
	}
	
	
}
