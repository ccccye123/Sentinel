package com.alibaba.csp.sentinel.dashboard.rule.nacos.provider;


import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.datasource.Converter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chenfu
 */
@Component("paramFlowRuleNacosProvider")
public class ParamFlowRuleNacosProvider extends AbstractRuleNacosProvider<ParamFlowRuleEntity> implements InitializingBean {

    @Autowired
    private Converter<String, List<ParamFlowRuleEntity>> ruleEntityDecoder;

    @Override
    protected String getDataId(String appName) {
        return appName + NacosConfigUtil.PARAM_FLOW_DATA_ID_POSTFIX;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRuleEntityDecoder(ruleEntityDecoder);
    }
}
