package by.muna.types;


public class Type extends AbstractType {
    private Type root, parent;
    private IType specialisation;

    private Type(Type root, Type parent, String name, int arity, IType specialisation) {
        super(TypeType.TYPE, name, root.getRootName(), arity);
        
        this.root = root;
        this.parent = parent;
        this.specialisation = specialisation;
    }
    public Type(String name) {
        this(name, 0);
    }
    public Type(String name, int arity) {
        super(TypeType.TYPE, name, name, arity);
        
        this.root = this;
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
    public IType applyType(IType type) {
        if (this.specialisation != null) {
            if (this.specialisation.getArity() > 0) {
                IType applied = this.specialisation.applyType(type);
            
                String name = this.parent.name + " " + applied.getName();
                int arity = this.arity - 1 + applied.getArity();
            
                return new Type(
                    this.root, this,
                    name,
                    arity, applied
                );
            } else {
                return new Type(
                    this.root, this,
                    this.name + " " + type.getName(),
                    this.arity - 1 + type.getArity(), type
                );
            }
        } else {
            return new Type(this.root, this, this.name + " " + type.getName(), this.arity - 1, type);
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
