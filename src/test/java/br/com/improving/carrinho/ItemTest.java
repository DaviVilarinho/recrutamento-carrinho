package br.com.improving.carrinho;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class ItemTest extends TestCase {
	@Test
	public void shouldCalculateCorrectly() {
		Item item = new Item(new Produto(10L, "Um produto"), BigDecimal.valueOf(105L), 10);
		Assert.assertEquals(BigDecimal.valueOf(1050L), item.getValorTotal());
	}
}