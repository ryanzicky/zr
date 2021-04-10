package com.web.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @Author zhourui
 * @Date 2020/5/8 19:07
 */
public class Generator {

    /**
     * 测试 run 执行
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("D://MyProject//zr//web//src//main//java");
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setOpen(true);
        gc.setAuthor("zhourui");
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
//        gc.setEntitySuffix("%sDAO");
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        /**
         * mysql连接
         */
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://47.105.171.231:3306/db1?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=UTC&allowMultiQueries=true");
        mpg.setDataSource(dsc);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //        strategy.setTablePrefix("app_");// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setInclude("t_user", "t_menu", "t_permission", "t_permission_menu", "t_role", "t_role_permission", "t_user_role"); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        //        strategy.setSuperEntityClass("top.ibase4j.core.base.BaseModel");
        // 自定义实体，公共字段
        //        strategy.setSuperEntityColumns(
        //                new String[] { "id_", "enable_", "remark_", "create_by", "create_time", "update_by", "update_time" });
        // 自定义 mapper 父类
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.mapper.BaseMapper");
        // 自定义 service 父类(生成后请把Service的父类删除)
        strategy.setSuperServiceClass("com.baomidou.mybatisplus.service.IService");
        // 自定义 service 实现类父类
        strategy.setSuperServiceImplClass("com.baomidou.mybatisplus.service.impl.ServiceImpl");
        // 自定义 controller 父类
//        strategy.setSuperControllerClass("com.tuhu.springcloud.common.controller.BaseController");
        //生成 <code>@RestController</code> 控制器
        strategy.setRestControllerStyle(true);
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(true);
        //        strategy.setLogicDeleteFieldName("enable");
        //【实体】是否为lombok模型（默认 false）
//        strategy.setEntityLombokModel(true);
        mpg.setStrategy(strategy);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.web");
        pc.setEntity("generator.dao");
        pc.setMapper("generator.mapper");
        pc.setXml("mapper");
        pc.setService("generator.service");
        pc.setServiceImpl("generator.service.impl");
//        pc.setController("controller");
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();
    }
}
