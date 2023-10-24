public class SavingAccount extends Account {
    
    public SavingAccount(Client client, Bank bank) {
        super(client, bank);
    }

    @Override
    public void printExtracts() {
        System.out.println("=== Extrato Conta Poupanca ===");
        super.printAccountData();
    }
}
