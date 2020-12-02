package com.alibaba.csp.sentinel.dashboard.rule.nacos.provider;


import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
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
@Component("systemRuleNacosProvider")
public class SystemRuleNacosProvider extends AbstractRuleNacosProvider<SystemRuleEntity> implements InitializingBean {

    @Autowired
    private Converter<String, List<SystemRuleEntity>> ruleEntityDecoder;

    @Override
    protected String getDataId(String appName) {
        return appName + NacosConfigUtil.SYSTEM_DATA_ID_POSTFIX;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRuleEntityDecoder(ruleEntityDecoder);
    }
}
