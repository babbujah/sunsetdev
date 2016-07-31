package com.sunsetdevelopers.sistema.entidade;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "telefoneBean")
@RequestScoped
public class TelefoneBean {

	private Telefone telefoneSelecionado = new Telefone();

	public void salvarTelefone() {
		TelefoneRN telefoneRN = new TelefoneRN();
		telefoneRN.salvar(telefoneSelecionado);
	}

	public Telefone getTelefoneSelecionado() {
		return telefoneSelecionado;
	}

	public void setTelefoneSelecionado(Telefone telefoneSelecionado) {
		this.telefoneSelecionado = telefoneSelecionado;
	}

}
