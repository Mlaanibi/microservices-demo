package rest.core.model;

public class Account {
	
	private String accountNumber;
	private String nickName;
	private String accountType;
	private double currentBalance;
	
	public Account(){}
	
	public Account(String accountNumber, String nickName, String accountType, double currentBalance){
		this.accountNumber = accountNumber;
		this.nickName = nickName;
		this.accountType = accountType;
		this.currentBalance = currentBalance;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public double getCurrentBalance() {
		return currentBalance;
	}


	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	
	
}
