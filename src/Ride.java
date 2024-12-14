public class Ride {
    //游乐设施名称
    private String rideName;
    //游乐设施编号
    private String rideId;
    //负责该游乐设施运行的员工对象
    private Employee rideOperator;
    //默认构造函数，初始化实例变量
    public Ride() {
        this.rideName = "";
        this.rideId = "";
        this.rideOperator = null;
    }
    //带参数的构造函数，用于根据传入参数设置实例变量
    public Ride(String rideName, String rideId, Employee rideOperator) {
        this.rideName = rideName;
        this.rideId = rideId;
        this.rideOperator = rideOperator;
    }
    //获取游乐设施名称的getter方法
    public String getRideName() {
        return rideName;
    }
    //设置游乐设施名称的setter方法
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }
    //获取游乐设施编号的getter方法
    public String getRideId() {
        return rideId;
    }
    //设置游乐设施编号的setter方法
    public void setRideId(String rideId) {
        this.rideId = rideId;
    }
    //获取负责该游乐设施运行的员工对象的getter方法
    public Employee getRideOperator() {
        return rideOperator;
    }
    //设置负责该游乐设施运行的员工对象的setter方法
    public void setRideOperator(Employee rideOperator) {
        this.rideOperator = rideOperator;
    }
}