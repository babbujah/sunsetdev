package com.sunsetdevelopers.sistema.entidade.cliente;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.sunsetdevelopers.sistema.entidade.Entidade;

@Entity
@Table(name = "cliente")
public class Cliente extends Entidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CategoriaCliente categoriaCliente;
	private Sexo sexo;
	private Situacao situacao;
	
	public Cliente() {
		categoriaCliente = CategoriaCliente.COMUM;
		situacao = Situacao.ATIVO;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "categoria_cliente", nullable = false, length = 6)
	public CategoriaCliente getCategoriaCliente() {
		return categoriaCliente;
	}

	public void setCategoriaCliente(CategoriaCliente categoriaCliente) {
		this.categoriaCliente = categoriaCliente;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 8)
	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

}
