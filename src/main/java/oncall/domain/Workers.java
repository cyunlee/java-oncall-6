package oncall.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Workers implements Iterable<Worker> {
    private List<Worker> workers = new ArrayList<>();
    private List<Worker> weekdaysWorkers = new ArrayList<>();
    private List<Worker> weekendsWorkers = new ArrayList<>();

    public List<Worker> addWorker(Worker worker) {
        workers.add(worker);
        return workers;
    }

    public List<Worker> addWorkerToWeekdaysList(Worker worker) {
        weekdaysWorkers.add(worker);
        return workers;
    }

    public List<Worker> addWorkerToWeekendsList(Worker worker) {
        weekendsWorkers.add(worker);
        return workers;
    }

    @Override
    public Iterator<Worker> iterator() {
        return workers.iterator();
    }
}
