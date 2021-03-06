package by.muna.types;

public abstract class AbstractType implements IType {
    protected TypeType typeType;
    protected String name;
    protected String rootName;
    protected int arity;

    public AbstractType() {
    }
    public AbstractType(TypeType typeType, String name, String rootName) {
        this.typeType = typeType;
        this.name = name;
        this.rootName = rootName;
    }
    public AbstractType(TypeType typeType, String name, String rootName, int arity) {
        this(typeType, name, rootName);
        this.arity = arity;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getRootName() {
        return this.rootName;
    }
    
    @Override
    public TypeType getTypeType() {
        return this.typeType;
    }
    
    @Override
    public int getArity() {
        return this.arity;
    }
    
    @Override
    public boolean isFilled() {
        return this.arity == 0;
    }
    
    //
}
