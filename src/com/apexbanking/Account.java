package com.apexbanking;

import java.util.ArrayList;

/**
 * Classe base que representa uma conta bancária genérica no ecossistema Apex Banking.
 * Define a estrutura de dados essencial e os comportamentos padrão de movimentação financeira,
 * como depósitos e saques, servindo de fundação para tipos de contas mais especializados.
 */

public class Account {

    protected ArrayList<String> historic;
    protected String holder; // Titular
    protected double balance; // Saldo

    // Construtor para inicializar uma conta bancária
    public Account(String holder, double initialBalance) {
        this.holder = holder;
        this.balance = initialBalance;
        this.historic = new ArrayList<>();
    }

    // Retorna o nome do titular da conta
    public String getHolder() {
        return holder;
    }

    // Retorna o saldo atual disponivel em conta
    public double getBalance() {
        return balance;
    }

    // Metodo Depositar
    public void deposit(double amount) { // amount representa o valor da transação
        if (amount > 0) {
            this.balance += amount;
            this.historic.add("Depósito recebido: $" + amount);
        }
    }

    // Metodo Saque da conta com base no saldo real disponível
    public void withdraw(double amount) throws InsufficientFundsException{
        // Bloqueia a operação se o valor solicitado ultrapassar o saldo em conta
        if (amount > balance) {
            throw new InsufficientFundsException("Erro: Saldo insuficiente para realizar o saque de $ " + amount);
        } else {
            // Deduz a quantia diretamente do saldo disponível
            this.balance -= amount;
            this.historic.add("Saque de -$" + amount );
        }
    }

    // Metodo que exibe o histórico
    public void showHistoric(){
        System.out.println("--- EXTRATO BANCÁRIO ---");
        if (historic.isEmpty()){
            System.out.println("A lista esta vazie");
        } else {
            for (String s : historic) {
                System.out.println(s);
            }
        }
    }
}