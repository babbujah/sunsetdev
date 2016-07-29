package com.sunsetdevelopers.sistema.entidade.cliente;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean {

	private Cliente clienteSelecionado = new Cliente();

	public void salvar() {
		ClienteRN clienteRN = new ClienteRN();
		clienteRN.salvar(clienteSelecionado);
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

}
