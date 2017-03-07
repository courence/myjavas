package com.courence.asm;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

public class ClassPrinterTest {
	

	public static void main(String[] args){


		ClassWriter cw = new ClassWriter(0);
		cw.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC+Opcodes.ACC_ABSTRACT+Opcodes.ACC_INTERFACE,
				"com/courence/asm/Comaprable", null, "java/lang/Object", 
				new String[]{"com/courence/asm/Mesurable"});
		cw.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL+Opcodes.ACC_STATIC, "LESS",
				"I", null, new Integer(-1)).visitEnd();
		byte[] b = cw.toByteArray();
		MyClassLoader myClassLoader = new MyClassLoader();
		Class c= myClassLoader.defineClass("com.courence.asm.Comaprable", b);
		
	}
}

class MyClassLoader extends ClassLoader{
	public Class defineClass(String name,byte[] b){
		return defineClass(name,b,0,b.length);
	}
}


