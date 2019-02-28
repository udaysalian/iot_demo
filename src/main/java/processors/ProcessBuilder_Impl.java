package processors;

import java.util.ArrayList;
import java.util.List;

public class ProcessBuilder_Impl {

    IOTStatProcessor avgFlightTimeProcessor ;
    IOTStatProcessor maxValueStatProcessor;
    IOTStatProcessor minimumGapStatProcessor;
    IOTStatProcessor totalGapTimeStatProcessor;

    public ProcessBuilder_Impl(IOTStatProcessor avgFlightTimeProcessor,
                               IOTStatProcessor maxValueStatProcessor,
                               IOTStatProcessor minimumGapStatProcessor,
                               IOTStatProcessor totalGapTimeStatProcessor) {
        this.avgFlightTimeProcessor = avgFlightTimeProcessor;
        this.maxValueStatProcessor = maxValueStatProcessor;
        this.minimumGapStatProcessor = minimumGapStatProcessor;
        this.totalGapTimeStatProcessor = totalGapTimeStatProcessor;
    }

    private List<IOTStatProcessor> processors = null;

    public List<IOTStatProcessor> getProcessors() {

        if(processors == null) {
            processors = new ArrayList<IOTStatProcessor>();
             processors.add(avgFlightTimeProcessor);
             processors.add(maxValueStatProcessor);
             processors.add(minimumGapStatProcessor);
             processors.add(totalGapTimeStatProcessor);
        }
        return processors;
    }
}
