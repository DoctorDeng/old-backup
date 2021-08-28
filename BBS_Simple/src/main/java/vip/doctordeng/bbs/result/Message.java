package vip.doctordeng.bbs.result;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/12 20:05
 */
public class Message<T> {
    private int resultCode;
    private T data;
    private List<Error> errors = new ArrayList<>();
    private ResultStatus resultStatus;

    public Message(int resultCode, T data, ResultStatus resultStatus) {
        this.resultCode = resultCode;
        this.data = data;
        this.resultStatus = resultStatus;
    }

    public Message(int resultCode, ResultStatus resultStatus) {
        this.resultCode = resultCode;
        this.resultStatus = resultStatus;
    }

    public boolean isSuccess() {
        return resultStatus == ResultStatus.SUCCESS;
    }

    public boolean isFail() {
        return resultStatus == ResultStatus.FAIL;
    }

    public boolean isError() {
        return resultStatus == ResultStatus.ERROR;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void addError(final String errorProperty, final String errorMessage) {
        Error error = new Error(errorProperty, errorMessage);
        errors.add(error);
    }

    public List<Error> getErrors() {
        return this.errors;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public T getData() {
        return data;
    }
}
