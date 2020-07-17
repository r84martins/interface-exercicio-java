package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.ContractNumber;
import model.entities.Installments;
import model.services.PayPalTax;
import model.services.TaxCalculation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
				
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int contractNumber = sc.nextInt();
		System.out.print("Pickup (dd/MM/yyyy): ");
		sc.nextLine();
		Date start =  sdf.parse(sc.nextLine());
		System.out.print("Contract Value: ");
		double contractTotalValue = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		int numberOfInstallments = sc.nextInt();
			
		TaxCalculation tax = new TaxCalculation(new PayPalTax());
		List<Contract> lista  = tax.InstallmentsGen(new Contract(start, 
									                numberOfInstallments, 
									                new ContractNumber(contractNumber), 
									                contractTotalValue));
		
		System.out.println("Installments:");
		int size = lista.size();
						
		for(int i = 0; i < size; i++) {
			System.out.println(lista.get(i).getData() + 
					          " - " +
					          lista.get(i).getInstallmentValue());
		}	
		
		sc.close();
	}

}
