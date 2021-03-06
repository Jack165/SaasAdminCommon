package com.feng.commons.lang.convert;

import com.feng.commons.lang.convert.exceptions.ConverterException;

/**
 * 转换器接口，实现类型转换
 *
 * @author bing_huang
 * @since 1.0.2
 */
public interface Converter<T> {

    /**
     * 转换成指定的类型<br>
     * 如果类型无法转换，将读取默认值的类型做目标类型
     *
     * @param value        原始值
     * @param defaultValue 默认值
     * @return 转换后的值
     * @throws ConverterException 转换失败
     */
    T convert(Object value, T defaultValue) throws ConverterException;
}
