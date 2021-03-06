package by.muna.types;


public class Constructor extends AbstractType {
    private Type type;

    private Constructor root, parent;
    private IType specialisation;
    
    private ConstructorArgs args;

    public Constructor(
        Constructor root, Constructor parent,
        Type type,
        ConstructorArgs args, IType specialisation)
    {
        //super(TypeType.CONSTRUCTOR, root.getName() + " " + type.getTypesString(), rootName, type.getArity());
        this.typeType = TypeType.CONSTRUCTOR;
        this.arity = type.getArity();
        
        this.rootName = root.getName();
        
        this.type = type;
        
        String typesString = this.type.getTypesString();
        if (typesString != null) {
            this.name = this.rootName + " " + typesString;
        } else {
            this.name = this.rootName;
        }
        
        this.root = root;
        this.parent = parent;
        this.specialisation = specialisation;
        
        this.args = args;
    }
    public Constructor(String name, Type type) {
        this(name, type, new ConstructorArgs());
    }
    public Constructor(String name, Type type, ConstructorArgs args) {
        super(TypeType.CONSTRUCTOR, name, name, type.getArity());
        
        this.root = this;
        this.type = type;
        
        this.args = args;
    }
    
    public Type getType() {
        return this.type;
    }
    
    public ConstructorArgs getArgs() {
        return this.args;
    }
    
    @Override
    public IType getRoot() {
        return this.root;
    }
    
    @Override
    public IType getParent() {
        return this.parent;
    }
    
    @Override
    public IType getSpecialisation() {
        return this.specialisation;
    }
    
    @Override
    public Constructor applyType(IType type) {
        Type newType = this.type.applyType(type);
        
        int argCount = this.args.getCount();
        ConstructorArg[] newArgsArray = new ConstructorArg[argCount];
        
        for (int i = 0; i < argCount; i++) {
            ConstructorArg oldArg = this.args.get(i);
            IType argOldType = oldArg.getType();
            IType argNewType;
            
            if (argOldType.getArity() > 0) {
                argNewType = argOldType.applyType(type);
            } else {
                argNewType = argOldType;
            }
        
            newArgsArray[i] = new ConstructorArg(
                oldArg.getName(),
                argNewType
            );
        }
        
        ConstructorArgs newArgs = new ConstructorArgs(newArgsArray);
        
        return new Constructor(this.root, this.parent != null ? this.parent : this, newType, newArgs, type);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.rootName);
        
        for (ConstructorArg arg : this.args) {
            String name = arg.getName();
            IType type = arg.getType();
            
            sb.append(' ');
            
            if (name != null) {
                sb.append(name).append(':');
            }
            
            sb.append(type.getName());
        }
        
        sb.append(" = ").append(this.type.toString());
        
        /*for (int i = 0; i < this.arity; i++) {
            sb.append(" @").append(Integer.toString(i));
        }*/
        
        return sb.toString();
    }
}
