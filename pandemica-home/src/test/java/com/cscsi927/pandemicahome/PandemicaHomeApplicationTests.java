package com.cscsi927.pandemicahome;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PandemicaHomeApplicationTests {

    @Test
    void contextLoads() {
        AutoGenerator autoGenerator = new AutoGenerator();

        //Global Configuration
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("sure")
                .setOutputDir("E:\\idea-workspaces\\Pandemica-project\\pandemica-reverse-engneering")
                .setFileOverride(true)//Setting file overwrite
                .setIdType(IdType.AUTO)//Set the primary key generation policy
                .setServiceName("%sService")//set name for service interface
                .setBaseResultMap(true)//Set of basic results
                .setBaseColumnList(true)//Set the basic columns
                .setControllerName("%sController");


        // Configure Data Source
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://aws-ap-southeast-2.connect.psdb.cloud/csci927service?sslMode=VERIFY_IDENTITY")
                .setUsername("rkl8nbvvcjtdnuo6jgkg")
                .setPassword("pscale_pw_iZcxm1daSbfDZLDjmlwTywA5orxqK6FyAu9tcLnP4DA");

        //policy mechanisms
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)//Set global uppercase naming
                .setNaming(NamingStrategy.underline_to_camel)//Naming policies for mapping database tables to entities
//                .setTablePrefix("tbl_")//Set the prefix of a table name
                .setInclude();

        //The package name configuration
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.csci927.pandemicabootdemo")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("bean")
                .setXml("mapper");

        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        autoGenerator.execute();
    }

}
