/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.rule.ext;

import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author chenfu
 */
public class DataSourceRedisExt implements IDataSourceExt{

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public String get(String dataId) throws NacosException {
        return redisTemplate.opsForValue().get(dataId);
    }

    @Override
    public boolean set(String dataId, String content) throws NacosException {
        redisTemplate.opsForValue().set(dataId, content);
        redisTemplate.convertAndSend(dataId, content);
        return true;
    }
}
