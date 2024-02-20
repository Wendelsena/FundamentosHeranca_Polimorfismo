package entites;

//extends para definir que esta classe tera todos os dados e comportamentos da class Account
public class BusinessAccount extends Account {

	private Double loanLimit;

	public BusinessAccount() {
		super(); // por segurança
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanlimit) {
		super(number, holder, balance);
		this.loanLimit = loanlimit;
	}

	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}

	public void loan(double amount) { // emprestar
		if (amount <= loanLimit) { // só vou poder emprestar se a quantia foi menor ou igual o limite de emprestimo
			balance += amount - 10.00; // adiciona um montante ao deposit e retira 10.0 de taxa
		}
	}
	
	@Override
	public void withdraw(double amount) {
		super.withdraw(amount); // reutilizando o codigo chamando a superclasse com super.
		balance -= 2.0;
	}
}
