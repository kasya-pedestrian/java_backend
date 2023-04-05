package com.li.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.reggie.entity.Category;

public interface CategoryService extends IService<Category> {
    public void remove(Long id);

    }

