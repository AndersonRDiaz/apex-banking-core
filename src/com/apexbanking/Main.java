package com.apexbanking;

public class Main {
    public static void main(String[] args) {

        // Criando a conta com: Titular, Saldo Inicial (100) e Limite Cheque Especial (200)
        CheckingAccount cc = new CheckingAccount("Christian Diaz", 100.00, 200.00);

        System.out.println("Saldo inicial real: $" + cc.getBalance());
        System.out.println("Limite de cheque especial: $" + cc.getOverdraftLimit());
        System.out.println("------------------------------------------------");

        // TESTE 1: Tentar sacar 50 (Tem saldo real, não deve usar o cheque especial)
        cc.withdraw(50.00);
        System.out.println("Saldo após saque de $50: $" + cc.getBalance());
        System.out.println("------------------------------------------------");

        // TESTE 2: Tentar sacar 200 (Saldo real é 50, vai entrar 150 no cheque especial)
        cc.withdraw(200.00);
        System.out.println("Saldo após saque de $200: $" + cc.getBalance());
        System.out.println("------------------------------------------------");

        // TESTE 3: Tentar sacar 100 (Saldo é -150, limite restante é 50. Bloqueia!)
        cc.withdraw(100.00);
        System.out.println("Saldo final: $" + cc.getBalance());

        System.out.println("------------------------------------------------");
        CheckingAccount c1 = new CheckingAccount("Anderson",1000.00, 500.00);
        System.out.println("Conta anderson: $" + c1.getBalance());
        System.out.println("Saldo inicial real: $" + c1.getBalance());
        System.out.println("Saldo do cheque especial: $" + c1.getOverdraftLimit());

        c1.withdraw(1500.00);
        System.out.println("Saldo apos saque de : $" + c1.getBalance());

    }
}