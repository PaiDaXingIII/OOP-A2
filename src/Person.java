public class Person {
    //添加姓名、年龄、性别作为实例变量
    private String name;
    private int age;
    private String gender;
    //默认构造函数
    public Person() {
    }
    //带参数的构造函数，用于初始化实例变量
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    //name的getter和setter方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //age的getter和setter方法
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    //gender的getter和setter方法
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
}