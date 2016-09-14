package backend.languages.SDMLanguage;

import static org.junit.Assert.*;

import org.junit.Test;

import MethodOverloading.Bar;
import MethodOverloading.Foo;
import MethodOverloading.MethodOverloadingFactory;

public class TestMethodOverloading {

	@Test
	public void testMethodOverloading(){
		Foo foo = MethodOverloadingFactory.eINSTANCE.createFoo();
		Bar bar = MethodOverloadingFactory.eINSTANCE.createBar();
		
		foo.sameMethod(bar, "asdf", 5, null);
		assertEquals(bar, foo.getBar());
		
		Bar otherBar = MethodOverloadingFactory.eINSTANCE.createBar();
		
		foo.sameMethod(null, foo, otherBar, 5);
		assertEquals(otherBar, foo.getBar());
	}
}
