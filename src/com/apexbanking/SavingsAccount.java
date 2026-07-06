package com.apexbanking;

/**
 * Representa uma conta poupança no ecossistema Apex Banking.
 * Esta classe herda as características fundamentais de uma conta bancária,
 * mas adiciona regras para rendimento de juros sobre o saldo positivo.
 */

public class SavingsAccount extends Account{

    // Taxa percentual de juros aplicada ao rendimento (ex: 0.02 representa 2%)
    private double rateOfReturn;

    /**
     * Construtor para inicializar uma conta poupança com taxa personalizada.
     * - Nome do titular da conta
     * - Saldo inicial depositado
     * - Taxa de rendimento da poupança
     */

    public SavingsAccount(String holder, double initialBalance, double rateOfReturn) {
        super(holder, initialBalance);
        this.rateOfReturn = rateOfReturn;
    }

    /**
     * Aplica a taxa de rendimento sobre o saldo atual da conta.
     * A operação só é executada se o saldo for estritamente positivo,
     * garantindo a segurança financeira do banco.
     */

    public void performance(){
        if (this.balance > 0 ){
            // Aplica os juros calculados e atualiza o saldo acumulado (Saldo = Saldo + (Saldo * Taxa))
            this.balance += this.balance * rateOfReturn;
            System.out.printf("Savings account balance is %.2f\n", balance);
        }
    }
}
