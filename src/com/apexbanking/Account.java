package com.apexbanking;

public class Account {

    // Atributos protegidos para que as classes filhas possam acessar
    protected String holder;
    protected double balance;

    // Construtor para inicializar a conta
    public Account(String holder, double initialBalance) {
        this.holder = holder;
        this.balance = initialBalance;
    }

    // Métodos Getters (para acessar os dados com segurança)
    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    // Metodo básico de depósito
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        // SE o valor do saque for MAIOR que o saldo
        if (amount > balance) {
            System.out.print("Saldo insuficiente\n");
        }else  {
            this.balance -= amount;
            System.out.printf("Saque de %.2f realizado com sucesso\n", amount);
        }
    }
}