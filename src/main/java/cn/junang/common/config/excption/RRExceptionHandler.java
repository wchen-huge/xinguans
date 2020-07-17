package cn.junang.common.config.excption;


import cn.junang.common.model.R;
import cn.junang.common.model.RCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.naming.AuthenticationException;

/**
 * @author wchen
 * @create 2020-07-14 15:25
 */
@RestControllerAdvice
public class RRExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @ExceptionHandler(ServiceException.class)
    public R handleSerException(ServiceException e){
        return R.error(e.getRCode());
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    public R handleNoException(Exception e){
        logger.error(e.getMessage(),e);
        return R.error(RCode.NO_FOUND);
    }
    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDupException(DuplicateKeyException e){
        logger.error(e.getMessage(),e);
        return R.error(RCode.REPEAT_KEY);
    }

    @ExceptionHandler(AuthenticationException.class)
    public R handleAutException(AuthenticationException e){
        logger.error(e.getMessage(),e);
        return R.error(RCode.AUTHER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e){
        logger.error(e.getMessage(),e);
        return R.error();
    }

}
