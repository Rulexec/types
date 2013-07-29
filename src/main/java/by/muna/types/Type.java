package by.muna.types;


public class Type extends AbstractType {
    private Type root, parent;
    private IType specialisation;
    private String typesString;

    private Type(Type root, Type parent, String rootName, String typesString, int arity, IType specialisation) {
        super(TypeType.TYPE, rootName + " " + typesString, rootName, arity);
        
        this.root = root;
        this.parent = parent;
        this.specialisation = specialisation;
        
        this.typesString = typesString;
    }
    public Type(String name) {
        this(name, 0);
    }
    public Type(String name, int arity) {
        super(TypeType.TYPE, name, name, arity);
        
        this.root = this;
    }
    
    public String getTypesString() {
        return this.typesString;
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
    public Type applyType(IType type) {
        if (this.specialisation != null) {
            if (this.specialisation.getArity() > 0) {
                IType applied = this.specialisation.applyType(type);
            
                String typesString;
                
                if (this.parent.typesString != null) {
                    typesString = this.parent.typesString + " " + applied.getName();
                } else {
                    typesString = applied.getName();
                }
                
                int arity = this.arity - 1 + applied.getArity();
            
                return new Type(
                    this.root, this.parent,
                    this.rootName, typesString,
                    arity, applied
                );
            } else {
                return new Type(
                    this.root, this,
                    this.rootName, (this.typesString != null ? this.typesString + " " : "") + type.getName(),
                    this.arity - 1 + type.getArity(), type
                );
            }
        } else {
            return new Type(
                this.root, this, 
                this.rootName, (this.typesString != null ? this.typesString + " " : "") + type.getName(), 
                this.arity - 1 + type.getArity(), type
            );
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.name);
        
        for (int i = 0; i < this.arity; i++) {
            sb.append(" @").append(Integer.toString(i));
        }
        
        return sb.toString();
    }
}
