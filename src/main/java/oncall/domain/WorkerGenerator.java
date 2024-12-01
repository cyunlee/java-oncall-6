package oncall.domain;

import java.util.List;

public class WorkerGenerator {
    public Workers generateWorker(List<String> weekdaysWorkersNames, List<String> weekendsWorkersNames) {
        Workers workers = new Workers();

        int weekdaysIdx = 1;
        for (String weekdaysWorkersName : weekdaysWorkersNames) {
            Worker worker = new Worker(weekdaysWorkersName, weekdaysIdx);
            workers.addWorker(worker);
            weekdaysIdx++;
        }

        int weekendsIdx = 1;
        for (String weekendsWorkersName : weekendsWorkersNames) {
            for (Worker worker : workers) {
                worker.modifyWorkerInfo(weekendsWorkersName, weekendsIdx);
                weekendsIdx++;
            }
        }
        return workers;
    }
}
