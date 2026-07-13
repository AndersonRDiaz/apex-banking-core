package com.apexbanking;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Inicializando o ecossistema Apex Banking...");

        // Instanciar o repositório que gerencia o banco de dados
        AccountRepository repository = new AccountRepository();

        try {
            System.out.println("\n--- TESTE 1: Criando e Salvando uma Conta ---");
            // Criando uma conta fictícia para o teste
            CheckingAccount novaConta = new CheckingAccount("Anderson Diaz", 8000.0, 1000.0);
            novaConta.deposit(1900.0); // Adicionando uma movimentação (Deposito)

            // Salvando no PostgreSQL através do Hibernate
            repository.save(novaConta);

            System.out.println("\n--- TESTE 2: Listando Contas do Banco ---");
            List<Account> contas = repository.findAll();

            if (contas.isEmpty()) {
                System.out.println(" Nenhuma conta encontrada no banco.");
            } else {
                for (Account acc : contas) {
                    System.out.println(" ID: " + acc.getId() + " | Titular: " + acc.getHolder() + " | Saldo: $" + acc.getBalance());
                }
            }

        } catch (Exception e) {
            System.err.println(" Ocorreu um erro durante os testes no banco:");
            e.printStackTrace();
        } finally {
            // Fechar as conexões do EntityManagerFactory ao encerrar a aplicação
            System.out.println("\n Encerrando conexões com o banco de dados...");
            repository.close();
            System.out.println(" Aplicação finalizada com sucesso!");
        }
    }
}
