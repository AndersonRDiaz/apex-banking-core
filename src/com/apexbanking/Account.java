package com.apexbanking;

/**
 * Classe base que representa uma conta bancária genérica no ecossistema Apex Banking.
 * Define a estrutura de dados essencial e os comportamentos padrão de movimentação financeira,
 * como depósitos e saques, servindo de fundação para tipos de contas mais especializados.
 */

public class Account {

    /**
     * Atributos protegidos (protected) para permitir que as classes filhas
     * (como CheckingAccount e SavingsAccount) acessem e manipulem diretamente
     * o saldo e o titular sem violar o encapsulamento básico do sistema.
     */

    protected String holder; // Titular
    protected double balance; // Saldo

    // Construtor para inicializar uma conta bancária
    public Account(String holder, double initialBalance) {
        this.holder = holder;
        this.balance = initialBalance;
    }

    // Retorna o nome do titular da conta
    public String getHolder() {
        return holder;
    }

    // Retorna o saldo atual disponivel em conta
    public double getBalance() {
        return balance;
    }

    // Adiciona um valor ao saldo da conta, desde que seja uma quantia positiva
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    /**
     * Realiza o saque de um valor da conta com base no saldo real disponível.
     * Este comportamento padrão impede que a conta fique negativa.
     */

    public void withdraw(double amount) {
        // Bloqueia a operação se o valor solicitado ultrapassar o saldo em conta
        if (amount > balance) {
            System.out.print("Saldo insuficiente\n");
        } else {
            // Deduz a quantia diretamente do saldo disponível
            this.balance -= amount;
            System.out.printf("Saque de %.2f realizado com sucesso\n", amount);
        }
    }
}