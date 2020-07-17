package model.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.entities.Contract;
import model.entities.Installments;

public class TaxCalculation {

	private TaxService taxService;
	
	public TaxCalculation() {
	}
	
	public TaxCalculation(TaxService taxService) {
		this.taxService = taxService;
	}

	public List<Contract> InstallmentsGen(Contract contract) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		double installmentValue = contract.getContractTotalValue()/
				contract.getnumberOfInstallments();
		
		Date data = contract.getStart();
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);		
		
		Installments installment = new Installments();
				
		for (int i = 1; i <= contract.getnumberOfInstallments(); i++) {
			double installmentValueWithTax = taxService.tax(installmentValue, i);
			cal.add(Calendar.MONTH, 1);
			String _data = sdf.format(cal.getTime());
					
			installment.addItem(new Contract(_data, installmentValueWithTax));			
		}
		return installment.getListInstallments();
	}
}
