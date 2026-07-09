package com.apexbanking;

import jakarta.persistence.*;

@Entity // Avisa o Hibernate que esta classe é uma entidade do banco
@Table(name = "tb_savings_account") // Nome da tabela no PostgreSQL

public class SavingsAccount extends Account{

    // Taxa percentual de juros aplicada ao rendimento (ex: 0.02 representa 2%)
    private double rateOfReturn;

    // O Construtor padrão que o Hibernate EXIGE
    public SavingsAccount(){
        super();
    }

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
