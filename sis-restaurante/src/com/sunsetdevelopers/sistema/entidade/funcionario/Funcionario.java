package com.sunsetdevelopers.sistema.entidade.funcionario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sunsetdevelopers.sistema.entidade.Entidade;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Entidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nomeUsuario;
	private String senhaUsuario;
	private Funcao funcao;

	@Column(name = "nome_usuario", nullable = false, length = 50)
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	@Column(name = "senha_usuario", nullable = false, length = 20)
	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	@ManyToOne
	@JoinColumn(name = "funcao_id", nullable = false)
	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

}
