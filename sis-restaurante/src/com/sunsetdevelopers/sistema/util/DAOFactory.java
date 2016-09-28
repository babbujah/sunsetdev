package com.sunsetdevelopers.sistema.util;

import org.hibernate.Session;

import com.sunsetdevelopers.sistema.entidade.EnderecoDAO;
import com.sunsetdevelopers.sistema.entidade.EnderecoDAOHibernate;
import com.sunsetdevelopers.sistema.entidade.TelefoneDAO;
import com.sunsetdevelopers.sistema.entidade.TelefoneDAOHibernate;
import com.sunsetdevelopers.sistema.entidade.cliente.ClienteDAO;
import com.sunsetdevelopers.sistema.entidade.cliente.ClienteDAOHibernate;

public class DAOFactory {

	private static Session sessao = HibernateUtil.getSession()
			.getCurrentSession();
	
	public static ClienteDAO criaClienteDAO() {
		ClienteDAOHibernate clienteDAOHibernate = new ClienteDAOHibernate();
		
		clienteDAOHibernate.setSessao(HibernateUtil.getSession().getCurrentSession());

		return clienteDAOHibernate;
	}

	public static EnderecoDAO criaEnderecoDAO() {
		EnderecoDAOHibernate enderecoDAOHibernate = new EnderecoDAOHibernate();
		
		enderecoDAOHibernate.setSessao(HibernateUtil.getSession().getCurrentSession());
		
		return enderecoDAOHibernate;
	}
	
	public static TelefoneDAO criaTelefoneDAO() {
		TelefoneDAOHibernate telefoneDAOHibernate = new TelefoneDAOHibernate();
		
		telefoneDAOHibernate.setSessao(HibernateUtil.getSession().getCurrentSession());
		
		return telefoneDAOHibernate;
	}

	
}
