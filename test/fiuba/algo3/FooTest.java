package fiuba.algo3;

import junit.framework.Assert;
import org.junit.Test;

public class FooTest {

	@Test
	public void doFooShouldReturnFoo(){
        Foo foo = new Foo();
        String result = foo.doFoo();
        Assert.assertEquals("Foo", result);
	}
	

	@Test
	public void test01(){
        Foo foo = new Foo();
        String result = foo.doBar();
        Assert.assertEquals("Bar", result);
	}


}
