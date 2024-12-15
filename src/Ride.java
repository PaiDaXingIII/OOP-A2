import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private String rideId;
    private Employee rideOperator;
    private Queue<Visitor> waitingQueue;  //存储等待乘坐的游客队列
    private LinkedList<Visitor> rideHistory;  //存储已乘坐过的游客历史记录

    //默认构造函数
    public Ride() {
        this.rideName = "";
        this.rideId = "";
        this.rideOperator = null;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    //带参数的构造函数
    public Ride(String rideName, String rideId, Employee rideOperator) {
        this.rideName = rideName;
        this.rideId = rideId;
        this.rideOperator = rideOperator;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    //获取游乐设施名称的方法
    public String getRideName() {
        return rideName;
    }

    //设置游乐设施名称的方法
    public String setRideName(String rideName) {
        return this.rideName = rideName;
    }

    //获取游乐设施编号的方法
    public String getRideId() {
        return rideId;
    }

    //设置游乐设施编号的方法
    public String setRideId(String rideId) {
        return this.rideId = rideId;
    }

    //获取游乐设施操作员的方法
    public Employee getRideOperator() {
        return rideOperator;
    }

    //设置游乐设施操作员的方法
    public Employee setRideOperator(Employee rideOperator) {
        return this.rideOperator = rideOperator;
    }

    //获取等待游客队列的方法（外部类可通过此方法获取队列进行操作）
    public Queue<Visitor> getWaitingQueue() {
        return waitingQueue;
    }

    //获取已乘坐游客历史记录的方法（外部类可通过此方法获取集合进行操作）
    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    //实现接口中的addVisitorToQueue方法，添加游客到等待队列
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor!= null) {
            waitingQueue.add(visitor);
            System.out.println("Successfully transfer visitors " + visitor.getName() + " add to wait queue.");
        } else {
            System.out.println("Failed to add a visitor to the waiting queue. The incoming visitor object is empty.");
        }
    }

    //实现接口中的removeVisitorFromQueue方法，从等待队列移除游客
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        boolean removed = waitingQueue.remove(visitor);
        if (removed) {
            System.out.println("Successfully removed visitor from waiting queue " + visitor.getName() + ".");
        } else {
            System.out.println("Failed to remove a visitor from the waiting queue. The visitor does not exist in the queue.");
        }
    }

    //实现接口中的printQueue方法，打印等待队列中的游客信息
    @Override
    public void printQueue() {
        System.out.println("The visitor information in the current waiting queue is as follows:");
        for (Visitor v : waitingQueue) {
            System.out.println("Visitor's name:" + v.getName() + ",age:" + v.getAge() + ",gender:" + v.getGender() + ",type of ticket:" + v.getTicketType() + ",Is it a first visit?:" + v.isFirstVisit());
        }
    }

    //实现接口中的runOneCycle方法，运行游乐设施一个周期，将部分游客从等待队列移到乘坐历史记录
    @Override
    public void runOneCycle() {
        if (rideOperator == null) {
            System.out.println("The ride cannot be operated without an assigned ride operator.");
            return;
        }
        if (waitingQueue.isEmpty()) {
            System.out.println("There are no visitors in the waiting queue, so the ride cannot be operated.");
            return;
        }

        //根据不同游乐设施设定每次运行可承载的最大游客数量
        int maxTransfer = 2;
        int transferredCount = 0;
        while (!waitingQueue.isEmpty() && transferredCount < maxTransfer) {
            Visitor visitor = waitingQueue.poll();
            if (visitor!= null) {
                rideHistory.add(visitor);
                transferredCount++;
            }
        }
        System.out.println(" The ride run round is over and will be" + transferredCount + "Visitors were moved from the waiting queue to the ride history. ");
    }

    //实现接口中的addVisitorToHistory方法，将游客添加到乘坐历史记录
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor!= null) {
            rideHistory.add(visitor);
            System.out.println(" Successfully bringing visitor" + visitor.getName() + "add to ride history. ");
        } else {
            System.out.println("Add visitor to ride history failed, incoming visitor object is empty.");
        }
    }

    //实现接口中的checkVisitorFromHistory方法，检查游客是否在乘坐历史记录中
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean inHistory = rideHistory.contains(visitor);
        if (inHistory) {
            System.out.println("Visitor " + visitor.getName() + " in the ride history.");
        } else {
            System.out.println("Visitor " + visitor.getName() + " not in the ride history.");
        }
        return inHistory;
    }

    //实现接口中的numberOfVisitors方法，返回乘坐历史记录中的游客数量
    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("The number of visitor in the history of the ride is:" + count);
        return count;
    }

    //实现接口中的printRideHistory方法，打印乘坐过该游乐设施的游客信息
    @Override
    public void printRideHistory() {
        System.out.println("The historical records of visitors who have ridden the ride are as follows:");
        for (Visitor v : rideHistory) {
            System.out.println("Name of visitor:" + v.getName() + ",age:" + v.getAge() + ",gender:" + v.getGender() + ",type of Ticket:" + v.getTicketType() + ",Is it a first visit?:" + v.isFirstVisit());
        }
    }
}