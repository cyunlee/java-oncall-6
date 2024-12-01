package oncall.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Workers implements Iterable<Worker> {
    private List<Worker> workers = new ArrayList<>();

    public List<Worker> addLotto(Worker worker) {
        workers.add(worker);
        return workers;
    }

    @Override
    public Iterator<Worker> iterator() {
        return workers.iterator();
    }
}
