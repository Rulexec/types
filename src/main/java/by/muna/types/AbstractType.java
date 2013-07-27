package by.muna.types;

public abstract class AbstractType implements IType {
    protected TypeType typeType;
    protected String name;
    protected String rootName;
    protected int arity;

    public AbstractType(TypeType typeType, String name, String typeName) {
        this.typeType = typeType;
        this.name = name;
        this.rootName = typeName;
    }
    public AbstractType(TypeType typeType, String name, String typeName, int arity) {
        this(typeType, name, typeName);
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
