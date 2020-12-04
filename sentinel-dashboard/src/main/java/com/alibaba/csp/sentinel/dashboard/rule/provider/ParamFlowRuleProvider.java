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
package com.alibaba.csp.sentinel.dashboard.rule.provider;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.RuleConfigUtil;
import com.alibaba.csp.sentinel.datasource.Converter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chenfu
 */
@Component("paramFlowRuleProvider")
public class ParamFlowRuleProvider extends AbstractRuleProvider<ParamFlowRuleEntity> implements InitializingBean {

    @Autowired
    private Converter<String, List<ParamFlowRuleEntity>> ruleEntityDecoder;

    @Override
    protected String getDataId(String appName) {
        return appName + RuleConfigUtil.PARAM_FLOW_DATA_ID_POSTFIX;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRuleEntityDecoder(ruleEntityDecoder);
    }
}
