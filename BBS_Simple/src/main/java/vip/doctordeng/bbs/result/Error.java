package vip.doctordeng.bbs.result;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/12 20:11
 */

public class Error {
    // 错误的字段名称
    private String errorProperty;
    // 错误信息
    private String errorMessage;

    Error(String errorProperty, String errorMessage) {
        this.errorMessage = errorMessage;
        this.errorProperty = errorProperty;
    }

    public String getErrorProperty() {
        return errorProperty;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}