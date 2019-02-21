package geektime.spring.data.propagation;

public interface FooService {
    void insertThenRollback() throws RollbackException;
    void invokeInsertThenRollback();
}
