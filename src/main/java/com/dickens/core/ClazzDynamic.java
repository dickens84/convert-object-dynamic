package com.dickens.core;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * The Class Dynamic.
 *
 * @author Dickens Prabhu
 */
public class ClazzDynamic {
	
	
	/**
	 * Convert obj1 to obj2 on the basis of field name.
	 *
	 * @param obj1 the Object
	 * @param obj2 the Object
	 * 
	 * @return the obj2
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	public Object convert(Object obj1, Object obj2) throws IllegalArgumentException, IllegalAccessException{
        Class<? extends Object> clazz1 = obj1.getClass();
        Class<? extends Object> clazz2 = obj2.getClass();
        for(Field f1: clazz1.getDeclaredFields()){
            f1.setAccessible(true);
            setObject(obj1, obj2, clazz2, f1, f1.getName().trim());
        }
        return obj2;
    }
	
	/**
	 * Convert obj1 to obj2 on the basis of field name.
	 *
	 * @param obj1 the Object
	 * @param obj2 the Object
	 * @param fieldsAssign the HashMap<String,String>(), 
	 *        key is obj1 field name and 
	 *        value is obj2 field name
	 * @return the obj2
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	public Object convert(Object obj1, Object obj2, HashMap<String,String> fieldsAssign) throws IllegalArgumentException, IllegalAccessException{
        Class<? extends Object> clazz1 = obj1.getClass();
        Class<? extends Object> clazz2 = obj2.getClass();
        String fieldName = null;
        for(Field f1: clazz1.getDeclaredFields()){
            f1.setAccessible(true);
            if(fieldsAssign.containsKey(f1.getName().trim()))
            	fieldName = fieldsAssign.get(f1.getName().trim());
            else
            	fieldName = f1.getName().trim();
            setObject(obj1, obj2, clazz2, f1, fieldName);
        }
        return obj2;
    }
	
	/**
	 * Sets the object.
	 *
	 * @param obj1 the obj 1
	 * @param obj2 the obj 2
	 * @param clazz2 the clazz 2
	 * @param f1 the f 1
	 * @param fieldName the field name
	 */
	private void setObject(Object obj1, Object obj2, 
			Class<? extends Object> clazz2, Field f1, String fieldName){
		try {
				 for(Field f2: clazz2.getDeclaredFields()){
		             f2.setAccessible(true);
		             if(fieldName.trim().equalsIgnoreCase(f2.getName().trim()))
		             		f2.set(obj2, f1.get(obj1));
				 }
		 	}catch (IllegalArgumentException e) {
				e.printStackTrace();
			}catch (IllegalAccessException e) {
				e.printStackTrace();
			}
	}
}
