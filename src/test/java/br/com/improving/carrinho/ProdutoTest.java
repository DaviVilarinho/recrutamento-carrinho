package br.com.improving.carrinho;

import org.junit.Assert;
import org.junit.Test;

import com.sun.org.apache.xpath.internal.operations.String;

import junit.framework.TestCase;

public class ProdutoTest extends TestCase {
	@Test
	public void inequalityTest() {
		Produto umProduto = new Produto(10L, "um produto");
		Produto umProdutoDiferente = new Produto(15L, "diferente");
		Produto umProdutoIgual = new Produto(10L, "igual");
		Assert.assertNotEquals(umProduto, umProdutoDiferente);
		Assert.assertNotEquals(umProdutoDiferente, umProduto);
		Assert.assertNotEquals(umProdutoDiferente, umProdutoIgual);
		Assert.assertNotEquals(null, umProduto);
	}

	@Test//(expected = AlgumaExceptionDeParse) TODO
	public void inequalityWhenDifferentObjectShouldThrowException() {
		new Produto(10L, "").equals("Uma String");
	}

	@Test
	public void equalityTest() {
		Produto umProduto = new Produto(10l, "um produto");
		Produto umProdutoDiferente = new Produto(15l, "diferente");
		Produto umProdutoIgual = new Produto(10l, "igual");
		Assert.assertEquals(umProdutoIgual.getCodigo(), umProduto.getCodigo());
		Assert.assertEquals(umProdutoIgual, umProduto);
		Assert.assertEquals(umProduto, umProdutoIgual);
		Assert.assertEquals(umProdutoDiferente, umProdutoDiferente);
	}
}