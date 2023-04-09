package com.li.reggie.controller;

import com.li.reggie.commen.R;
import com.li.reggie.dto.SetmealDto;
import com.li.reggie.entity.Setmeal;
import com.li.reggie.service.SetmealDishService;
import com.li.reggie.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * セット管理
 */
@RestController
@Slf4j
@RequestMapping("/setmeal")
public class SetmealController {
    @Autowired
    private SetmealService setmealService;
    @Autowired
    private SetmealDishService setmealDishService;

    /**
     * セットを追加する
     * @param setmealDto
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody SetmealDto setmealDto){
        log.info("セット情報：{}",setmealDto);

        setmealService.saveWithDish(setmealDto);
        return R.success("セット追加成功しました。");
    }
}

