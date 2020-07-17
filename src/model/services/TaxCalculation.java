package model.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.entities.Contract;
import model.entities.Installments;

public class TaxCalculation {
	
	private Double amountTax;
	private Integer numberInstallments;
	
	
	private PayPalTax payPalTax;
	
	public TaxCalculation() {
	}

	public TaxCalculation(Double amountTax, Integer numberInstallments, PayPalTax payPalTax) {
		this.amountTax = amountTax;
		this.numberInstallments = numberInstallments;
		this.payPalTax = payPalTax;
	}
	
	public List<Contract> InstallmentsGen(Contract contract) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		double installmentValue = contract.getContractTotalValue()/
				contract.getnumberOfInstallments();
		
		Date data = contract.getStart();
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);		
		
		Installments installment = new Installments();
		PayPalTax payPal = new PayPalTax();
		
		for (int i = 1; i <= contract.getnumberOfInstallments(); i++) {
			double installmentValueWithTax = payPal.tax(installmentValue, i);
			cal.add(Calendar.MONTH, 1);
			String _data = sdf.format(cal.getTime());
			//data = cal.getTime();
			
			installment.addItem(new Contract(_data, installmentValueWithTax));			
		}
		return installment.getListInstallments();
	}
}
