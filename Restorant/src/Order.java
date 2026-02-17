
class Order {
    private String food;
    private int quantity;

    public Order(String food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public String getFood() {
        return this.food;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
