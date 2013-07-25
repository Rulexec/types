// Communa powered.
// License for code below available at: http://com.muna.by/licenses/25
// SHA1 of license is: 2f802e7dc90e37e21708da5f235c8a050b3ca818

package by.muna.types;

import by.muna.types.exceptions.ContainsHoleException;
import by.muna.types.util.Incrementor;

public class Arg implements IType {
    private String name;
    private IType type;
    
    public Arg(IType type) {
        this(null, type);
    }
    public Arg(String name, IType type) {
        this.name = name;
        this.type = type;
    }
    
    public String getArgName() {
        return this.name;
    }
    public IType getType() {
        return this.type;
    }
    
    public Arg newType(IType type) {
        return new Arg(this.name, type);
    }
    
    @Override
    public String getName() {
        return this.type.getName();
    }
    
    @Override
    public String getRootName() {
        return this.type.getRootName();
    }
    @Override
    public boolean isType() {
        return this.type.isType();
    }
    @Override
    public IType getTypeParent() {
        return this.type.getTypeParent();
    }
    @Override
    public IType getTypeSpecialisation() {
        return this.type.getTypeSpecialisation();
    }
    @Override
    public int getTypeArity() {
        return this.type.getTypeArity();
    }
    @Override
    public boolean isTypeFilled() {
        return this.type.isTypeFilled();
    }
    @Override
    public IType applyType(IType type) {
        return this.newType(this.type.applyType(type));
    }
    @Override
    public String toString() {
        return this.type.toString();
    }
    @Override
    public String toString(Incrementor polymorphic) {
        return this.type.toString(polymorphic);
    }
}
