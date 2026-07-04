package com.apexbanking;

public class CheckingAccount extends Account{

    private double overdraftLimit;

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public CheckingAccount(String holder, double initialBalance, double overdraftLimit) {
        super(holder, initialBalance); //Passa para a mae (Account)
        this.overdraftLimit = overdraftLimit; //Guarda o limite nesta classe
    }

    @Override
    public void withdraw(double amount) {
        // Bloqueia se o valor do saque for MAIOR que (saldo + limite)
        if (amount > (balance + overdraftLimit)){
            System.out.print("Saldo e cheque especial insuficientes\n");
        }
        // Se o cliente tiver saldo real suficiente, avisa que tirou do saldo dele
        else if (amount <= balance) {
            this.balance -= amount;
            System.out.printf("Saque de %.2f realizado com sucesso usando seu Saldo Real\n", amount);
        }
        // Se não tiver saldo real suficiente, mas passar no primeiro teste, usou o limite!
        else {
            this.balance -= amount;
            System.out.printf("Saque de %.2f realizado com sucesso no cheque especial\n", amount);
        }
    }
}