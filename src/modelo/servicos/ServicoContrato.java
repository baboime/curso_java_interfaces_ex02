package modelo.servicos;

import java.util.Calendar;
import java.util.Date;

import modelo.entidades.Contrato;
import modelo.entidades.Parcela;

public class ServicoContrato {
	
	private ServicoPagamento servicoPagamento;
	
	public ServicoContrato(ServicoPagamento servicoPagamento) {
		this.servicoPagamento = servicoPagamento;
	}

	public void processaContrato (Contrato contrato, Integer meses) {
		
		double valorParcela = contrato.getValorTotal() / meses;
		
		for (int i=1; i<=meses; i++) {
			Date dataParcela = adicionaMes(contrato.getDataContrato(), i);
			double parcelaComJuros = valorParcela + servicoPagamento.juros(valorParcela, i);
			double valorTotalParcela = parcelaComJuros + servicoPagamento.pagamentoTaxa(parcelaComJuros);
			contrato.adicionaParcela(new Parcela(dataParcela, valorTotalParcela));
		}
	}
	
	private Date adicionaMes(Date data, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
}
