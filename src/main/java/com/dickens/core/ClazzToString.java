package com.dickens.core;

import java.lang.reflect.Field;

/**
 * The Class ToString.
 *
 * @author Dickens Prabhu
 */
public class ClazzToString {
	
	
	/**
	 * To string.
	 *
	 * @param object the object
	 * @return the object
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	public String convertToString(Object object) throws IllegalArgumentException, IllegalAccessException{
		StringBuffer resp = new StringBuffer();
		Class<? extends Object> clazz = object.getClass();
        for(Field f: clazz.getDeclaredFields()){
            f.setAccessible(true);
            if(resp.length() != 0)
            	resp.append(" , ");
            
            resp.append(f.getName().trim());
            resp.append(" = ");
            resp.append(f.get(object));
        }
        return resp.toString();
    }
	
}
