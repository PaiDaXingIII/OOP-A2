import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        //先按照年龄比较，如果年龄相同再按照姓名比较
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());
        if (ageComparison == 0) {
            return v1.getName().compareTo(v2.getName());
        }
        return ageComparison;
    }
}