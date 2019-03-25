package model.service;

import model.dao.BankAccountDao;
import model.dao.HistoryDao;
import model.dao.config.DataBaseConfiguration;
import model.entity.BankAccount;
import model.entity.History;
import model.entity.Requsition;
import model.exception.BankAccountNotExistException;

import java.util.List;

public class BankAccountService {
    public static List<BankAccount> getAllConfirmedBankAccount(int userId) {
        try (BankAccountDao bankAccountDao = DataBaseConfiguration.factory.createBankAccountDao()) {
            return bankAccountDao.findAllBankAccountByUserId(userId);
        }
    }

    public static List<History> getAllHistoryByAccountId(int accountId, int userId) {
        try (HistoryDao historyDao = DataBaseConfiguration.factory.createHistoryDao()) {
            return historyDao.findAllbyBankAccountId(accountId, userId);
        }
    }

    public static boolean pay(Requsition requsition) throws BankAccountNotExistException {
        int fromAccountId = requsition.getFromAccountId();
        int fromUserId = requsition.getFromUserId();
        int toAccountId = requsition.getToAccountId();
        int balance = requsition.getBalance();

        try (BankAccountDao bankAccountDao = DataBaseConfiguration.factory.createBankAccountDao()) {
            return bankAccountDao.pay(fromAccountId, fromUserId, toAccountId, balance);
        }
    }
   /* todo check public static List<DepositAccount> getAllByBankAccountTypeID( int accountTypeId){
        try(BankAccountDao bankAccountDao = DataBaseConfiguration.factory.createBankAccountDao()){
            return bankAccountDao.findAllDepositAccounts(accountTypeId);
        }
    }*/
}
