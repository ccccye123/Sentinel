package com.alibaba.csp.sentinel.dashboard.rule.nacos.provider;


import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.datasource.Converter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chenfu
 */
@Component("degradeRuleNacosProvider")
public class DegradeRuleNacosProvider extends AbstractRuleNacosProvider<DegradeRuleEntity> implements InitializingBean {

    @Autowired
    private Converter<String, List<DegradeRuleEntity>> degradeRuleEntityDecoder;

    @Override
    protected String getDataId(String appName) {
        return appName + NacosConfigUtil.DEGRADE_DATA_ID_POSTFIX;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRuleEntityDecoder(degradeRuleEntityDecoder);
    }
}
