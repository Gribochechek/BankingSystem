package jobs;

import model.dao.CreditDao;
import model.dao.DepositDao;
import model.dao.config.DataBaseConfiguration;
import model.entity.CreditAccount;
import model.entity.CreditTariff;
import model.entity.DepositAccount;
import model.entity.DepositTariff;

import java.util.List;
import java.util.stream.Collectors;

public class AccountBalanceIncrementorImpl implements AccountBalanceincrementor {
    @Override
    public void incrementCreditAccountBalance() {
        try (CreditDao creditDao = DataBaseConfiguration.factory.createCreditDao()) {
            List<CreditAccount> creditsForUpdate = creditDao.findAllCreditAccounts();
            List<CreditAccount> creditsWithCountedIndebtness =
                    creditsForUpdate.stream().map(this::countCreditIndebtness).collect(Collectors.toList());

            creditDao.updateAllCreditIndebtnessByAccountId(creditsWithCountedIndebtness);


            // todo implement method for update balance
            //bankAccountDao. .....
            // select QUERY for contract_balance and tarrif rate
            // count income by rate and first balance spescified in contract
            // update QUERY
        }
    }

    @Override
    public void incrementDepositAccountBalance() {
        try (DepositDao depositDao = DataBaseConfiguration.factory.createDepositDao()) {
            List<DepositAccount> depositsForUpdate = depositDao.findAllDepositAccounts();
            List<DepositAccount> depositWithCountedBalance =
                    depositsForUpdate.stream().map(this::countDepositIncome).collect(Collectors.toList());

            depositDao.updateAllDepositAccountsBalanceByAccountId(depositWithCountedBalance);

        }

        //bankAccountDao. .....
        // todo implement method for update balance
        //bankAccountDao. .....
        // select QUERY for contract_balance and tarrif rate
        // count income by rate and first balance spescified in contract
        // update QUERY

        // todo check  List<DepositAccount> depositsToUpdate = BankAccountService.getAllByBankAccountTypeID(TableConstants.ACCOUNT_TYPE_DEPOSIT);
        //List<DepositTariff> depositTariffs = DepositAccountService.getAllDepositTariffs();


    }

    @Override
    public void run() {
        incrementCreditAccountBalance();
        incrementDepositAccountBalance();
        System.out.println("Thread running");
    }

    public DepositAccount countDepositIncome(DepositAccount account) {
        DepositTariff tariff = account.getDepositTariff();
        int incomeAmount = (int) (account.getBalance() + account.getDepositAmount() * Math.pow(
                ((tariff.getRate()) / 100D),
                (double) JobsExecutor.getSummarySeconds()));
        account.setBalance(incomeAmount);
        return account;
    }

    public CreditAccount countCreditIndebtness(CreditAccount account) {
        CreditTariff tariff = account.getCreditTariff();
        int indebtnessAmount = (int) (account.getIndebtedness() + account.getIndebtedness() * Math.pow(
                ((tariff.getRate()) / 100D), (double) JobsExecutor.getSummarySeconds()));
        account.setIndebtedness(indebtnessAmount);
        return account;
    }
}
