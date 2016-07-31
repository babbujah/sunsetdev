package com.sunsetdevelopers.sistema.entidade;

import org.hibernate.Session;

public class TelefoneDAOHibernate implements TelefoneDAO {

	private Session sessao;

	@Override
	public void salvarTelefone(Telefone telefone) {
		this.sessao.save(telefone);

	}

	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

}
