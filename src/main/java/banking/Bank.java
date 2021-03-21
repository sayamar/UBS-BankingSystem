package banking;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	
	private LinkedHashMap<Long, Account> accounts;
	Long accountNumber;
	

	public Bank() {
		
		accounts = new LinkedHashMap<>();
	}

	public Account getAccount(Long accountNumber) {
		return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		long currSeq = getAccountNumber();
		CommercialAccount commercial = new CommercialAccount(company, currSeq , pin, startingDeposit);
		accounts.put(currSeq, commercial);
        return currSeq;
	}

	private long getAccountNumber() {
		if ( accounts.size() == 0 ) {
			return 100;
		}else {
			return 100 + accounts.size() ;
		}
		
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		Long accNumber = this.getAccountNumber();
		ConsumerAccount consumer = new ConsumerAccount(person, accNumber, pin, startingDeposit);
		accounts.put(accNumber, consumer);
        return accNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		 Account account = accounts.get(accountNumber);
		 return account.validatePin(pin);
       
	}

	public double getBalance(Long accountNumber) {
		Account account = accounts.get(accountNumber);
        return account.getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		Account account = accounts.get(accountNumber);
		account.creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		Account account = accounts.get(accountNumber);
        return account.debitAccount(amount);
	}
	
	
}
