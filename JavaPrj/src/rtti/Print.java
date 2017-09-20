package rtti;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//런타임시에 남아있도록 주석이지만 사라지지 않도록
@Target(ElementType.METHOD)	//안써도 되지만 method에만 사용하도록 제약을 줌
public @interface Print {
	public boolean enable() default true;
	

}
