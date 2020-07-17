package model.services;

public class PayPalTax {
	
	public double tax(double amount, int installment) {
		double taxPerPeriod = amount * installment * 0.01;
		double taxPerPayment = (amount + taxPerPeriod) * 0.02;
		return amount + taxPerPeriod + taxPerPayment;
	}
}
