package com.sunsetdevelopers.sistema.entidade.cliente;

import java.io.Serializable;

import com.sunsetdevelopers.sistema.entidade.Entidade;

public class Cliente extends Entidade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CategoriaCliente categoriaCliente;
	private Sexo sexo;
	private Situacao situacao;

}
