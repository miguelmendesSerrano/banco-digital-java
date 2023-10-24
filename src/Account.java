public abstract class Account implements IAccount {

    private static final String AGENCY = "000-1";
    private static int SEQUENTIAL = 1;
    private static final int LIMIT_WITHDRAW = 3;
    private static int numberWithdraw;

    protected String agency;
    protected int number;
    protected double balance;
    protected Client client;
    protected Bank bank;

    public Account(Client client, Bank bank) {
        this.agency = Account.AGENCY;
        this.number = SEQUENTIAL++;
        this.client = client;
        this.bank = bank;
    }

    @Override
    public void withdraw(double value) {
        if (value > balance || LIMIT_WITHDRAW > 3) {
            System.err.println(String.format("Saldo insuficiente!\nSaldo atual: R$%.2f", this.balance));
        } else if( numberWithdraw >= LIMIT_WITHDRAW) {
            System.err.println("LImite de saques diarios atingido!");
        } else {
            numberWithdraw++;
            balance -= value;
            System.out.println("Saque realizado com sucesso!");
        }
    }

    @Override
    public void deposit(double value) {
        if (value <= 0) {
            System.err.println("Valor inválido para depósito!");
        } else {
            balance += value;
            System.out.println("Deposito realizado com sucesso!");
        }
    }

    @Override
    public void transfer(double value, IAccount destintioAccount) {
        if (value > balance) {
            System.err.println("Saldo insuficiente para essa transacao!");
        } else {
            this.withdraw(value);
            destintioAccount.deposit(value);
            System.out.println("Transferencia realizada com sucesso!");
        }
    }

    public static String getAgency() {
        return AGENCY;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    protected void printAccountData() {
        System.out.println(String.format("Banco: %s", this.bank.getName()));
        System.out.println(String.format("Titular: %s", this.client.getName()));
        System.out.println(String.format("Agencia: %s", this.agency));
        System.out.println(String.format("Numero: %d", this.number));
        System.out.println(String.format("Saldo: R$%.2f", this.balance));
    }
}
