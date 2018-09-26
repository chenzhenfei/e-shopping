-- e-shopping-member : member 接口实现管理层，具体会员服务的逻辑实现# e-shopping
分布式微服务构建电商系统

微服务项目系统结构分层：采用模块化项目构建方式

---e-shopping-parent : 项目的公共的依赖工程，作为parent 工程创建，
                       提供子模块的继承依赖，引入公共的spring cloud ,spring boot jar 等依赖，
                       打包方式为pom
   -- e-shopping-eureka : spring cloud 服务注册中心子模块，提供微服务注册中心
   -- e-shopping-common : 公共工具类，提供其他模块的公共工具类调用，
                          继承一下共同的配置工具类，例如 redis 配置工具类等
   -- e-shopping-api : 公共的对外接口依赖层，pom,针对服务对外接口层的公共依赖管理
      -- e-shopping-api-member : member服务对外接口定义层
      -- e-shopping-api-order  : order 服务对外接口定义层
   -- e-shopping-member : member 接口实现管理层，具体会员服务的逻辑实现
   -- e-shopping-order : order 接口实现管理层，具体订单服务的逻辑实现
        
