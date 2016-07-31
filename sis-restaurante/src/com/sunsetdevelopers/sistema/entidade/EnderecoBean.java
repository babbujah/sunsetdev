package com.sunsetdevelopers.sistema.entidade;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "enderecoBean")
@RequestScoped
public class EnderecoBean {

	private Endereco enderecoSelecionado = new Endereco();

	public void salvarEndereco() {
		EnderecoRN enderecoRN = new EnderecoRN();
		enderecoRN.salvarEndereco(enderecoSelecionado);
	}

	public Endereco getEnderecoSelecionado() {
		return enderecoSelecionado;
	}

	public void setEnderecoSelecionado(Endereco enderecoSelecionado) {
		this.enderecoSelecionado = enderecoSelecionado;
	}

}
