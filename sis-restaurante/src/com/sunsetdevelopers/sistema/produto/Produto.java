package com.sunsetdevelopers.sistema.produto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeProduto;
	private UnidadeMedida unidadeMedida;
	private Float precoUnit;
	private int quantidadeEstoque;
	private Categoria categoria;
	
	public Produto(){}
	
	public Produto(String nomeProduto, UnidadeMedida unidadeMedida, Float precoUnit, int quantidadeEstoque,
			Categoria categoria) {
		this.nomeProduto = nomeProduto;
		this.unidadeMedida = unidadeMedida;
		this.precoUnit = precoUnit;
		this.quantidadeEstoque = quantidadeEstoque;
		this.categoria = categoria;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 100)
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "unidade_medida", nullable = false, length = 10)
	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	@Column(name = "preco_unit", nullable = false, precision = 10, scale = 2)
	public Float getPrecoUnit() {
		return precoUnit;
	}

	public void setPrecoUnit(Float precoUnit) {
		this.precoUnit = precoUnit;
	}

	@Column(name = "quantidade_estoque", nullable = false, length = 3)
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 12)
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
