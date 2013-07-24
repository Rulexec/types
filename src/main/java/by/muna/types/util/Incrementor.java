package by.muna.types.util;

public class Incrementor {
    private int value;
    
    public Incrementor() {
        this(0);
    }
    public Incrementor(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value++;
    }
}
