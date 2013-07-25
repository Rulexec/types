// Communa powered.
// License for code below available at: http://com.muna.by/licenses/25
// SHA1 of license is: 2f802e7dc90e37e21708da5f235c8a050b3ca818

package by.muna.types;

import by.muna.types.exceptions.ContainsHoleException;
import by.muna.types.util.Incrementor;

public class TypeHole implements IType {
    private int holeId;

    public TypeHole(int holeId) {
        this.holeId = holeId;
    }
    
    public int getHoleId() {
        return this.holeId;
    }

    @Override
    public String getName() {
        return "@" + Integer.toString(this.holeId);
    }
    
    @Override
    public String getRootName() {
        return this.getName();
    }

    @Override
    public boolean isType() {
        return true;
    }

    @Override
    public IType getTypeParent() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public IType getTypeSpecialisation() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public int getTypeArity() {
        return this.holeId + 1;
    }

    @Override
    public boolean isTypeFilled() {
        return false;
    }

    @Override
    public IType applyType(IType type) {
        if (this.holeId == 0) {
            return type;
        } else {
            return new TypeHole(this.holeId - 1);
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public String toString(Incrementor polymorphic) {
        return this.getName();
    }
}
