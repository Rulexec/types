// Communa powered.
// License for code below available at: http://com.muna.by/licenses/25
// SHA1 of license is: 2f802e7dc90e37e21708da5f235c8a050b3ca818

package by.muna.types;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

public class ArgsList extends ArrayList<Arg> implements List<Arg>, RandomAccess {
    private static final long serialVersionUID = 1L;

    public ArgsList(Object... types) {
        super();
        
        boolean isName = true;
        
        String name = null;
        
        for (Object o : types) {
            if (isName) {
                name = (String) o;
            } else {
                this.add(new Arg(name, (IType) o));
            }
            
            isName = !isName;
        }
    }
    public ArgsList(IType... types) {
        super();
        
        for (IType type : types) {
            this.add(new Arg(type));
        }
    }
}
