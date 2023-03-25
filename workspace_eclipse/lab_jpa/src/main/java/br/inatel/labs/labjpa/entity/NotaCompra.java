package br.inatel.labs.labjpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class NotaCompra {
	private Long id;
	private List<NotaCompraItem> listaNotaCompraItem;
	private Fornecedor fornecedor;
	private LocalDate dataEmissao;
	
	public BigDecimal getCalculoTotalNota() {
		//stream é uma estrutura de dados para manipular uma lista
		BigDecimal total = this.listaNotaCompraItem.stream()
				.map(i -> i.getCalculoTotalItem())
				//Faz a soma (valor inicial, somatoria de 2 em 2 itens)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return total;
	}
}
