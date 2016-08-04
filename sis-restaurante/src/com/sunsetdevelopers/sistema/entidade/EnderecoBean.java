package com.sunsetdevelopers.sistema.entidade;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "enderecoBean")
@RequestScoped
public class EnderecoBean {

	private Endereco enderecoSelecionado = new Endereco();

	public void salvarEndereco() {
		EnderecoRN enderecoRN = new EnderecoRN();
		enderecoRN.salvarEndereco(enderecoSelecionado);
		FacesMessage faces = new FacesMessage("Endereço Salvo com sucesso!");
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, faces);
	}

	public Endereco getEnderecoSelecionado() {
		return enderecoSelecionado;
	}

	public void setEnderecoSelecionado(Endereco enderecoSelecionado) {
		this.enderecoSelecionado = enderecoSelecionado;
	}

}
