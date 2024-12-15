import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private String rideId;
    private Employee rideOperator;
    private Queue<Visitor> waitingQueue;  //存储等待乘坐的游客队列
    private LinkedList<Visitor> rideHistory;  //存储已乘坐过的游客历史记录
    private int maxRider;  // 一次骑行可以容纳的游客数量
    private int numOfCycles;  // 游乐设施运行的次数，默认值为0

    //默认构造函数
    public Ride() {
        this.rideName = "";
        this.rideId = "";
        this.rideOperator = null;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 1;  // 默认一次至少容纳1名游客
        this.numOfCycles = 0;
    }

    //带参数的构造函数
    public Ride(String rideName, String rideId, Employee rideOperator) {
        this.rideName = rideName;
        this.rideId = rideId;
        this.rideOperator = rideOperator;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 1;
        this.numOfCycles = 0;
    }

    // 带四个参数的构造函数
    public Ride(String rideName, String rideId, Employee rideOperator, int maxRider) {
        this.rideName = rideName;
        this.rideId = rideId;
        this.rideOperator = rideOperator;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
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

    // 获取一次骑行可容纳游客数量的方法
    public int getMaxRider() {
        return maxRider;
    }

    // 设置一次骑行可容纳游客数量的方法
    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    // 获取游乐设施运行次数的方法
    public int getNumOfCycles() {
        return numOfCycles;
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
        System.out.println("The ride run round is over and will be" + transferredCount + "Visitors were moved from the waiting queue to the ride history. ");
    }

    //实现接口中的addVisitorToHistory方法，将游客添加到乘坐历史记录
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor!= null) {
            rideHistory.add(visitor);
            System.out.println("Successfully bringing visitor" + visitor.getName() + "add to ride history. ");
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
    //实现接口中的exportRideHistory方法，将乘坐历史记录导出到文件
    @Override
    public void exportRideHistory(String filePath) throws IOException {
        File file = new File(filePath);
        try (FileWriter writer = new FileWriter(file)) {
            for (Visitor visitor : rideHistory) {
                String line = visitor.getName() + "," + visitor.getAge() + "," + visitor.getGender() + "," + visitor.getTicketType() + "," + visitor.isFirstVisit();
                writer.write(line + "\n");
            }
            System.out.println("The ride history has been successfully exported to the file:" + filePath);
        } catch (IOException e) {
            System.out.println("Error exporting ride history to file, error message:" + e.getMessage());
            throw e;
        }
    }

    // 从文件导入乘坐历史记录的方法（实现接口方法）
    @Override
    public void importRideHistory(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("The file to be imported does not exist, please check if the file path is correct.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine())!= null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        String name = parts[0];
                        int age = Integer.parseInt(parts[1]);
                        String gender = parts[2];
                        String ticketType = parts[3];
                        boolean firstVisit = Boolean.parseBoolean(parts[4]);
                        Visitor visitor = new Visitor(name, age, gender, ticketType, firstVisit);
                        rideHistory.add(visitor);
                    } catch (NumberFormatException e) {
                        System.out.println("There is a numerical format error in the tourist information in the parsing file, skipping the current line. Error message:" + e.getMessage());
                        continue;
                    }
                } else {
                    System.out.println("The data format of a certain line in the file is incorrect, skip the current line.");
                    continue;
                }
            }
            System.out.println("Successfully imported tourist information from the file into the ride history.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file, unable to import tourist information. Error message:" + e.getMessage());
            throw e;
        }
    }
}