package com.feng.commons.lang.bean;

import java.beans.PropertyDescriptor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean属性缓存<br>
 * 用于多次反射造成的性能问题
 *
 * @author bing_huang
 * @since 1.0.2
 */
public enum BeanInfoCache {
    INSTANCE;
    private final Map<Class<?>, Map<String, PropertyDescriptor>> pdCache = new ConcurrentHashMap<>(64);
    private final Map<Class<?>, Map<String, PropertyDescriptor>> ignoreCasePdCache = new ConcurrentHashMap<>(64);

    /**
     * 获取属性名和{@link PropertyDescriptor}的映射
     *
     * @param beanClass  bean类
     * @param ignoreCase 是否忽略大小写
     * @return 属性名和 {@link PropertyDescriptor}
     */
    public Map<String, PropertyDescriptor> getPropertyDescriptorMap(Class<?> beanClass, boolean ignoreCase) {
        return (ignoreCase ? ignoreCasePdCache : pdCache).get(beanClass);
    }

    /**
     * 加入缓存
     *
     * @param beanClass                      Bean的类
     * @param fieldNamePropertyDescriptorMap 属性名和{@link PropertyDescriptor}Map映射
     * @param ignoreCase                     是否忽略大小写
     */
    public void putPropertyDescriptorMap(Class<?> beanClass, Map<String, PropertyDescriptor> fieldNamePropertyDescriptorMap, boolean ignoreCase) {
        (ignoreCase ? ignoreCasePdCache : pdCache).put(beanClass, fieldNamePropertyDescriptorMap);
    }
}
