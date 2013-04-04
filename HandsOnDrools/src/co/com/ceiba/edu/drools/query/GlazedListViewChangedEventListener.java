package co.com.ceiba.edu.drools.query;

import java.util.ArrayList;
import java.util.List;

import org.drools.runtime.rule.Row;
import org.drools.runtime.rule.ViewChangedEventListener;

import ca.odell.glazedlists.AbstractEventList;

public class GlazedListViewChangedEventListener extends AbstractEventList<Row> implements ViewChangedEventListener {

    private List<Row> data = new ArrayList<Row>();

    public void rowUpdated(Row row) {
        int index = this.data.indexOf(row);
        updates.beginEvent();
        //updates.addUpdated(index, row, row);
        updates.addUpdate(index);
        updates.commitEvent();
    }

    public void rowRemoved(Row row) {
        int index = this.data.indexOf(row);
        updates.beginEvent();
        data.remove(row);
        updates.addDelete(index);
        updates.commitEvent();
    }

    public void rowAdded(Row row) {
        int index = size();
        updates.beginEvent();
        updates.addInsert(index);
        data.add(row);
        updates.commitEvent();
    }

    public void dispose() {
        data.clear();
    }

    @Override
    public Row get(int index) {
        return data.get(index);
    }

    @Override
    public int size() {
        return data.size();
    }

}
