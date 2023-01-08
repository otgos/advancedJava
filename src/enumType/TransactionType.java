package enumType;

public enum TransactionType {
    DEPOSIT(5),//ordinal:0
    WITHDRAW(4),//ordinal:1
    TRANSFER(2),//ordinal:2
    PAYMENT(7),//ordinal:3

    OTHER(3);//ordinal:4

    private final int transactionCode;

    //to get the integer value of constansts we created getter method
    public int getTransactionCode() {
        return transactionCode;
    }

    private TransactionType(int code){
        this.transactionCode = code;
    }
}
