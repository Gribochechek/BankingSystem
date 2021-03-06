package controller.command;

import controller.PagesName;
import controller.Parameters;
import model.entity.CreditAccount;
import model.entity.DepositAccount;
import model.exception.BankAccountNotExistException;
import model.service.CreditAccountService;
import model.service.DepositAccountService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UnconfirmedCreditInfoCommand extends AbstractBankAccountInfo {
    @Override
    public String execute(HttpServletRequest request) {
        int realCreditId = super.decryptBankAccountIdFromRequest(request);
        CreditAccount creditAccount = null;
        try {
            creditAccount = CreditAccountService.getConfirmedCreditAccount(realCreditId);
        } catch (BankAccountNotExistException e) {
            e.printStackTrace();
        }
        List<DepositAccount> depositAccountList = DepositAccountService.getAllDepositsByUserBankAcountId(realCreditId);
        for (DepositAccount depositAccount : depositAccountList) {
            System.out.println(depositAccount.getId());
        }

        request.setAttribute(Parameters.CREDIT_ACCOUNT, creditAccount);
        request.setAttribute(Parameters.ALL_DEPOSITS_BY_USER_WITH_CREDIT, depositAccountList);
        return PagesName.ADMIN_UNCONFIRMED_CREDIT_PAGE;
    }
}
