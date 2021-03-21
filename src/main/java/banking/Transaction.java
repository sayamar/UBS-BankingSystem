package banking;

/**
 *
 * Private Variables:<br>
 * {@link #accountNumber}: Long<br>
 * {@link #bank}: Bank<br>
 */
public class Transaction {
	
	private Long accountNumber;
	private Bank bank;

	/**
	 *
	 * @param bank
	 *            The bank where the account is housed.
	 * @param accountNumber
	 *            The customer's account number.
	 * @param attemptedPin
	 *            The PIN entered by the customer.
	 * @throws Exception
	 *             Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
		this.bank = bank;
		this.accountNumber = accountNumber;
		boolean isSuccess = this.bank.getAccount(accountNumber).validatePin(attemptedPin);
		if (!isSuccess)
			throw new RuntimeException();
	}

	public double getBalance() {
		return this.bank.getBalance(this.accountNumber);
      
	}

	public void credit(double amount) {
		this.bank.credit(this.accountNumber, amount);
	}

	public boolean debit(double amount) {
		return this.bank.debit(this.accountNumber, amount);
	}
}
