package application;

import java.util.ArrayList;
import java.util.List;

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
		
		//polimorfismo
		System.out.println("\nPolimorfismo ----------");
		Account x = new Account(1020, "Alex", 1000.00); // istanciando 2 contas a x é uma comum a y uma poupança 
		Account y = new SavingsAccount(1023, "Maria", 1000.0, 0.01);
		
		x.withdraw(50.0); // saque de 50
		y.withdraw(50.0);
		
		System.out.println(x.getBalance()); // mostra o saldo final
		System.out.println(y.getBalance());
		
		
		// classe abstrata
		
		// explicação no topo da classe Account <<<<<<<
		Account acc8 = new Account(1001, "Wendel", 1000.0);
		Account acc9 = new SavingsAccount(1002, "Alefe", 1000.0, 0.01);
		Account acc10 = new BusinessAccount(1003, "Julia", 1000.0, 500.0);
		
		System.out.println();
		// podemos adicionar istancias diferentes dado que Account é uma classe generica 
		List<Account> list = new ArrayList<>();
	
		list.add(new SavingsAccount(1004, "Sheila", 500.0, 0.01));
		list.add(new SavingsAccount(1005, "Julia", 1000.0, 0.01));
		list.add(new BusinessAccount(1006, "Kelly", 300.0, 400.00));
		list.add(new BusinessAccount(1007, "Lilian", 500.0, 500.00));
		
		double sum = 0;
		
		for(Account Acc : list) {
			sum += Acc.getBalance(); // independente do tipo de conta a soma aparecera
		}
		
		System.out.println("Total balance: " + sum);
		
		for(Account Acc : list) {
			Acc.deposit(10.0);; // independente do tipo de conta o deposito ocorrera
		}
		
		 // para exibir todas as contas
		for(Account Acc : list) {
			System.out.printf("Updated balance for account %d: $%.2f%n", Acc.getNumber(), Acc.getBalance()); 
		}
	}

}
