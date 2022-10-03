package com.zoey.site.entity.form;

import com.zoey.site.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.core.ResolvableType;

/**
 * @ClassName BaseForm
 * @author: Zoey He
 * @data: 2022-10-02 20:30
 * @Description form 转 po
 */
@ApiModel(description = "form 转 po")
@Data
@Slf4j
public class BaseForm<T extends BasePo> {
    public T toPo(Class<T> clazz){
        T t = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(this, t);
        return t;
    }

    public T toPo(Long id, Class<T> clazz){
        T t = BeanUtils.instantiateClass(clazz);
        t.setId(id);
        BeanUtils.copyProperties(this, t);
        return t;
    }

    public T toPo(){
        ResolvableType resolvableType = ResolvableType.forClass(getClass()).getSuperType();
        Class<T> aClass = (Class<T>) resolvableType.getGeneric(0).resolve();
        return toPo(aClass);
    }
}
