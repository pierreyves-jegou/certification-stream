package stream;

import java.util.ArrayList;
import java.util.List;

public class Person {

    public enum SEX { MALE, FEMALE}

    public Person(int age, String name, String country) {
        this.age = age;
        this.name = name;
        this.country = country;
    }

    public Person(int age, String name, String country, SEX sex) {
        this.age = age;
        this.name = name;
        this.country = country;
        this.sex = sex;
    }

    public Person(int age, String name, String country, SEX sex, List<String> emails) {
        this.age = age;
        this.name = name;
        this.country = country;
        this.sex = sex;
        this.emails = emails;
    }

    int age;
    String name;
    String country;
    SEX sex;

    List<String> emails = new ArrayList<>();



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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public SEX getSex() {
        return sex;
    }

    public void setSex(SEX sex) {
        this.sex = sex;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
}
