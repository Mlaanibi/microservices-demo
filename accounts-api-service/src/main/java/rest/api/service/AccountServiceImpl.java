package rest.api.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import rest.api.model.Account;
import rest.api.model.AccountComposite;
import rest.api.model.AccountCompositeCollection;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private RestTemplate accountRestTemplate;

	@Override
	public List<Account> getAccounts(String customerId) {
		List<Account> accounts = Arrays.asList(new Account("1", "Account 1"),
				new Account("2", "Account 2"),
				new Account("3", "Account 3"));
		
		return accounts;
	}

	@Override
	public Account getAccount(String accountId) {
		return new Account(accountId, "My Account Details");
	}
	
	@Override
	public AccountCompositeCollection getAccountComposites(String customerId) {
		AccountCompositeCollection accountCompositeCollection = accountRestTemplate.getForObject("http://accounts-composite-service/accounts", AccountCompositeCollection.class);
		return accountCompositeCollection;
	}
	
	@Override
	public AccountComposite getAccountComposite(String accountNumber) {
		AccountComposite accountComposite = accountRestTemplate.getForObject("http://accounts-composite-service/accounts/"+accountNumber, AccountComposite.class);
		return accountComposite;
	}

}
