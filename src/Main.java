public class Main {
    public static void main(String[] args) throws Exception {

        Bank bank = new Bank();
        bank.setName("Digital-Bank");

        Client miguel = new Client();
        miguel.setName("Miguel");

        Account current = new CurrentAccount(miguel, bank);
        Account savings = new SavingAccount(miguel, bank);

        current.deposit(1000);
        current.transfer(500, savings);

        current.withdraw(550);
        current.withdraw(100);
        current.withdraw(100);
        current.withdraw(100);


        savings.transfer(600, current);

        current.printExtracts();
        savings.printExtracts();
    }
}
