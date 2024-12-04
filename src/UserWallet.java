public class UserWallet {
    // getters and setters
    private double money;

    public UserWallet(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void addMoney(double value) {
        this.money += value;
    }

    public void subtractMoney(double value) {
        this.money -= value;
    }
}
