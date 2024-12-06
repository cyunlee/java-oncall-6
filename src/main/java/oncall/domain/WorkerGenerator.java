package oncall.domain;

import java.util.List;

public class WorkerGenerator {

    public Workers generatorWorker(List<String> workers) {
        Workers generatedWorkers = new Workers();

        for (int i = 0; i < workers.size(); i++) {
            Worker worker = new Worker(workers.get(i));
            generatedWorkers.addWorker(worker);
        }

        return generatedWorkers;
    }
}
