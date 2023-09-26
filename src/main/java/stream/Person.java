package stream;

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

    int age;
    String name;
    String country;
    SEX sex;



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
}
