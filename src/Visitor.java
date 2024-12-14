public class Visitor extends Person {
    //以门票类型和是否首次访问为变量
    private String ticketType;
    private boolean firstVisit;

    //默认构造函数，调用父类（Person类）的默认构造函数
    public Visitor() {
        super();
    }
    //初始化Visitor和Person相关的实例变量
    public Visitor(String name, int age, String gender, String ticketType, boolean firstVisit) {
        super(name, age, gender);
        this.ticketType = ticketType;
        this.firstVisit = firstVisit;
    }
    //ticketType的getter和setter方法
    public String getTicketType() {
        return ticketType;
    }
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    //firstVisit的getter和setter方法
    public boolean isFirstVisit() {
        return firstVisit;
    }
    public void setFirstVisit(boolean firstVisit) {
        this.firstVisit = firstVisit;
    }
}
