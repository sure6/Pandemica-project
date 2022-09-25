package com.csci927.pandemicaregistration.sevice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csci927.pandemicaapi.bean.JSONResult;
import com.csci927.pandemicaapi.bean.UserAccount;
import com.csci927.pandemicaregistration.mapper.UserAccountMapper;
import com.csci927.pandemicaapi.service.UserAccountService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * <p>
 *  UserAccountService implementation class
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
@DubboService(interfaceClass = UserAccountService.class, version = "1.0.1",timeout = 60000)
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public Boolean modifyPassword(String username, String password) {
        return userAccountMapper.updatePassword(username.trim(),getSHA256StrJava(password.trim()))>0;
    }

    @Override
    public Integer addUserAccount(UserAccount userAccount) throws Exception {
        if (StringUtils.isEmpty(userAccount.getUsername()) && StringUtils.isEmpty(userAccount.getPassword())) {
            throw new Exception("username and password is not null");
        }
        userAccount.setPassword(getSHA256StrJava(userAccount.getPassword()));
        return userAccountMapper.insertUserAccount(userAccount);
    }

    @Override
    public Boolean selectUserAccount(String username, String password) {
        List<UserAccount> userAccounts = userAccountMapper.selectByUsernameAndPassword(username.trim(),getSHA256StrJava(password.trim()));
        System.out.println(userAccounts.size());
        return  userAccounts.size() > 0 ;
    }

    @Override
    public UserAccount getUserInfoByAccount(String username) {
        if(StringUtils.isEmpty(username)){
            return null;
        }
        return userAccountMapper.selectUserInfoByAccount(username);
    }

    @Override
    public JSONResult doLogin(String username, String password) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setStateValue("false");
        UserAccount userAccount = userAccountMapper.selectUserInfoByAccount(username);
        // verify if account is exist
        if(null == userAccount){
            jsonResult.setReturnInfo("This account does not exist, please check and try again");
            return jsonResult;
        }
        // verify if password is correct
        if(!getSHA256StrJava(password).equals(userAccount.getPassword())){
            jsonResult.setReturnInfo("The username or password is incorrect. Please check and try again");
            return jsonResult;
        }

        jsonResult.setStateValue("true");
        jsonResult.setReturnInfo("login successfully");
        return jsonResult;
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

}
