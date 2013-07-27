package by.muna.types;

import java.util.Iterator;

import by.muna.types.util.ArrayIterator;

public class ConstructorArgs implements Iterable<ConstructorArg> {
    private ConstructorArg[] args;

    public ConstructorArgs(Object... types) {
        this.args = new ConstructorArg[types.length / 2];
        
        for (int i = 0; i < types.length / 2; i++) {
            this.args[i] = new ConstructorArg((String) types[2 * i], (IType) types[2 * i + 1]);
        }
    }
    public ConstructorArgs(IType... types) {
        this.args = new ConstructorArg[types.length];
        
        for (int i = 0; i < types.length; i++) {
            this.args[i] = new ConstructorArg(types[i]);
        }
    }
    public ConstructorArgs(ConstructorArg[] args) {
        this.args = args;
    }
    
    @Override
    public Iterator<ConstructorArg> iterator() {
        return new ArrayIterator<ConstructorArg>(this.args);
    }
    
    public int getCount() {
        return this.args.length;
    }
    
    public ConstructorArg get(int i) {
        return this.args[i];
    }
}
