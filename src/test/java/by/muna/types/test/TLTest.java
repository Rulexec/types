package by.muna.types.test;

import org.junit.Assert;

import org.junit.Test;

import by.muna.types.Constructor;

public class TLTest {

    @Test
    public void testId() {
        Constructor c = TypesTest.EITHER_RIGHT
            .applyType(TypesTest.INT)
            .applyType(TypesTest.VECTOR_TYPE.applyType(TypesTest.STRING));
        
        Assert.assertEquals("right Vector string = Either int Vector string", c.toString());
        Assert.assertEquals(0xe791b041, c.getId());
    }

}
