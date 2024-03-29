package br.com.improving.carrinho;

import java.util.Objects;

/**
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
public class Produto {

    private Long codigo;
    private String descricao;

    /**
     * Construtor da classe Produto.
     *
     * @param codigo
     * @param descricao
     */
    public Produto(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
    }

    /**
     * Retorna o código da produto.
     *
     * @return Long
     */
    public Long getCodigo() {
		return this.codigo;
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return String
     */
    public String getDescricao() {
		return this.descricao;
    }

	/**
	 * Retorna se um outro objeto e igual a este produto quando possuem mesmo codigo
	 *
	 * @param outroObjeto
	 * @return boolean
	 */
	@Override
	public boolean equals(Object outroObjeto) {
		if (this == outroObjeto) {
			return true;
		}
		if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
			return false;
		}
		final Produto outroProduto = (Produto) outroObjeto;
		return this.codigo.equals(outroProduto.getCodigo());
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
}