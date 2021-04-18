package dal.dao;

import java.util.ArrayList;
import java.util.List;

public abstract class RecordTable<T> {
    private List<T> recordTable;

    public RecordTable() {
        recordTable = new ArrayList<>();
    }

    public abstract boolean addRecord(T record);

    public abstract boolean addRecords(List<T> records);

    protected abstract boolean recordWithIDExists(T record);

    public List<T> getRecords() {
        return recordTable;
    }
}