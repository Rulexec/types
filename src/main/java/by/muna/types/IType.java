package by.muna.types;

public interface IType {
    String getName();
    String getRootName();

    TypeType getTypeType();
    
    int getArity();
    boolean isFilled();
    
    IType getRoot();
    IType getParent();
    IType getSpecialisation();
    
    IType applyType(IType type);
    
    String toString();
}
