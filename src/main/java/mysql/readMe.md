1.数据库表设计
范式一：每张表必须包含主键
范式二：
范式三：
2.SQL优化注意事项
多表关联时使用小表驱动大表 因为第二张表开始过滤走索引
左关联 on条件后需要加索引
内关联 on条件前后都需要加索引
where条件后面字段可以添加索引