package by.muna.types;

public class Main {
    public static void main(String[] args) {
        Type alphaType = new Type("Alpha");
        Constructor alpha = new Constructor("alpha", alphaType);
        
        Type eitherType = new Type("Either", 2);
        
        Constructor left = new Constructor("left", eitherType, new ConstructorArgs(
            new TypeHole(0)
        ));
        Constructor right = new Constructor("right", eitherType, new ConstructorArgs(
            new TypeHole(1)
        ));
        
        System.out.println("Either: " + eitherType);
        System.out.println("left: " + left);
        System.out.println("right: " + right);
        
        System.out.println();
        
        System.out.println("Either<alpha,?>: " + eitherType.applyType(alpha));
        System.out.println("left: " + left.applyType(alpha));
        System.out.println("right: " + right.applyType(alpha));
        
        System.out.println();
        
        System.out.println("Either<alpha,Alpha>: " + eitherType.applyType(alpha).applyType(alphaType));
        System.out.println("left: " + left.applyType(alpha).applyType(alphaType));
        System.out.println("right: " + right.applyType(alpha).applyType(alphaType));
    }
}
