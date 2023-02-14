## BeanUtils

BeanUtils的作者是Struts的创始人Craig McClanahan.

在Spring和Struts都有使用,最常用的功能就是Bean Copy,也就是copy bean的属性。如果做分层架构开发的话就会用到，比如从PO（Persistent Object）拷贝数据到VO（Value Object）。

目的是为了简化数据封装.

注意事项:
* 被封装的JavaBean必须是标准的Java类
* 该JavaBean必须被public所修饰
* 必须提供空构造器
* 成员变量必须私有化，被private所修饰
* 提供公共的setter和getter方法

### 常用功能

1. 根据Map快速填充Pojo.[示例](Populate.java)