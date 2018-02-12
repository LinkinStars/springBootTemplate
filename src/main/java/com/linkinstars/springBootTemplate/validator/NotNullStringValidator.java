package com.linkinstars.springBootTemplate.validator;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * 字符串非空校验
 * @author LinkinStar
 */
public class NotNullStringValidator extends ValidatorHandler<String> implements Validator<String> {

    /**
     * 需要被校验字符串的字段名
     */
    private String fieldName;

    public NotNullStringValidator(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * 校验方法
     * @param checkedString 需要被校验字符串
     */
    @Override
    public boolean validate(ValidatorContext context, String checkedString){
        if (null == checkedString || "" == checkedString) {
            context.addError(ValidationError.create(String.format("%s不能为空！", fieldName))
                    .setErrorCode(-1)
                    .setField(fieldName)
                    .setInvalidValue(checkedString));
            return false;
        }
        return true;
    }
}
