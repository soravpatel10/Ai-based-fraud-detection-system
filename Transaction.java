package model;

public class Transaction {
    private int id;
    private int userId;
    private double amount;
    private boolean flagged;

    public Transaction(int id, int userId, double amount) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.flagged = false;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public double getAmount() { return amount; }
    
    public boolean isFlagged() { return flagged; }
    public void setFlagged(boolean flagged) { this.flagged = flagged; }
}
