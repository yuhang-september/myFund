package com.yuhang.trading.mapper.system;

import com.yuhang.trading.entity.system.Dictionary;

import java.util.List;

/**
 * Description:
 *
 * @author David
 * @Date 2/28/2024 1:54 AM
 */
public interface DictionaryMapper {

    public List<Dictionary> selectAll();

    public Dictionary selectById(int id);

    public void insert(Dictionary dictionary);
}
