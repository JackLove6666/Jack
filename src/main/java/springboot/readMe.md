1.Bean注入方式
@Configration+@Bean组合
@Component
2.装配第三方Bean
在资源目录下新建目录 META-INF
在 META-INF 目录下新建文件 spring.factories
在文件中添加 org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.jincou.third.config.BeanConfig