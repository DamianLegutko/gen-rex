package pl.damianlegutko.util.genrex.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.text.WordUtils.capitalize;

class ReflectionUtil {
    public static void generateGenerableFields(Object object) {
        Class<?> clazz = object.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            try {
                String getterName = "get" + capitalize(field.getName());
                Method getterMethod = null;

                try {
                    getterMethod = clazz.getMethod(getterName);
                } catch (NoSuchMethodException e) {
                    continue;
                }

                if (Generable.class.isAssignableFrom(field.getType())) {
                    Generable fieldValue = (Generable) getterMethod.invoke(object);

                    if (nonNull(fieldValue)) {
                        fieldValue.generate();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
