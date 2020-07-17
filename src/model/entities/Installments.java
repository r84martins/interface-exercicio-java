package model.entities;

import java.util.ArrayList;
import java.util.List;


public class Installments {

	private List<Contract> listInstallments = new ArrayList<>();
	
	public Installments() {
	}
		
	public void addItem(Contract installment) {
		listInstallments.add(installment);
	}
	
	public void removeItem(Contract installment) {
		listInstallments.remove(installment);
	}	
	
	public List<Contract> getListInstallments() {
		return listInstallments;
	}
}
