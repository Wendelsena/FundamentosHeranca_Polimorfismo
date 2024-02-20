package entites;

public final class SavingsAccount extends Account{ // final para impedir que outras subclasses herdem essa.

	private Double interesRate;
	
	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interesRate) {
		super(number, holder, balance);
		this.interesRate = interesRate;
	}

	public Double getInteresRate() {
		return interesRate;
	}

	public void setInteresRate(Double interesRate) {
		this.interesRate = interesRate;
	}
	
	public void updateBalance() {
		balance += balance * interesRate; // atualiza o saldo com a taxa de juros.
	}
	
	@Override
	public void withdraw(double amount) { // fazendo uma sobreposicao
		balance -= amount;
	}
}
