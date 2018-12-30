package sax;

import java.lang.reflect.Field;

/**
 * Created by user
 * on 13.12.2018
 */

public class ReflectionHelper {
    public static Object createInstance(String className){
        try{
            return Class.forName(className).newInstance();
        } catch (Exception ex){ex.getMessage();
        ex.printStackTrace();
        }
        return null;
    }

    public static void setFieldValue(Object object, String fieldName, String value){
        try{
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);

            if(field.getType().equals(String.class)){
                field.set(object, value);
            } else if(field.getType().equals(int.class)) {
                field.set(object, Integer.decode(value));
            }
            field.setAccessible(false);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
