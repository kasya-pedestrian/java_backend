package com.li.reggie.filter.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.reggie.commen.CustomException;
import com.li.reggie.entity.Category;
import com.li.reggie.entity.Dish;
import com.li.reggie.entity.Setmeal;
import com.li.reggie.mapper.CategoryMapper;
import com.li.reggie.service.CategoryService;
import com.li.reggie.service.DishService;
import com.li.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;
    /**
     * IDにより分類を削除する。削除前に、料理の分類中に料理があるかどうかを確認
     * @param id
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int count1 = dishService.count(dishLambdaQueryWrapper);
        if(count1 > 0){
            //エラーができる。
            throw new CustomException("関連のある料理があるので、削除出来ません");
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);
        if(count2 > 0){
            //エラーができる。
            throw new CustomException("関連のあるセットがあるので、削除出来ません");
        }
        super.removeById(id);
    }
}
