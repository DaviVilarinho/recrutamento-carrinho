package br.com.improving.carrinho;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {
	//private final HashMap<Produto, Item> itemProdutoMapa; // teria sido uma melhor alternativa, mas nao cumpre o requisito de remover iesimo item
	private Collection<Item> itens;

	/**
	 * Construtor sem argumentos da classe carrinho de compras
 	 */
	public CarrinhoCompras() {
		this.itens = new ArrayList<>();
	}

	/**
	 * Construtor com argumento do proprio carrinho
	 *
	 * @param itens
	 */
	public CarrinhoCompras(Collection<Item> itens) {
		this.itens = itens;
	}

	/**
     * Permite a adição de um novo item no carrinho de compras.
     *
     * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser seguidas:
     * - A quantidade do item deverá ser a soma da quantidade atual com a quantidade passada como parâmetro.
     * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor unitário do item deverá ser
     * o passado como parâmetro.
     *
     * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao carrinho de compras.
     *
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) throws RuntimeException {
		if (quantidade <= 0) {
			throw new RuntimeException("Não é possível instanciar quantidade negativa");
			/* 	Eu evitaria colocar quaisquer throw. Este fiz porque é bem óbvio, existe um requisito de throw e parece inofensivo
				dada natureza do método, no entanto	qualquer Exceção deveria ter conversas */
		}
		Item novoItem = new Item(produto, valorUnitario, quantidade);
		final boolean[] didNotChange = {true}; // array porque nao se pode mudar estruturas sem ponteiro em java dentro do escopo de outra funcao
		this.itens = this.itens.stream().map(item -> {
			if (!item.getProduto().equals(novoItem.getProduto())) {
				return item;
			}
			item.setQuantidade(item.getQuantidade() + quantidade);
			item.setValorUnitario(valorUnitario);
			didNotChange[0] = false;
			return item;
		}).collect(Collectors.toList());
		if (didNotChange[0]) {
			this.itens.add(novoItem);
		}
    }

    /**
     * Permite a remoção do item que representa este produto do carrinho de compras.
     *
     * @param produto
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(Produto produto) {
		int tamanhoAntes = this.getItens().size();
		this.itens = this.getItens().stream().filter(item -> !item.getProduto().equals(produto)).collect(Collectors.toList());
		return tamanhoAntes > this.getItens().size();
    }

    /**
     * Permite a remoção do item de acordo com a posição.
     * Essa posição deve ser determinada pela ordem de inclusão do produto na 
     * coleção, em que zero representa o primeiro item.
     *
     * @param posicaoItem
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(int posicaoItem) {
		try {
			ArrayList<Item> itensList = new ArrayList<>(itens);
			itensList.remove(posicaoItem);
			this.itens = itensList;
			return true;
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			return false;
		}
    }

    /**
     * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais
     * de todos os itens que compõem o carrinho.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (Item item : itens) {
			total = total.add(item.getValorTotal());
		}
		return total;
	}

    /**
     * Retorna a lista de itens do carrinho de compras.
     *
     * @return itens
     */
    public Collection<Item> getItens() {
		return itens;
    }
}