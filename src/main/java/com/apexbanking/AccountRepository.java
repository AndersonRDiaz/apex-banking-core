package com.apexbanking;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class AccountRepository {

    // O EntityManagerFactory gerencia a conexão com base no nome do 'persistenceUnitName'
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("apex-banking-pu");

    // Metodo para salvar ou atualizar qualquer tipo de conta (Account, CheckingAccount ou SavingsAccount)
    public void save(Account account) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            if (account.getId() == null) {
                em.persist(account); // Se for uma conta nova, insere no banco
            } else {
                em.merge(account); // Se a conta já tiver ID, atualiza os dados existentes
            }

            em.getTransaction().commit();
            System.out.println("Conta de " + account.getHolder() + " salva com sucesso no banco!");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Cancela a operação em caso de falha catastrófica
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Metodo para buscar uma conta pelo ID no banco de dados
    public Account findById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Account.class, id);
        } finally {
            em.close();
        }
    }

    // Lista todas as contas registradas no banco utilizando JPQL ()
    public List<Account> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Account a", Account.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Fecha as conexões quando a aplicação for encerrada
    public void close() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
