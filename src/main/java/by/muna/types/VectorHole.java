package by.muna.types;


public class VectorHole extends AbstractType {
    private IType type;

    public VectorHole(IType type) {
        super(TypeType.PSEUDO, "# [ " + type.getName() + " ]", "[]", type.getArity());
        
        this.type = type;
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
        return this.type;
    }
    
    @Override
    public IType applyType(IType type) {
        return new VectorHole(type.applyType(type));
    }

    @Override
    public String toString() {
        return "# [ " + this.type.toString() + " ]";
    }
}
