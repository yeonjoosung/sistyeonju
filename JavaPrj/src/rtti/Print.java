package rtti;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//��Ÿ�ӽÿ� �����ֵ��� �ּ������� ������� �ʵ���
@Target(ElementType.METHOD)	//�Ƚᵵ ������ method���� ����ϵ��� ������ ��
public @interface Print {
	public boolean enable() default true;
	

}
