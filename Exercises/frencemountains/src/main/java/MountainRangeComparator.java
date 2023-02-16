import java.util.Comparator;

public class MountainRangeComparator implements Comparator<Mountain> {
    @Override
    public int compare(Mountain o1, Mountain o2) {
        if (o1.getRange().compareTo(o2.getRange()) > 0) {
            return 1;
        } else if (o1.getRange().compareTo(o2.getRange()) < 0) {
            return -1;
        } else {
            if (o1.getProminence() - o2.getProminence() > 0) {
                return 1;
            } else if (o1.getProminence() - o2.getProminence() < 0) {
                return -1;
            } else {
                if (o1.getHeight() - o2.getHeight() > 0) {
                    return 1;
                } else if (o1.getHeight() - o2.getHeight() < 0) {
                    return -1;
                }
                return 0;
            }
        }
    }
}
