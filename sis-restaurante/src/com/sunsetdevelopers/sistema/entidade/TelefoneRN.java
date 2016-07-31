package com.sunsetdevelopers.sistema.entidade;

import com.sunsetdevelopers.sistema.util.DAOFactory;

public class TelefoneRN {

	private TelefoneDAO telefoneDAO;

	public TelefoneRN() {
		this.telefoneDAO = DAOFactory.criaTelefoneDAO();
	}

	public void salvar(Telefone tel1) {
		telefoneDAO.salvarTelefone(tel1);
	}
}
