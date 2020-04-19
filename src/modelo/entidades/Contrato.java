package modelo.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
	
	private Integer numero;
	private Date dataContrato;
	private Double valorTotal;
	
	//Associação
	private List<Parcela> parcelas = new ArrayList<>();
	
	public Contrato(Integer numero, Date dataContrato, Double valorTotal) {
		this.numero = numero;
		this.dataContrato = dataContrato;
		this.valorTotal = valorTotal;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDataContrato() {
		return dataContrato;
	}

	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Parcela> getParcela() {
		return parcelas;
	}
	
	public void adicionaParcela(Parcela parcela) {
		parcelas.add(parcela);
	}
	
	public void removeParcela(Parcela parcela) {
		parcelas.remove(parcela);
	}
}