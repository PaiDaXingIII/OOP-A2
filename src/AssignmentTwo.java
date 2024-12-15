public class AssignmentTwo {
    public static void main(String[] args) {
    }
    public void partThree(){ 
        //创建一个Employee对象，用于设置游乐设施的操作员
        Employee operator = new Employee("Operator 1", 30, "Man", "001", "Amusement facility operation position");

        //创建名为rollerCoaster的Ride对象
        Ride rollerCoaster = new Ride("Amusement facility operation position", "R001", operator);

        //Visitor对象添加到队列中
        Visitor visitor1 = new Visitor("Jack", 21, "Male", "Adult ticket", false);
        Visitor visitor2 = new Visitor("莎伦", 22, "Female", "Adult ticket", false);
        Visitor visitor3 = new Visitor("本尼", 23, "Male", "Adult ticket", false);
        Visitor visitor4 = new Visitor("利奥", 24, "Male", "Adult ticket", false);
        Visitor visitor5 = new Visitor("艾丽", 25, "Female", "Adult ticket", false);

        //使用创建的方法添加至少5名访客到队列
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        //从队列中删除一个访问者
        rollerCoaster.removeVisitorFromQueue(visitor3);

        //打印队列中的所有访客
        rollerCoaster.printQueue();
    }
    public void partFourA(){ 
    } 
    public void partFourB(){ 
    } 
    public void partFive(){ 
    } 
    public void partSix(){ 
    } 
    public void partSeven(){ 
    } 
}