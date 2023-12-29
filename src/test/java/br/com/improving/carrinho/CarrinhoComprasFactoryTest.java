package br.com.improving.carrinho;

import java.math.BigDecimal;

import org.junit.Assert;

import junit.framework.TestCase;

public class CarrinhoComprasFactoryTest extends TestCase {

	public void testCriar() {
		String userExistente = "Existo";
		CarrinhoComprasFactory carrinhoComprasFactory = new CarrinhoComprasFactory();
		CarrinhoCompras compras = carrinhoComprasFactory.criar(userExistente);
		Assert.assertEquals(0, compras.getItens().size());
		compras.adicionarItem(new Produto(1L, "01"), BigDecimal.ONE, 1);
		Assert.assertEquals(1, compras.getItens().size());
		compras = carrinhoComprasFactory.criar(userExistente);
		Assert.assertEquals(1, compras.getItens().size());
	}

	public void testGetValorTicketMedio() {
		String userExistente = "Existo";
		CarrinhoComprasFactory carrinhoComprasFactory = new CarrinhoComprasFactory();
		CarrinhoCompras compras = carrinhoComprasFactory.criar(userExistente);
		compras.adicionarItem(new Produto(1L, "01"), BigDecimal.valueOf(2), 1);
		String outroUser = "NãoExisto";
		CarrinhoCompras outrasCompras = carrinhoComprasFactory.criar(outroUser);
		outrasCompras.adicionarItem(new Produto(2L, "02"), BigDecimal.TEN, 1);
		Assert.assertEquals(BigDecimal.valueOf(6L), carrinhoComprasFactory.getValorTicketMedio());
	}

	public void testInvalidar() {
		String userExistente = "Existo";
		String userNaoExiste = "NãoExisto";
		CarrinhoComprasFactory carrinhoComprasFactory = new CarrinhoComprasFactory();
		carrinhoComprasFactory.criar(userExistente);
		Assert.assertTrue(carrinhoComprasFactory.invalidar(userExistente));
		Assert.assertFalse(carrinhoComprasFactory.invalidar(userNaoExiste));
		carrinhoComprasFactory.criar(userNaoExiste);
		Assert.assertTrue(carrinhoComprasFactory.invalidar(userNaoExiste));
	}
}