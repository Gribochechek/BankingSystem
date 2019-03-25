package jobs;

import model.dao.BankAccountDao;
import model.dao.DepositDao;
import model.dao.config.DataBaseConfiguration;
import model.entity.DepositAccount;

import java.util.List;

public class AccountBalanceIncrementorImpl implements AccountBalanceincrementor {
    @Override
    public void incrementCreditAccountBalance() {
        try (BankAccountDao bankAccountDao = DataBaseConfiguration.factory.createBankAccountDao()) {


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

            depositDao.updateDepositAccountBalanceByAccountId(depositsForUpdate);


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
    }


}
