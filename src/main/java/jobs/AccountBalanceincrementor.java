package jobs;

public interface AccountBalanceincrementor extends Runnable {
    void incrementCreditAccountBalance();
    void incrementDepositAccountBalance();
}
