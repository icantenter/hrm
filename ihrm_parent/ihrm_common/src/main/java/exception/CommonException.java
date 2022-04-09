package exception;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import lombok.Getter;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Getter
public class CommonException extends Exception {

    private ResultCode resultCode;

    public CommonException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
