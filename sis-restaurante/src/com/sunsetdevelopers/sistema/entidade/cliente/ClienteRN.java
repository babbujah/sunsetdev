package com.sunsetdevelopers.sistema.entidade.cliente;

import com.sunsetdevelopers.sistema.util.DAOFactory;

public class ClienteRN {

	private ClienteDAO clienteDAO;

	public ClienteRN() {
		this.clienteDAO = DAOFactory.criaClienteDAO();
	}

	public void salvar(Cliente c1) {
		this.clienteDAO.salvar(c1);
	}

}
