package rest.api.service;

import java.util.List;

import rest.api.model.Transaction;

public interface TransactionService {

	public Transaction getTransactionDetail(long transactionId);
	
	public List<Transaction> getTransactions(String accountId);
}
