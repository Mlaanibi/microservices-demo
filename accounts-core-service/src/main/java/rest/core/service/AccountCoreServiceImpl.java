package rest.core.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import rest.core.model.Account;

@Service
public class AccountCoreServiceImpl implements AccountCoreService {

	@Override
	public Account getAccount(String accountNumber) {
		return new Account(accountNumber, "My Account Details", "SAVINGS", 1000);
	}

	@Override
	public List<Account> getAccounts(String customerNumber) {
		List<Account> accounts = Arrays.asList(
				new Account("1", "Account 1", "SAVINGS", 100),
				new Account("2", "Account 2", "CHECKING", 200),
				new Account("3", "Account 3", "SAVINGS", 300));
		
		return accounts;
	}

}
