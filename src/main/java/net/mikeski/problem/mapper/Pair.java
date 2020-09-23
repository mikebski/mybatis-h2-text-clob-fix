package net.mikeski.problem.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Copyright Mike Baranski ()mike.baranski ... gmail.com)
 * <p>
 * Class Pair created by mike 9/22/20 8:30 PM
 */
public class Pair<J, K> {
    static final Logger LOGGER = LoggerFactory.getLogger(Pair.class);
    private J first;
    private K second;

    public Pair(){}

    public Pair(J first, K second){
        this.first = first;
        this.second = second;
    }

    public J getFirst() {
        return first;
    }

    public void setFirst(J first) {
        this.first = first;
    }

    public K getSecond() {
        return second;
    }

    public void setSecond(K second) {
        this.second = second;
    }
}
