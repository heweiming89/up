package cn.heweiming.up.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by heweiming on 2016/7/2.
 */
@Component
public class Person {

	public Person() {
		System.out.println("Person.Person()");
	}
	
	@Value(value = "曾阿牛")
	private String name;
	@Value(value = "22")
	private int age;
	@Value(value = "男")
	private char gender;

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" + "age=" + age + ", name='" + name + '\'' + ", gender=" + gender
				+ '}';
	}
}
