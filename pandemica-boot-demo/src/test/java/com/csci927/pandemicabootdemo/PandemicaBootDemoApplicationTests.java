package com.csci927.pandemicabootdemo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.csci927.pandemicabootdemo.bean.User;
import com.csci927.pandemicabootdemo.bean.UserAccount;
import com.csci927.pandemicabootdemo.mapper.UserAccountMapper;
import com.csci927.pandemicabootdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@SpringBootTest
class PandemicaBootDemoApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private UserAccountMapper userAccountMapper;
    @Test
    void contextLoads() {
        List<User> users = userService.queryAllUser();
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    void TestUserAccountMapper(){
        List<UserAccount> userAccounts = userAccountMapper.selectByUsernameAndPassword("python1", getSHA256StrJava("qwe"));
        System.out.println(userAccounts.size());
    }

    @Test
    void TestTime(){
        long cookieCreatTime =  System.currentTimeMillis();
        long cookieExpireTime = cookieCreatTime+ 15*60*1000;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(sdf.format(new Date(cookieCreatTime)));
        System.out.println(sdf.format(new Date(cookieExpireTime)));
    }

    /**
     * Implement SHA256 encryption using Java native digest
     * @param str Encrypted packets
     * @return
     */
    public static String getSHA256StrJava(String str){
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }
    /**
     * Convert byte to hexadecimal
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i=0;i<bytes.length;i++){
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length()==1){
                //The one that gets one bit is added to 0
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    /**
     * mybatis reverse engineering
     */
    @Test
    void mybatisPlusGenerate() {
        AutoGenerator autoGenerator = new AutoGenerator();

        //Global Configuration
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("sure")
                .setOutputDir("E:\\idea-workspaces\\Pandemica-project\\pandemica-boot-demo\\src\\main\\java")//设置输出路径
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
