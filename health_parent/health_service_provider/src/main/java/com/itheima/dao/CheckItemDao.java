package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;

import java.util.List;

public interface CheckItemDao {
    public void add(CheckItem checkItem);
    public Page<CheckItem> selectByCondition(String queryString);
    public CheckItem findById(Integer id);
    public void deleteById(Integer id);
    public void edit(CheckItem checkItem);
    long findCountByCheckItemId(Integer id);
    public List<CheckItem> findAll();
}
