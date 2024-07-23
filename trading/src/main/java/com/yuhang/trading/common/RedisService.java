package com.yuhang.trading.common;

import com.yuhang.service.entity.system.Dictionary;
import com.yuhang.service.entity.system.DictionaryItem;
import com.yuhang.service.mapper.system.DictionaryItemMapper;
import com.yuhang.service.mapper.system.DictionaryMapper;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Description:
 *
 * @author David
 * @Date 2/28/2024 1:46 AM
 */
@Component
public class RedisService {

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    DictionaryMapper dictionaryMapper;

    @Resource
    DictionaryItemMapper dictionaryItemMapper;

    public void initial() {
        List<Dictionary> dictionaries = dictionaryMapper.selectAll();
        List<DictionaryItem> dictionaryItems = dictionaryItemMapper.selectAll();
        Map<String, List<DictionaryItem>> map = new HashMap<>();
        dictionaries.forEach(dictionary -> {
            String dicId = dictionary.getId();
            List<DictionaryItem> itemList = dictionaryItems.stream().filter(item -> StringUtils.equals(dicId, item.getDictionaryId())).toList();
            map.put(dicId, itemList);
        });
        redisTemplate.opsForList().leftPushAll("dictionary", dictionaries);
        redisTemplate.opsForHash().putAll("dictionaryItem", map);
    }

    /**
     * To verify if there is the same value in Redis.
     * @param dictionaryName the dictionary name
     * @param param the value that should be compared with the value in Redis
     * */
    public boolean existRedisDictionaryItemValue(String dictionaryName, String param) {
        List<Dictionary> dictionaryList = redisTemplate.opsForList().range(Constants.DICTIONARY, 0, -1);
        if (null != dictionaryList) {
            Optional<Dictionary> professionOptional = dictionaryList.stream().filter(dictionary -> StringUtils.equals(dictionary.getName(), dictionaryName)).findFirst();
            if (professionOptional.isEmpty()) {
                return false;
            }
            Dictionary dictionary = professionOptional.get();
            String id = dictionary.getId();
            List<DictionaryItem> items = (List<DictionaryItem>) redisTemplate.opsForHash().get(Constants.DICTIONARY_ITEM, id);
            if (null == items) {
                return false;
            }
            return items.stream().anyMatch(dictionaryItem -> StringUtils.equals(param, dictionaryItem.getValue()));
        }
        return false;
    }
}
