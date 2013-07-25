// Communa powered.
// License for code below available at: http://com.muna.by/licenses/25
// SHA1 of license is: 2f802e7dc90e37e21708da5f235c8a050b3ca818

package by.muna.types;

import by.muna.types.util.Incrementor;

public interface IType {
    String getName();
    String getRootName();

    boolean isType();
    
    IType getTypeParent();
    IType getTypeSpecialisation();
    
    int getTypeArity();

    boolean isTypeFilled();
    
    IType applyType(IType type);
    
    String toString(Incrementor polymorphic);
}
