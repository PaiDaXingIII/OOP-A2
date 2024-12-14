public class Employee extends Person {
    //员工编号和岗位为变量
    private String employeeId;
    private String position;
    //默认构造函数，调用父类（Person类）的默认构造函数
    public Employee() {
        super();
    }
    //带参数的构造函数，用于初始化Employee和Person相关的实例变量
    public Employee(String name, int age, String gender, String employeeId, String position) {
        super(name, age, gender);
        this.employeeId = employeeId;
        this.position = position;
    }
    //employeeId的getter和setter方法
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    //position的getter和setter方法
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
}