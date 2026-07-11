package com.apexbanking;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 1. Diz ao Java que isso vai virar uma tabela no PostgreSQL
@Table(name = "tb_account") // 2. Dá o nome da tabela no banco de dados
@Inheritance(strategy = InheritanceType.JOINED) // 3. Organiza como as classes filhas vão se conectar no banco

public abstract class Account {
    @Id // 4. Define a Chave Primária no banco
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 5. O banco gera esse número
    private Long id;
    protected String holder; // Titular
    protected double balance; // Saldo

    // 6. Transforma o seu ArrayList em uma tabela de histórico interligada
    @ElementCollection
    @CollectionTable(name = "tb_account_historic", joinColumns = @JoinColumn(name = "account_id"))
    @Column(name = "transaction_description")
    protected List<String> historic = new ArrayList<>();

    public Long getId() {
        return id;
    }

    // Construtor padrão exigido pelo Hibernate/JPA
    public Account(){
    }

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