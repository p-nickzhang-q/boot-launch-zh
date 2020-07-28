package com.zh.boot.launch.utils;

import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DozerUtils {

    static DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList<>();
        sourceList.forEach(s -> {
            T map = dozerBeanMapper.map(s, destinationClass);
            destinationList.add(map);
        });
        return destinationList;
    }

}
