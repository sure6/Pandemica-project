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
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public JSONResult doLoginWithSession(String username, String password,Integer cookieTime, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
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
        // The login user information is saved to the session
        session.setAttribute("user_session", userAccount);
        // Save the cookie for automatic login
        Cookie cookie_username = new Cookie("cookie_username", username);
        // Set the cookie persistence period to cookie Time
        cookie_username.setMaxAge(cookieTime);
        // Set this cookie to be carried by all current projects
        cookie_username.setPath("/");
        // Sending a cookie to the client
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
