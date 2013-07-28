package by.muna.types.test;

import org.junit.Assert;

import org.junit.Test;

import by.muna.types.Constructor;

public class TLTest {

    @Test
    public void testId() {
        Constructor c = Tests.EITHER_RIGHT
            .applyType(Tests.INT)
            .applyType(Tests.VECTOR_TYPE.applyType(Tests.STRING));
        
        Assert.assertEquals("right Vector string = Either int Vector string", c.toString());
        Assert.assertEquals(0xe791b041, c.getId());
    }

}
