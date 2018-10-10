# spring boot 占位符问题

分析下Bean定义，可以发现`MapperScannerConfigurer`实现了`BeanDefinitionRegistryPostProcessor`。
这个接口在是Spring**扫描Bean定义时会回调的，远早于BeanFactoryPostProcessor**。

所以原因是：

1. `MapperScannerConfigurer`实现了`BeanDefinitionRegistryPostProcessor`，所以它会Spring的早期会被创建
2. 从bean的依赖关系来看，`MapperScannerConfigurer`依赖了`sqlSessionFactory`，`sqlSessionFactory`依赖了`dataSource`
`DBConfig`里的`dataSource`被**提前初始化**，没有经过`PropertySourcesPlaceholderConfigurer`的处理，
所以`@Value(“${db.user}”) String user` 里的占位符没有被处理。


TODO:

- [ ] mybatis-spring-boot-starter 怎么实现的包扫描，不需要使用MapperScannerConfigurer？它是怎么用的？
