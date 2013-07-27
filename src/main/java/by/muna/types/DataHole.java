package by.muna.types;

import by.muna.types.exceptions.TypeIsFilledException;

public class DataHole extends AbstractType {
    public static final DataHole HOLE = new DataHole();

    private static final String c = "?";

    private DataHole() {
        super(TypeType.PSEUDO, DataHole.c, DataHole.c, 0);
    }
    
    @Override
    public IType getRoot() {
        return this;
    }
    
    @Override
    public IType getParent() {
        return null;
    }
    
    @Override
    public IType getSpecialisation() {
        return null;
    }
    
    @Override
    public IType applyType(IType type) {
        throw new TypeIsFilledException();
    }

    @Override
    public String toString() {
        return DataHole.c;
    }
}
