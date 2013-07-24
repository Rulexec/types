// Communa powered.
// License for code below available at: http://com.muna.by/licenses/25
// SHA1 of license is: 2f802e7dc90e37e21708da5f235c8a050b3ca818

package by.muna.types;


public abstract class Combinator implements IType {
    IType type;
    private int[] typeOrder, dataOrder;

    public Combinator(IType type, int[] typeOrder, int[] dataOrder) {
        this.type = type;
        this.typeOrder = typeOrder;
        this.dataOrder = dataOrder;
    }
    
    /*public static Combinator typeOrder(IType type, int[] typeOrder) {
        return new Combinator(type, typeOrder, null);
    }
    public static Combinator dataOrder(IType type, int[] dataOrder) {
        return new Combinator(type, null, dataOrder);
    }*/
}
