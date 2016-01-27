package rest.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import rest.api.model.Transaction;
import rest.api.model.TransactionCollectionResponse;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private RestTemplate transactionsRestTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackTransactionDetail", commandProperties = {
			@HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000") })
	@Override
	public Transaction getTransactionDetail(String accountNumber, long transactionId) {
		//Transaction transaction = new Transaction("123", "FromAcc-Detail", "2014-12-12", transactionId);
		Transaction transaction = transactionsRestTemplate.getForObject("http://transactions-core-service/accounts/"+accountNumber+"/transactions/"+transactionId, Transaction.class);
		return transaction;
	}
	
	@HystrixCommand(fallbackMethod = "getFallbackTransactions", commandProperties = {
			@HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000") })
	@Override
	public TransactionCollectionResponse getTransactions(String accountNumber) {
		/*List<Transaction> transactions = new ArrayList<Transaction>();
		for(int i=0; i<3; i++){
			Transaction transaction = new Transaction(accountId, "FromAcc-"+i, "2014-12-12", 10);
			transactions.add(transaction);
		}*/
		
		TransactionCollectionResponse response = transactionsRestTemplate.getForObject("http://transactions-core-service/accounts/"+accountNumber+"/transactions/", TransactionCollectionResponse.class);;
		return response;
	}
	
	
	public List<Transaction> getFallbackTransactions(String accountNumber) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		for(int i=0; i<3; i++){
			Transaction transaction = new Transaction(i, accountNumber, "FromAcc-"+i, "2014-12-12", 10);
			transactions.add(transaction);
		}
		
		return transactions;
	}
	
	public Transaction getFallbackTransactionDetail(String accountNumber, long transactionId) {
		return new Transaction(transactionId, accountNumber, "FromAcc-Detail", "2014-12-12", 123.00);
	}

}
