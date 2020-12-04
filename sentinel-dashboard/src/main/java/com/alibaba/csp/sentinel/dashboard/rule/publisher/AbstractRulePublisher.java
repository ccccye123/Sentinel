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
package com.alibaba.csp.sentinel.dashboard.rule.publisher;

import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.ext.IDataSourceExt;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author chenfu
 */
public abstract class AbstractRulePublisher<T> implements DynamicRulePublisher<List<T>> {

    @Autowired
    private IDataSourceExt ruleDataSourceExt;

    private Converter<List<T>, String> ruleEntityEncoder;

    @Override
    public void publish(String app, List<T> rules) throws Exception {
        String dataId = getDataId(app);
        AssertUtil.notEmpty(app, "app name cannot be empty");
        String convert = ruleEntityEncoder.convert(rules);
        if (rules == null){
            return;
        }

        ruleDataSourceExt.set(dataId, convert);
    }

    public void setRuleEntityEncoder(Converter<List<T>, String> ruleEntityEncoder) {
        this.ruleEntityEncoder = ruleEntityEncoder;
    }

    protected abstract String getDataId(String app);
}
