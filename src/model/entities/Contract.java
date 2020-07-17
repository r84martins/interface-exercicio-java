package model.entities;

import java.util.Date;

public class Contract {
	
	private Date start;
	private String Data;
	
	private Integer numberOfInstallments; 	
	private ContractNumber contractNumber;
	private Double ContractTotalValue;	
	private Double InstallmentValue;
	
	public Contract () {
	}

	public Contract(Double installmentValue) {
		InstallmentValue = installmentValue;
	}
	
	public Contract(String Data, Double installmentValue) {
		this.Data = Data;
		InstallmentValue = installmentValue;
	}

	public Contract(Date start, Integer numberOfInstallments, ContractNumber contractNumber, Double contractTotalValue) {
		this.start = start;
		this.numberOfInstallments = numberOfInstallments;
		this.contractNumber = contractNumber;
		ContractTotalValue = contractTotalValue;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Integer getnumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setnumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}

	public ContractNumber getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(ContractNumber contractNumber) {
		this.contractNumber = contractNumber;
	}

	public Double getContractTotalValue() {
		return ContractTotalValue;
	}

	public void setContractTotalValue(Double contractTotalValue) {
		ContractTotalValue = contractTotalValue;
	}
	
	public Double getInstallmentValue() {
		return InstallmentValue;
	}

	public void setInstallmentValue(Double installmentValue) {
		InstallmentValue = installmentValue;
	}
	
	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public void setInstallment() {
		for (int i = 0; i <= numberOfInstallments; i++) {
			
		}	
	}
}
