package com.sunsetdevelopers.sistema.entidade;

import org.hibernate.Session;

public class EnderecoDAOHibernate implements EnderecoDAO {

	private Session sessao;

	@Override
	public void salvarEndereco(Endereco endereco) {
		this.sessao.save(endereco);

	}

	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

}
