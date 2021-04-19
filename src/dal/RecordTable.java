package dal;

public abstract class RecordTable<T> {
    public abstract boolean addRecord(T record);

    public boolean addRecords(T[] records) {
        for (T record : records)
            if (recordWithIDExists(record))
                return false;
        for (T record : records)
            addRecord(record);
        return true;
    }

    protected abstract boolean recordWithIDExists(T record);

    public abstract T[] getRecords();
}