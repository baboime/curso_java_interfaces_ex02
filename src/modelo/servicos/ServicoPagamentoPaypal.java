package modelo.servicos;

public class ServicoPagamentoPaypal implements ServicoPagamento {
	
	private static final double TAXA_PAGAMENTO = 0.02;
	private static final double JUROS_MENSAIS = 0.01;

	public double pagamentoTaxa(double montante) {
		return montante * TAXA_PAGAMENTO;
	}
	
	public double juros(double montante, int meses) {
		return montante * JUROS_MENSAIS * meses; 
	}
}
