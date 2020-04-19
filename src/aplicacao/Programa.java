package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.Contrato;
import modelo.entidades.Parcela;
import modelo.servicos.ServicoContrato;
import modelo.servicos.ServicoPagamentoPaypal;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Informe os dados do contrato");
		System.out.print("Número: ");
		Integer numero = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		Date data = sdf.parse(sc.next());
		System.out.print("Valor do contrato: ");
		Double valor = sc.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, valor);
		
		System.out.print("Informe o número de parcelas: ");
		Integer parcelas = sc.nextInt();
				
		ServicoContrato servicoContrato = new ServicoContrato(new ServicoPagamentoPaypal());
		
		servicoContrato.processaContrato(contrato, parcelas);
		
		System.out.println();
		System.out.println("Parcelas: ");
		
		Double valorTotalFinal = 0.0;
		
		for (Parcela p : contrato.getParcela()) {
			valorTotalFinal += p.getValor();
			System.out.println(p);
		}
		
		System.out.println();
		System.out.printf("Valor total final: %.2f\n", valorTotalFinal);
		
		sc.close();
	}

}
