package vip.doctordeng.bbs.result;

import vip.doctordeng.bbs.result.constant.ResultCodeConstant;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/13 11:16
 */
public class ResultUtil {
    public static Message getOneErrorFailMessage(final String errorProperty, final String errorMessage) {
        Message message = getMessage(ResultCodeConstant.RESULT_CODE_FAIL, ResultStatus.FAIL);
        message.addError(errorProperty, errorMessage);
        return message;
    }

    private static <T> Message<T> getMessage(final int resultCode, ResultStatus resultStatus) {
        return  new Message<>(resultCode, resultStatus);
    }

    public static  Message getSuccessMessage() {
        return getMessage(ResultCodeConstant.RESULT_CODE_SUCCESS, ResultStatus.SUCCESS);
    }
}
