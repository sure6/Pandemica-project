package com.csci927.pandemicabootdemo.service.impl;

import com.csci927.pandemicabootdemo.bean.JSONResult;
import com.csci927.pandemicabootdemo.bean.UserAccount;
import com.csci927.pandemicabootdemo.mapper.UserAccountMapper;
import com.csci927.pandemicabootdemo.service.UserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
@Service
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
    public JSONResult doLogin(String username, String password, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
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
        System.out.println(userAccount);
        // 将登录用户信息保存到session中
        session.setAttribute("user_session", userAccount);
        // 保存cookie，实现自动登录
        Cookie cookie_username = new Cookie("cookie_username", username);
        // 设置cookie的持久化时间，30天
        cookie_username.setMaxAge(30 * 24 * 60 * 60);
        // 设置为当前项目下都携带这个cookie

        cookie_username.setPath("/");
        // 向客户端发送cookie
        response.addCookie(cookie_username);
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
