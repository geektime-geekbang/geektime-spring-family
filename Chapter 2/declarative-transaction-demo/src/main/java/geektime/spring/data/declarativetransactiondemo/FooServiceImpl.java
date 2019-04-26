package geektime.spring.data.declarativetransactiondemo;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FooServiceImpl implements FooService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private FooServiceImpl self;

    @Override
    @Transactional
    public void insertRecord() {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('AAA')");
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void insertThenRollback() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('BBB')");
        throw new RollbackException();
    }

    @Override
    public void invokeInsertThenRollbackBySelfService() throws RollbackException {
        self.insertThenRollback();
    }

    @Override
    public void invokeInsertThenRollbackByAopContext() throws RollbackException {
        ((FooService) (AopContext.currentProxy())).insertThenRollback();
    }

    //再加一层事务
    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void invokeInsertThenRollbackAddTransactional() throws RollbackException {
        insertThenRollback();
    }

    @Override
    public void invokeInsertThenRollback() throws RollbackException {
        insertThenRollback();
    }
}
