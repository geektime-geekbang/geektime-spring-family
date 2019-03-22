package geektime.spring.data.errorcodedemo;

import org.springframework.dao.DuplicateKeyException;

public class CustomDuplicatedKeyException extends DuplicateKeyException {
   
	private static final long serialVersionUID = 3061506279667836931L;

	public CustomDuplicatedKeyException(String msg) {
        super(msg);
    }

    public CustomDuplicatedKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
