package com.alibaba.csp.sentinel.dashboard.rule.nacos.provider;


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
@Component("authorityRuleNacosProvider")
public class AuthorityRuleNacosProvider extends AbstractRuleNacosProvider<AuthorityRuleEntity> implements InitializingBean {

    @Autowired
    private Converter<String, List<AuthorityRuleEntity>> ruleEntityDecoder;

    @Override
    protected String getDataId(String appName) {
        return appName + NacosConfigUtil.AUTHORITY_DATA_ID_POSTFIX;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRuleEntityDecoder(ruleEntityDecoder);
    }
}
