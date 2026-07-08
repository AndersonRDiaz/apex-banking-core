package com.apexbanking;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- CONTA ---");
        CheckingAccount c1 = new CheckingAccount("Anderson", 1000.00, 500.00);
        System.out.println("Conta anderson: $" + c1.getBalance());
        System.out.println("Saldo inicial real: $" + c1.getBalance());
        System.out.println("Saldo do cheque especial: $" + c1.getOverdraftLimit()+ "\n");

        // Desposito
        c1.deposit(500.00);

        // Colocamos o saque dentro do 'try' porque ele se tornou uma "operação de risco"
        try {
            System.out.println("--- OPERACÃO ----");
            System.out.println("Tentando realizar saque...");
            c1.withdraw(200.00);
            System.out.println("Saldo apos saque de : $" + c1.getBalance() + "\n");
        } catch (InsufficientFundsException e) {
            // É ativado apenas se o saque falhar
            System.out.println("Operação Cancelada! Motivo: " + e.getMessage());
            System.out.println("Saldo atual permanece em: $" + c1.getBalance());
        }

        c1.showHistoric();
    }
}