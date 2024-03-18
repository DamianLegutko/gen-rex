package pl.damianlegutko.util.genrex.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that overriding this method should be done with care.
 * This annotation is intended to signal developers that while
 * overriding is allowed, it requires careful consideration due
 * to potential impacts on the class's behavior or design.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
@interface BeCarefulWhenOverwriting {
}
