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

import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.ext.IDataSourceExt;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author chenfu
 */
public abstract class AbstractRuleProvider<T> implements DynamicRuleProvider<List<T>> {

    @Autowired
    private IDataSourceExt ruleDataSourceExt;

    private Converter<String, List<T>> ruleEntityDecoder;

    @Override
    public List<T> getRules(String appName) throws Exception {
        String dataId = getDataId(appName);

        String rules = ruleDataSourceExt.get(dataId);
        if (StringUtil.isEmpty(rules)) {
            return new ArrayList<>();
        }
        return ruleEntityDecoder.convert(rules);
    }

    public void setRuleEntityDecoder(Converter<String, List<T>> ruleEntityDecoder) {
        this.ruleEntityDecoder = ruleEntityDecoder;
    }

    protected abstract String getDataId(String appName);
}
