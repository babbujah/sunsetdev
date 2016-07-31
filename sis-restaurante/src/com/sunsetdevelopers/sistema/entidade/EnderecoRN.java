package com.sunsetdevelopers.sistema.entidade;

import com.sunsetdevelopers.sistema.util.DAOFactory;

public class EnderecoRN {

	private EnderecoDAO enderecoDAO;

	public EnderecoRN() {
		this.enderecoDAO = DAOFactory.criaEnderecoDAO();
	}

	public void salvarEndereco(Endereco end1) {
		this.enderecoDAO.salvarEndereco(end1);
	}

}
