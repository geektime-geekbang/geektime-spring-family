package geektime.spring.data.declarativetransactiondemo;

public interface FooService {
    void insertRecord();
    void insertThenRollback() throws RollbackException;
    void invokeInsertThenRollback() throws RollbackException;
    void invokeInsertThenRollbackByAopContext() throws RollbackException;
    void invokeInsertThenRollbackBySelfService() throws RollbackException;
    void invokeInsertThenRollbackAddTransactional() throws RollbackException;
}
