package by.muna.types;


public class TypeHole extends AbstractType {
    private int holeId;

    public TypeHole(int holeId) {
        super(TypeType.PSEUDO, "@" + Integer.toString(holeId), "@", 1);
        
        this.holeId = holeId;
    }
    
    @Override
    public IType getRoot() {
        return null;
    }
    
    @Override
    public IType getParent() {
        return new TypeHole(this.holeId + 1);
    }
    
    @Override
    public IType getSpecialisation() {
        return null;
    }
    
    @Override
    public IType applyType(IType type) {
        if (this.holeId == 0) return type;
        else return new TypeHole(this.holeId - 1);
    }
}
