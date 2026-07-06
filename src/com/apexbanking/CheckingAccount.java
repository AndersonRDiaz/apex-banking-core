package com.apexbanking;

/**
 * Representa uma conta corrente no ecossistema Apex Banking.
 * Esta classe estende a conta básica adicionando a funcionalidade de cheque especial (overdraft),
 * permitindo que o cliente realize saques além do seu saldo real, até um limite predefinido.
 */

public class CheckingAccount extends Account{

    // Limite máximo de crédito concedido pelo banco para saldo negativo
    private double overdraftLimit;

    // Construtor para inicializar uma conta corrente com cheque especial.
    public CheckingAccount(String holder, double initialBalance, double overdraftLimit) {
        super(holder, initialBalance); //Passa para a mae (Account)
        this.overdraftLimit = overdraftLimit; //Guarda o limite nesta classe
    }

    // Retorna o limite atual do cheque especial
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    /**
     * Realiza o saque de um valor da conta corrente.
     * Sobrescreve o comportamento padrão para permitir o uso do cheque especial.
     * A operação valida se o valor solicitado não ultrapassa os fundos totais disponíveis.
     */

    @Override
    public void withdraw(double amount) {
        // Regra 1: Bloqueia se o valor do saque for MAIOR que (saldo + limite)
        if (amount > (balance + overdraftLimit)){
            System.out.print("Saldo e cheque especial insuficientes\n");
        }
        // Regra 2: Se o cliente tiver saldo real suficiente, debita diretamente dele
        else if (amount <= balance) {
            this.balance -= amount;
            System.out.printf("Saque de %.2f realizado com sucesso usando seu Saldo Real\n", amount);
        }
        // Regra 3: Se não tiver saldo real suficiente, mas passar no primeiro teste, usou o limite!
        else {
            this.balance -= amount;
            System.out.printf("Saque de %.2f realizado com sucesso no cheque especial\n", amount);
        }
    }
}