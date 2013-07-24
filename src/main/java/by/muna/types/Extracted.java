// Communa powered.
// License for code below available at: http://com.muna.by/licenses/25
// SHA1 of license is: 2f802e7dc90e37e21708da5f235c8a050b3ca818

package by.muna.types;

public class Extracted {
    private IType type;
    private Object data;

    public Extracted(IType type, Object data) {
        this.type = type;
        this.data = data;
    }
    
    public IType getType() {
        return this.type;
    }
    
    public Object getData() {
        return this.data;
    }
}
