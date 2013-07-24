// Communa powered.
// License for code below available at: http://com.muna.by/licenses/25
// SHA1 of license is: 2f802e7dc90e37e21708da5f235c8a050b3ca818

package by.muna.types;

import java.util.List;

import by.muna.types.util.Incrementor;

public class Type implements IType {
    private String name;
    
    private int ownArity;
    private int arity;
    
    IType parent, specialisation;
    
    private Constructor constructor;

    public Type(String name) {
        this(name, 0);
    }
    private Type(String name, int arity, IType parent, IType specialisation) {
        this(name, arity, parent, specialisation, null);
    }
    private Type(String name, int arity, IType parent, IType specialisation, Constructor constructor) {
        this.name = name;
        this.parent = parent;
        this.specialisation = specialisation;
        
        this.ownArity = arity;
        this.arity = this.ownArity + (this.specialisation != null ? this.specialisation.getTypeArity() : 0);
        
        this.constructor = constructor;
    }
    public Type(String name, int arity) {
        this.name = name;
        this.ownArity = arity;
        this.arity = arity;
        this.constructor = null;
    }

    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public String getRootName() {
        return this.name;
    }

    @Override
    public boolean isType() {
        return true;
    }
    
    @Override
    public IType getTypeParent() {
        return this.parent;
    }
    
    @Override
    public IType getTypeSpecialisation() {
        return this.specialisation;
    }
    
    @Override
    public IType getDataParent() {
        throw new RuntimeException("Not supported");
    }
    
    @Override
    public IType getDataSpecialisation() {
        throw new RuntimeException("Not supported");
    }

    @Override
    public int getTypeArity() {
        return this.arity;
    }

    @Override
    public int getDataArity() {
        return this.constructor != null ? 1 : 0;
    }

    @Override
    public boolean isTypeFilled() {
        return this.arity == 0;
    }

    @Override
    public boolean isDataFilled() {
        return this.constructor != null;
    }

    @Override
    public IType applyType(IType type) {
        if (this.isTypeFilled()) throw new RuntimeException("Type already filled");
        
        String name = type.getName();
        int newOwnArity = this.ownArity;
        
        if (this.specialisation != null && this.specialisation.getTypeArity() > 0) {
            type = this.specialisation.applyType(type);
        } else {
            newOwnArity--;
        }
        
        Type newType = new Type(this.name + " " + name, newOwnArity, this, type);
        if (this.constructor != null) {
            newType.constructor = (Constructor) this.constructor.typeApplied(newType);
        }
        
        return newType;
    }

    @Override
    public IType applyData(Object o) {
        return new Type(this.name, this.ownArity, this.parent, this.specialisation, (Constructor) o);
    }
    
    @Override
    public String toString() {
        return this.toString(new Incrementor());
    }
    public String toString(Incrementor polymorphic) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.name);
        
        for (int i = 0; i < this.arity; i++) {
            sb.append(" @");
            sb.append(Integer.toString(polymorphic.getValue()));
        }
        
        return sb.toString();
    }
    @Override
    public Extracted extractData() {
        return new Extracted(new Type(this.name, this.ownArity, this.parent, this.specialisation), this.constructor);
    }
}
