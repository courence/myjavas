package com.courence.oom;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MethodAreaOutOfMemory {
	public static void main(String[] args) {

		while (true) {

			Enhancer enhancer = new Enhancer();

			enhancer.setSuperclass(TestCase1.class);

			enhancer.setUseCache(false);

			enhancer.setCallback(new MethodInterceptor() {

				
				public Object intercept(Object arg0, Method arg1,
						Object[] arg2,

						MethodProxy arg3) throws Throwable {

					return arg3.invokeSuper(arg0, arg2);

				}

			});

			enhancer.create();

		}

	}

}

class TestCase1 {

}
