// Communa powered.
// License for code below available at: http://com.muna.by/licenses/25
// SHA1 of license is: 2f802e7dc90e37e21708da5f235c8a050b3ca818

package by.muna.types;

import java.util.List;

import by.muna.types.exceptions.ContainsHoleException;
import by.muna.types.util.Incrementor;

public interface IType {
    String getName();
    String getRootName();

    boolean isType();
    
    IType getTypeParent();
    IType getTypeSpecialisation();
    
    IType getDataParent();
    Object getDataSpecialisation();
    
    int getTypeArity();
    int getDataArity() throws ContainsHoleException;

    boolean isTypeFilled();
    boolean isDataFilled();
    
    IType applyType(IType type);
    
    IType applyData(Object o);
    Extracted extractData();
    
    String toString(Incrementor polymorphic);
}
