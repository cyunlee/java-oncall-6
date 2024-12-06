package oncall.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Workers implements Iterable<Worker> {
    private List<Worker> workers = new ArrayList<>();

    public List<Worker> addWorker(Worker worker) {
        workers.add(worker);
        return workers;
    }

    public int getSize() {
        return workers.size();
    }

    public Worker getWorker(int index) {
        return workers.get(index);
    }

    @Override
    public Iterator<Worker> iterator() {
        return workers.iterator();
    }
}