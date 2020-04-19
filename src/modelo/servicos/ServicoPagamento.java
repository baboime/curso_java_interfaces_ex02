package modelo.servicos;

public interface ServicoPagamento {
	
	double pagamentoTaxa(double montante);
	
	double juros(double montante, int meses);

}
