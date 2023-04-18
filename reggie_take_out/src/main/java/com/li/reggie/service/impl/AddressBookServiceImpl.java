package com.li.reggie.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.reggie.entity.AddressBook;
import com.li.reggie.mapper.AddressBookMapper;
import com.li.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper,AddressBook> implements AddressBookService {

}
