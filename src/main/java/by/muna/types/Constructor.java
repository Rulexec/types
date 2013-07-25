// Communa powered.
// License for code below available at: http://com.muna.by/licenses/25
// SHA1 of license is: 2f802e7dc90e37e21708da5f235c8a050b3ca818

package by.muna.types;

import java.util.Stack;
import java.util.zip.CRC32;

import by.muna.types.util.Incrementor;

public class Constructor implements IType {
    private String name, rootName;
    private Type type;
    
    private IType parent, specialisation;
    
    private ArgsList args;

    public Constructor(String name, Type type) {
        this(name, type, new ArgsList());
    }
    public Constructor(String name, Type type, ArgsList args) {
        this.name = name;
        this.rootName = this.name;
        
        this.type = type;
        this.args = args;
    }
    private Constructor(
        String rootName, String name, Type type, ArgsList args, IType parent, IType specialisation)
    {
        this(name, type, args);
        this.rootName = rootName;
        this.parent = parent;
        this.specialisation = specialisation;
    }
    
    public Type getType() {
        return this.type;
    }
    
    public ArgsList getArgs() {
        return this.args;
    }

    @Override
    public String getName() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.name);
        
        Stack<String> stack = new Stack<String>();
        IType root = this.type;
        
        do {
            IType specialisation = root.getTypeSpecialisation();
            
            if (specialisation == null) break;
            
            stack.add(specialisation.getName());
            root = root.getTypeParent();
        } while (root != null);
        
        for (String s : stack) {
            sb.append(" ");
            sb.append(s);
        }
        
        return sb.toString();
    }
    
    @Override
    public String getRootName() {
        return this.rootName;
    }

    @Override
    public boolean isType() {
        return false;
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

    public Constructor typeApplied(Type newType) {
        ArgsList newArgs = new ArgsList();
        
        for (Arg arg : this.args) {
            if (!arg.isTypeFilled()) {
                newArgs.add((Arg) arg.applyType(newType));
            } else {
                newArgs.add(arg);
            }
        }
    
        return new Constructor(this.rootName, this.name, newType,
            newArgs, this.parent, this.specialisation);
    }

    @Override
    public IType applyType(IType type) {
        ArgsList newArgs = new ArgsList();
    
        for (Arg arg : this.args) {
            if (!arg.isTypeFilled()) {
                newArgs.add((Arg) arg.applyType(type));
            } else {
                newArgs.add(arg);
            }
        }
    
        return new Constructor(this.rootName, this.name, (Type) this.type.applyType(type),
            newArgs, this.parent, this.specialisation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.name);
        
        Incrementor polymorphic = new Incrementor();
        
        for (Arg arg : this.args) {
            sb.append(' ');
            if (arg.getArgName() != null) {
                sb.append(arg.getArgName());
                sb.append(':');
            }
            if (!arg.isTypeFilled()) { 
                sb.append(arg.toString(polymorphic));
            } else {
                sb.append(arg.getName());
            }
        }
        //sb.append()
        
        sb.append(" = ");
        sb.append(this.type.toString());
        //return this.toString(new Incrementor());
        
        return sb.toString();
    }
    @Override
    public String toString(Incrementor polymorphic) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.name);
        
        for (IType arg : this.args) {
            sb.append(' ');
            sb.append(arg.toString(polymorphic));
        }
        
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        CRC32 crc = new CRC32();
        
        crc.update(this.toString().getBytes());
        
        return (int) crc.getValue();
    }
}
