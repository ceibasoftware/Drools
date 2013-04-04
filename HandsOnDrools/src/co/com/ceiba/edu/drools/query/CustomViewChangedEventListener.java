package co.com.ceiba.edu.drools.query;

import java.util.ArrayList;
import java.util.List;

import org.drools.runtime.rule.Row;
import org.drools.runtime.rule.ViewChangedEventListener;

import co.com.ceiba.edu.drools.facts.Server;


public class CustomViewChangedEventListener implements ViewChangedEventListener {

    private List<Server> updatedServers = new ArrayList<Server>();
    private List<Server> removedServers = new ArrayList<Server>();
    private List<Server> currentServers = new ArrayList<Server>();

    public void rowUpdated(Row row) {
        updatedServers.add((Server) row.get("$server"));
    }

    public void rowRemoved(Row row) {
        removedServers.add((Server) row.get("$server"));
    }

    public void rowAdded(Row row) {
        currentServers.add((Server) row.get("$server"));
    }

    public List<Server> getUpdatedServers() {
        return updatedServers;
    }

    public List<Server> getRemovedServers() {
        return removedServers;
    }

    public List<Server> getCurrentServers() {
        return currentServers;
    }

}
