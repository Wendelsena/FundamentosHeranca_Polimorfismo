package entites;

public class Account {

	private Integer number;
	private String holder;
	protected Double balance; // protected para deixar acessivel para outra classes.
	
	public Account() {
	}
	
	public Account(Integer number, String holder, Double balance) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getHolder() {
		return holder;
	}
	
	public void setHolder(String holder) {
		this.holder = holder;
	}
	
	public Double getBalance() { // sem setBalance, o saldo da conta não pode ser alterado livremente.
		return balance;
	}
	
	public void withdraw(double amount) { // saque
		balance -= amount + 5.0;
	}
	
	public void deposit(double amount) { // deposito
		balance += amount;
	}
}
