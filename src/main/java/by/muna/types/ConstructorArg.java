package by.muna.types;


public class ConstructorArg {
    private String name;
    private IType type;
    
    public ConstructorArg(IType type) {
        this(null, type);
    }
    public ConstructorArg(String name, IType type) {
        this.name = name;
        this.type = type;
    }
    
    public String getName() {
        return this.name;
    }
    public IType getType() {
        return this.type;
    }
    
    public ConstructorArg newType(IType type) {
        return new ConstructorArg(this.name, type);
    }
}
