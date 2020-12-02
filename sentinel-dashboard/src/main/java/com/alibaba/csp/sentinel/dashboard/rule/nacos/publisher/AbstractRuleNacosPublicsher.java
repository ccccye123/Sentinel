package com.alibaba.csp.sentinel.dashboard.rule.nacos.publisher;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author chenfu
 */
public abstract class AbstractRuleNacosPublicsher<T> implements DynamicRulePublisher<List<T>> {

    @Autowired
    private ConfigService configService;

    private Converter<List<T>, String> ruleEntityEncoder;

    @Override
    public void publish(String app, List<T> rules) throws Exception {
        String dataId = getDataId(app);
        AssertUtil.notEmpty(app, "app name cannot be empty");
        String convert = ruleEntityEncoder.convert(rules);
        if (rules == null){
            return;
        }

        configService.publishConfig(dataId, NacosConfigUtil.GROUP_ID, convert);
    }

    public void setRuleEntityEncoder(Converter<List<T>, String> ruleEntityEncoder) {
        this.ruleEntityEncoder = ruleEntityEncoder;
    }

    protected abstract String getDataId(String app);
}
