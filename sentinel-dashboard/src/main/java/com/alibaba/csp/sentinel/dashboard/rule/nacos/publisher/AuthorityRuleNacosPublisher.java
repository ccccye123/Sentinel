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
package com.alibaba.csp.sentinel.dashboard.rule.nacos.publisher;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.datasource.Converter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chenfu
 */
@Component("authorityRuleNacosPublisher")
public class AuthorityRuleNacosPublisher extends AbstractRuleNacosPublicsher<AuthorityRuleEntity> implements InitializingBean {

    @Autowired
    private Converter<List<AuthorityRuleEntity>, String> ruleEntityEncoder;

    @Override
    protected String getDataId(String app) {
        return app + NacosConfigUtil.AUTHORITY_DATA_ID_POSTFIX;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRuleEntityEncoder(ruleEntityEncoder);
    }
}
