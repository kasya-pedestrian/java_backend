package com.li.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.reggie.dto.SetmealDto;
import com.li.reggie.entity.Setmeal;

public interface SetmealService extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);
}
