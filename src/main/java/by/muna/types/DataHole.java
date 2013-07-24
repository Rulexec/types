// Communa powered.
// License for code below available at: http://com.muna.by/licenses/25
// SHA1 of license is: 2f802e7dc90e37e21708da5f235c8a050b3ca818

package by.muna.types;

import by.muna.types.exceptions.ContainsHoleException;
import by.muna.types.util.Incrementor;

public class DataHole implements IType {
    protected Object data;

    private DataHole(Object data) {
        this.data = data;
    }
    public DataHole() {
    }
    
    public Object getData() {
        return this.data;
    }

    @Override
    public String getName() {
        return "?";
    }
    
    @Override
    public String getRootName() {
        return this.getName();
    }

    @Override
    public boolean isType() {
        return false;
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
    public IType getDataParent() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Object getDataSpecialisation() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public int getTypeArity() {
        return 0;
    }

    @Override
    public int getDataArity() {
        return this.data != null ? 1 : 0;
    }

    @Override
    public boolean isTypeFilled() {
        return true;
    }

    @Override
    public boolean isDataFilled() {
        return this.data != null;
    }

    @Override
    public IType applyType(IType type) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public IType applyData(Object o) {
        return new DataHole(o);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public String toString(Incrementor polymorphic) {
        return this.getName();
    }
    @Override
    public Extracted extractData() {
        return new Extracted(new DataHole(), this.data);
    }
}
