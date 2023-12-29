package br.com.improving.carrinho;

import java.math.BigDecimal;

import org.junit.Assert;

import junit.framework.TestCase;

public class CarrinhoComprasTest extends TestCase {

	public void testAdicionarItem() {
		CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
		Produto produto1 = new Produto(1L, "produto1");
		carrinhoCompras.adicionarItem(produto1, BigDecimal.ONE, 1);
		Assert.assertEquals(1, carrinhoCompras.getItens().size());
	}

	public void testRemoverItem() {
		CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
		Produto produto1 = new Produto(1L, "produto1");
		carrinhoCompras.adicionarItem(produto1, BigDecimal.ONE, 1);
		Assert.assertEquals(1, carrinhoCompras.getItens().size());
		carrinhoCompras.removerItem(produto1);
		Assert.assertEquals(0, carrinhoCompras.getItens().size());
	}

	public void testRemoverItemPos() {
		CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
		Produto produto1 = new Produto(1L, "produto1");
		carrinhoCompras.adicionarItem(produto1, BigDecimal.ONE, 1);
		Assert.assertEquals(1, carrinhoCompras.getItens().size());
		carrinhoCompras.removerItem(0);
		Assert.assertEquals(0, carrinhoCompras.getItens().size());
	}

	public void testGetValorTotal() {
		CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
		Produto produto1 = new Produto(1L, "produto1");
		Produto produto2 = new Produto(2L, "produto2");
		Produto produtoIgualAo1 = new Produto(1L, "produto igual ao 1");
		carrinhoCompras.adicionarItem(produto1, BigDecimal.ONE, 1);
		carrinhoCompras.adicionarItem(produto2, BigDecimal.TEN, 2);
		Assert.assertEquals(BigDecimal.valueOf(21L), carrinhoCompras.getValorTotal());
		carrinhoCompras.adicionarItem(produtoIgualAo1, BigDecimal.TEN, 1);
		Assert.assertEquals(BigDecimal.valueOf(40L), carrinhoCompras.getValorTotal());
	}
}