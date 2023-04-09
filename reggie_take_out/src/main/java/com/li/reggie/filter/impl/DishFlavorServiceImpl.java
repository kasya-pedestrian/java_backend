package com.li.reggie.filter.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.reggie.entity.DishFlavor;
import com.li.reggie.mapper.DishFlavorMapper;
import com.li.reggie.service.DishFlavorService;
import com.li.reggie.service.DishService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
