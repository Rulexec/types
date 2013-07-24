// Communa powered.
// License for code below available at: http://com.muna.by/licenses/25
// SHA1 of license is: 2f802e7dc90e37e21708da5f235c8a050b3ca818

package by.muna.types;

import java.util.List;

import by.muna.types.exceptions.ContainsHoleException;
import by.muna.types.util.Incrementor;

public class ListHole implements IType {
    private IType type;
    private List<Object> list;
    
    private ListHole(IType type, List<Object> list) {
        this.type = type;
        this.list = list;
    }
    public ListHole(IType type) {
        this.type = type;
    }

    public List<Object> getList() {
        return this.list;
    }
    
    @Override
    public String getName() {
        return "[" + this.type.getName() + "]";
    }
    
    @Override
    public boolean isType() {
        return true;
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
        return new ListHole(this.type.applyType(type));
    }
    
    @Override
    public String toString() {
        return "# [ " + this.type.getRootName() + " ]";
    }
    
    @Override
    public String toString(Incrementor polymorphic) {
        if (!this.isTypeFilled()) {
            return "# [ " + this.type.toString(polymorphic) + " ]";
        } else {
            return this.toString();
        }
    }

    @Override
    public String getRootName() {
        return this.toString();
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
    public int getDataArity() throws ContainsHoleException {
        return this.list != null ? 1 : 0;
    }

    @Override
    public boolean isDataFilled() {
        return this.list != null;
    }

    @Override
    public IType applyData(Object o) {
        return new ListHole(this.type, (List<Object>) o);
    }
    @Override
    public Extracted extractData() {
        return new Extracted(new ListHole(this.type), this.list);
    }

}
