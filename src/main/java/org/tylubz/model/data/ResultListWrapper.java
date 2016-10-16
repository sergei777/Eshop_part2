package org.tylubz.model.data;

import java.util.Collection;
import java.util.List;

/**
 * Created by Sergei on 15.10.2016.
 */
public class ResultListWrapper<T> {
    private Long count;
    private List<T> results;

    public ResultListWrapper(Long count, List<T> results) {
        this.count = count;
        this.results = results;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

}
