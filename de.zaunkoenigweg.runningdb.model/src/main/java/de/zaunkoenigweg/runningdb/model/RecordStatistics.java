package de.zaunkoenigweg.runningdb.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This object contains a {@link RecordDistance} and a list of {@link RecordRun}s with matching distance.
 * The latter is sorted ascending by elapsed time.
 * 
 * @author Nikolaus Winter
 */
public class RecordStatistics {

    private RecordDistance recordDistance;
    private List<RecordRun> recordRuns = new ArrayList<RecordRun>();
    private int totalRunCount;

    public RecordStatistics(RecordDistance recordDistance) {
        this.recordDistance = recordDistance;
    }

    public RecordDistance getRecordDistance() {
        return recordDistance;
    }

    public List<RecordRun> getRecordRuns() {
        return recordRuns;
    }
    
    public int getTotalRunCount() {
        return totalRunCount;
    }
    
    public void setTotalRunCount(int totalRunCount) {
        this.totalRunCount = totalRunCount;
    }

//    public String getTeaser() {
//        String teaser;
//        String distance = new DistanceConverter().convertToPresentation(recordDistance.getDistance(), String.class, null);
//        if (StringUtils.isNotBlank(recordDistance.getLabel())) {
//            teaser = String.format("%s: %s Meter (%d mal gelaufen)", recordDistance.getLabel(), distance, this.totalRunCount);
//        } else {
//            teaser = String.format("%s Meter (%d mal gelaufen)", distance, this.totalRunCount);
//        }
//        return teaser;
//    }
//
    /**
     * This object contains the time and a reference to the training session of a run that is
     * kept in a record list.
     */
    public static class RecordRun {
        
        private Integer time;
        private Training training;
        
        public RecordRun(Integer time, Training training) {
            super();
            this.time = time;
            this.training = training;
        }
        
        public Integer getTime() {
            return time;
        }
        
        public Training getTraining() {
            return training;
        }
        
    }
    
}
