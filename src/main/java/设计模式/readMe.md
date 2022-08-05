1.策略模式
一个方法接口、多个策略多个实现类、一个实现类工厂(枚举、switch case&if)
例如：物流调拨模块-调拨单类型

海外仓、西邮仓出库委托单管理
仓库服务商初始化注册
ServiceProviderRegister implements InitializingBean, ApplicationContextAware

BaseServiceProvider baseServiceProvider = getbaseServiceProvider(String name)

BaseServiceProvider 接口
BaseServiceProviderImpl 实现类 规范不实现交由子类实现

ServiceProvider
FpxServiceProviderImpl 子类
XiyouServiceProviderImpl 子类
FpxOutboundService 实现类

2.单例模式
3.工厂模式
4.代理模式
5.
