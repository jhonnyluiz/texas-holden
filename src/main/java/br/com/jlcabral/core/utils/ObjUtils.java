package br.com.jlcabral.core.utils;

public class ObjUtils {
	
	private ObjUtils() {}
	
	public static Boolean isNull(Object obj) {
		return obj == null;
	}
	
	public static Boolean isNotNull(Object obj) {
		return !isNull(obj);
	}

}
