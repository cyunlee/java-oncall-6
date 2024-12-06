package oncall.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Workers implements Iterable<Worker> {
    private List<Worker> Workers = new ArrayList<>();

    public List<Worker> addWorker(Worker Worker) {
        Workers.add(Worker);
        return Workers;
    }

    @Override
    public Iterator<Worker> iterator() {
        return Workers.iterator();
    }
}