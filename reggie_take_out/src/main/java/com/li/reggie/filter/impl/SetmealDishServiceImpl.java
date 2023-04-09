package com.li.reggie.filter.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.reggie.entity.SetmealDish;
import com.li.reggie.mapper.SetmealDishMapper;
import com.li.reggie.service.SetmealDishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper, SetmealDish> implements SetmealDishService {
}
