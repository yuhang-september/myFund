package com.yuhang.service.mapper.system;

import com.yuhang.service.entity.system.Dictionary;

import java.util.List;

/**
 * Description:
 *
 * @author David
 * 2/28/2024 1:54 AM
 */
public interface DictionaryMapper {

    public List<Dictionary> selectAll();

    public Dictionary selectById(int id);

    public void insert(Dictionary dictionary);
}
