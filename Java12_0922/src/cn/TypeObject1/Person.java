package cn.TypeObject1;

public class Person {
    public String name;
    public String  sex;
    public int age;

    public Person(String name){
        this.name=name;
    }

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void eat(){
        System.out.println(this.name+"正在吃！");
    }

    public void sleep(){
        System.out.println(this.name+"正在睡觉！");
    }

}
