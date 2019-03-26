package model.dao;

import model.entity.CreditAccount;
import model.exception.TariffNotExistException;

import java.util.List;

public interface CreditDao extends GenericDao<CreditAccount> {

    void registerCredit(CreditAccount creditAccount) throws TariffNotExistException;

    List<CreditAccount> findAllConfirmedByUserId(int accountId);

    List<CreditAccount> findAllUnconfirmedCreditsByUserId(int accountId);

    List<CreditAccount> findAllUnconfirmedCredits();

    void updateCreditAccountBalanceByAccountId(int creditId, int indebtedness);

    void updateAllCreditIndebtnessByAccountId(List<CreditAccount> creditsForUpdate);

    List<CreditAccount> findAllCreditAccounts();
    //todo implement

}
