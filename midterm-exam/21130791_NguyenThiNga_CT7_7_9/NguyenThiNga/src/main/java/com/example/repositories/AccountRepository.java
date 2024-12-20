package com.example.repositories;

import com.example.entities.Account;
import com.example.services.AccountService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class AccountRepository implements AccountService {
    private EntityManager em;
    public AccountRepository(){
        em = Persistence.createEntityManagerFactory("nguyenthinga").createEntityManager();
    }

    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepository();
        Account account = new Account();
        account.setAmount(700000);
        account.setCardNumber("789");
        account.setOwnerName("Anh");
        account.setOwnerAddress("Ho Chi Minh");
        System.out.println(accountRepository.create(account));
//        List<Account> list = accountRepository.getAccountByRangeOfBalance(1000f, 150000f);
//         for (Account a : list){
//             System.out.println(a.toString());
//        }
    }
    @Override
    public boolean create(Account account) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(account);
            tx.commit();
            return true;
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        return em.createNamedQuery("Account.findAll", Account.class).getResultList();
    }

    @Override
    public List<Account> getAccountByRangeOfBalance(double amount, double amountEnd) {
        return em.createNamedQuery("Account.findByAmountBetween", Account.class).setParameter("amount", amount).setParameter("amountEnd", amountEnd).getResultList();
    }

    @Override
    public List<Account> getAccountOwnerAddress(String address) {
        return em.createNamedQuery("Account.findByOwnerAddress", Account.class).setParameter("ownerAddress", "%" + address + "%").getResultList();

    }

    @Override
    public List<Account> getAccountByOwnerName(String name) {
        return em.createNamedQuery("Account.findByOwnerName", Account.class).setParameter("ownerName", "%" + name + "%").getResultList();
    }

    @Override
    public List<Account> getAccountByAmount(Double amount) {
        return em.createNamedQuery("Account.findByAmount", Account.class).setParameter("amount", amount).getResultList();

    }
}
