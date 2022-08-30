package appication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import service.ContractService;
import service.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner tec = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Insira os dados do contrato:");
		System.out.print("Número: ");
		int number = tec.nextInt();
		
		System.out.print("Data (dd/mm/aaaa): ");
		Date date = sdf.parse(tec.next());
		
		System.out.print("Valor do Contrato: R$");
		double totalValue = tec.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Entre com o número de parcelas: ");
		int N = tec.nextInt();
		
		ContractService cs = new ContractService(new PaypalService());
		
		cs.processContract(contract, N);
		
		System.out.println("");
		System.out.println("Parcelas:");
		for(Installment it: contract.getInstallments()) {
			System.out.println(it);
		}
		
		
		
		
				
		tec.close();
	}

}
