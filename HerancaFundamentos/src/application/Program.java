package application;

import entites.Account;
import entites.BusinessAccount;
import entites.SavingsAccount;

public class Program {

	public static void main(String[] args) {

		Account acc = new Account(1001, "Alex", 1000.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

		// UPCASTING - extraindo objetos de subClasses e atribuindo a
		// superClasse(Account).
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.00);
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

		// DOWNCASTING - extraindo objetos da superClasse e atribuindo a subClasse.
		BusinessAccount acc4 = (BusinessAccount) acc2;
		acc4.loan(100.00); // realizando um emprestimo no valor de 100.

		// BusinessAccount acc5 = (BusinessAccount)acc3; ...
		if (acc3 instanceof BusinessAccount) { // para não dar o erro a cima
			BusinessAccount acc5 = (BusinessAccount) acc3;
			acc5.loan(200.00);
			System.out.println("Loan!");
		}

		if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount) acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}

		// com a taxa de 5.
		acc.withdraw(200.0);
		System.out.println(acc.getBalance());

		// sobreposicao sem a taxa no valor de 5.
		Account acc6 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
		acc6.withdraw(200.00);
		System.out.println(acc6.getBalance());

		Account acc7 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
		acc7.withdraw(200.00);
		System.out.println(acc7.getBalance());
	}

}
