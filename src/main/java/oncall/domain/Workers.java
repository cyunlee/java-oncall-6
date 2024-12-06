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
        return workers.get(index-1);
    }

    public Worker getLastWorker() {
        return workers.get(getSize()-1);
    }

    @Override
    public Iterator<Worker> iterator() {
        return workers.iterator();
    }
}