package com.li.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.reggie.dto.DishDto;
import com.li.reggie.entity.Dish;

public interface DishService extends IService<Dish> {
    //料理を追加する場合、味のデータも追加
    public void saveWithFlavor(DishDto dishDto);

}
