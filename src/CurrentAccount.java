public class CurrentAccount extends Account {
    
    public CurrentAccount(Client client, Bank bank) {
        super(client, bank);
    }

    @Override
    public void printExtracts() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.printAccountData();
    }
}
