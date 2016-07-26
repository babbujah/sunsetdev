package com.sunsetdevelopers.sistema.util;

import com.sunsetdevelopers.sistema.entidade.cliente.ClienteDAO;
import com.sunsetdevelopers.sistema.entidade.cliente.ClienteDAOHibernate;

public class DAOFactory {

	public static ClienteDAO criaClienteDAO() {
		ClienteDAOHibernate clienteDAOHibernate = new ClienteDAOHibernate();
		
		clienteDAOHibernate.setSessao(HibernateUtil.getSession()
				.getCurrentSession());

		return clienteDAOHibernate;
	}

	
}
