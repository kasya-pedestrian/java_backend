package com.li.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.reggie.dto.DishDto;
import com.li.reggie.entity.Dish;

public interface DishService extends IService<Dish> {
    //料理を追加する場合、味のデータも追加
    public void saveWithFlavor(DishDto dishDto);
    public DishDto getByIdWithFlavor(Long ID);
    //料理を更新する場合、味も更新する
    public void updateWithFlavor(DishDto dishDto);
}
