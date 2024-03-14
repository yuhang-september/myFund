package com.yuhang.trading.mapper.system;

import com.yuhang.trading.entity.system.Dictionary;
import com.yuhang.trading.entity.system.DictionaryItem;

import java.util.List;

/**
 * Description:
 *
 * @author David
 * @Date 2/28/2024 1:54 AM
 */
public interface DictionaryItemMapper {

    public List<DictionaryItem> selectAll();

    public DictionaryItem selectById(int id);

    public void insert(DictionaryItem dictionaryItem);
}
