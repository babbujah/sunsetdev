package com.sunsetdevelopers.sistema.entidade.funcionario;

import java.io.Serializable;

import com.sunsetdevelopers.sistema.entidade.Entidade;

public class Funcionario extends Entidade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomeUsuario;
	private String senhaUsuario;
	private Funcao funcao;
}
