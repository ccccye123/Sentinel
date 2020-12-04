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

import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;

/**
 * @author chenfu
 */
public class DataSourceNacosExt implements IDataSourceExt, InitializingBean {

    @Value("${sentinel.rule.ext.nacos.groupid:SENTINEL_GROUP}")
    private String groupId;
    @Value("${sentinel.rule.ext.nacos.timeout:3000}")
    private Long timeout;
    @Value("${sentinel.rule.ext.nacos.host:127.0.0.1}")
    private String host;
    @Value("${sentinel.rule.ext.nacos.port:8848}")
    private Long port;

    private ConfigService configService;

    @Override
    public String get(String dataId) throws NacosException {
        return configService.getConfig(dataId, groupId, timeout);
    }

    @Override
    public boolean set(String dataId, String content) throws NacosException {
        return configService.publishConfig(dataId, groupId, content);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String serverAddr = String.format("%s:%s", host, port);
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
        configService = ConfigFactory.createConfigService(properties);
    }
}
