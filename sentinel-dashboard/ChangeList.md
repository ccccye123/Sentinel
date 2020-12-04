# 参考博客
- nacos: https://gitee.com/luodea_admin/sentinel-dashboard/blob/master/README-Nacos.md
- redis: https://blog.csdn.net/qq_42714869/article/details/94553378

# 修改文件
1. FlowControllerV2，ruleProvider、rulePublisher改为nacos/redis
2. AuthorityRuleController，支持动态规则
3. DegradeController，支持动态规则
4. ParamFlowRuleController，支持动态规则
5. SystemController，支持动态规则
6. sidebar.html，流控规则默认页跳转至dashboard.flow
7. pom.xml，增加nacos-api、redis的依赖
8. application.properties，增加redis、Nacos的连接信息

# 增加文件
1. ChangeList.md，即本文件
2. AbstractRuleProvider，规则提供者抽象类
3. AuthorityRuleProvider，授权规则提供者
4. DegradeRuleProvider，降级规则提供者
5. FlowRuleProvider，流控规则提供者
6. ParamFlowRuleProvider，热点参数规则提供者
7. SystemRuleProvider，系统规则提供者
8. AbstractRulePublisher，规则推送者抽象类
9. AuthorityRulePublisher，授权规则推送者
10. DegradeRulePublisher，降级规则推送者
11. FlowRulePublisher，流控规则推送者
12. ParamFlowRulePublisher，热点参数规则推送者
13. SystemRulePublisher，系统规则推送者
14. RuleConfig，定义Converter，根据配置自动创建IDataSourceExt实例
15. RuleConfigUtil，定义常量
16. IDataSourceExt，规则数据源拓展接口
17. DataSourceNacosExt，Nacos数据源实现类
18. DataSourceRedisExt，Redis数据源实现类