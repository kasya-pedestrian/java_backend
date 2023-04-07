package com.li.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.reggie.dto.DishDto;
import com.li.reggie.entity.Dish;
import com.li.reggie.entity.DishFlavor;
import com.li.reggie.mapper.DishMapper;
import com.li.reggie.service.DishFlavorService;
import com.li.reggie.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    @Autowired
    private DishFlavorService dishFlavorService;
    @Transactional
    public void saveWithFlavor(DishDto dishDto) {
        //料理の情報を料理テーブルに保存する。
        this.save(dishDto);
        Long dishId = dishDto.getId();//料理のID

        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());

        //料理の味情報を味テーブルに保存する。
        dishFlavorService.saveBatch(flavors);

    }
}
