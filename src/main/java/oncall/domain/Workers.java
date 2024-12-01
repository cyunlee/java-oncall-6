package oncall.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Workers implements Iterable<Worker> {
    private List<Worker> workers = new ArrayList<>();
    private List<Worker> weekdaysWorkers = new ArrayList<>();
    private List<Worker> weekendsWorkers = new ArrayList<>();

    public Workers() {

    }

    public Workers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Worker> addWorker(Worker worker) {
        workers.add(worker);
        return workers;
    }

    public List<Worker> sortedByWeekdaysIdx() {
        return workers.stream().sorted(Comparator.comparingInt(Worker::getWeekdaysNumber)).toList();
    }

    public List<Worker> sortedByWeekendsIdx() {
        return workers.stream().sorted(Comparator.comparingInt(Worker::getWeekendsNumber)).toList();
    }

    @Override
    public Iterator<Worker> iterator() {
        return workers.iterator();
    }
}
