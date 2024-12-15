public class AssignmentTwo {
    public static void main(String[] args) {
    }
    public void partThree(){ 
        //创建一个Employee对象，用于设置游乐设施的操作员
        Employee operator = new Employee("Operator 1", 30, "Male", "001", "Amusement facility operation position");

        //创建名为rollerCoaster的Ride对象
        Ride rollerCoaster = new Ride("Amusement facility operation position", "R001", operator);

        //Visitor对象添加到队列中
        Visitor visitor1 = new Visitor("Jack", 21, "Male", "Adult ticket", false);
        Visitor visitor2 = new Visitor("Sharin", 22, "Female", "Adult ticket", false);
        Visitor visitor3 = new Visitor("Benny", 23, "Male", "Adult ticket", false);
        Visitor visitor4 = new Visitor("Leo", 24, "Male", "Adult ticket", false);
        Visitor visitor5 = new Visitor("Jason", 25, "Male", "Adult ticket", false);

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
        //创建操作员对象
        Employee operator = new Employee("Operator 1", 35, "Male", "0001", "Amusement facility operation position");

        //创建rollerCoaster游乐设施对象
        Ride rollerCoaster = new Ride("rollerCoaster", "RC001", operator);

        //创建多个游客对象
        Visitor visitor1 = new Visitor("Jack", 28, "Male", "Adult ticket", false);
        Visitor visitor2 = new Visitor("Sharin", 25, "Female", "Adult ticket", false);
        Visitor visitor3 = new Visitor("Benny", 30, "Male", "Adult ticket", false);
        Visitor visitor4 = new Visitor("Leo", 22, "Male", "Adult ticket", false);
        Visitor visitor5 = new Visitor("Nehemia", 26, "Female", "Adult ticket", false);
        Visitor visitor6 = new Visitor("Jason", 24, "Male", "Adult ticket", false);

        //向rollerCoaster的乘坐历史记录中添加已乘坐过的游客
        rollerCoaster.addVisitorToHistory(visitor5);
        rollerCoaster.addVisitorToHistory(visitor6);

        //向收藏（乘坐历史记录）中再添加一些访客
        rollerCoaster.addVisitorToHistory(visitor1);
        rollerCoaster.addVisitorToHistory(visitor2);
        rollerCoaster.addVisitorToHistory(visitor3);
        rollerCoaster.addVisitorToHistory(visitor4);

        //检查收藏（乘坐历史记录）中是否有特定访客
        rollerCoaster.checkVisitorFromHistory(visitor1);

        //打印收藏（乘坐历史记录）中的访客数量
        rollerCoaster.numberOfVisitors();

        //打印收藏（乘坐历史记录）中的所有访客详细信息
        rollerCoaster.printRideHistory();
    } 
    public void partFourB(){ 
        //创建一个Employee对象，用于设置游乐设施的操作员
        Employee operator = new Employee("Operator 2", 32, "Male", "002", "Amusement facility operation position");

        //创建名为thunderstorm的Ride对象
        Ride thunderstorm = new Ride("thunderstorm", "T001", operator);

        //创建一些Visitor对象，用于添加到乘坐历史记录
        Visitor visitor7 = new Visitor("Tom", 26, "Male", "Adult ticket", false);
        Visitor visitor8 = new Visitor("Sherly", 24, "Female", "Adult ticket", false);
        Visitor visitor9 = new Visitor("Ben", 30, "Male", "Adult ticket", false);
        Visitor visitor10 = new Visitor("David", 27, "Male", "Adult ticket", false);
        Visitor visitor11 = new Visitor("Lee", 23, "Male", "Adult ticket", false);

        //使用创建的方法向收藏（乘坐历史）中添加至少5名访客
        thunderstorm.addVisitorToHistory(visitor7);
        thunderstorm.addVisitorToHistory(visitor8);
        thunderstorm.addVisitorToHistory(visitor9);
        thunderstorm.addVisitorToHistory(visitor10);
        thunderstorm.addVisitorToHistory(visitor11);

        //检查收藏（乘坐历史）中是否有访客（这里检查visitor8）
        thunderstorm.checkVisitorFromHistory(visitor8);

        //打印收藏（乘坐历史）中的访客数量
        thunderstorm.numberOfVisitors();

        //打印收藏（乘坐历史）中的所有访客
        thunderstorm.printRideHistory();
    } 
    public void partFive(){ 
    } 
    public void partSix(){ 
    } 
    public void partSeven(){ 
    } 
}