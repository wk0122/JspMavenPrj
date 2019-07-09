package tech.aistar.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * 调用短信接口类
 * 大家需要修改的地方
 * 第20行 - key=https://www.juhe.cn/myData网站中的appKey
 * 第21行 - tpl_id=模板的ID
 *        - https://www.juhe.cn/sms
 */
public class SMSCode {
    //把手机号码和随机验证码传递过来
    public static boolean sendCode(String phoneNumber, String code) throws Exception {

        String str_code = URLEncoder.encode("#code#=" + code, "UTF-8");
        //包装好URL对象，将接口地址包装在此对象中
        URL url = new URL("http://v.juhe.cn/sms/send?mobile=" + phoneNumber +
                "&tpl_id=164756&tpl_value=" + str_code + "&key=26d7e59cf5f60b3624c427f67a27e70d");
                /* 短信模板id */                            /* 短信应用接口的key */
        //打开连接，得到连接对象
        URLConnection connection = url.openConnection();
        //向服务器发送连接请求
        connection.connect();
        //获得服务器响应的数据
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        StringBuffer buffer = new StringBuffer();
        String lineDate = null;
        while((lineDate = bufferedReader.readLine()) != null) {
            buffer.append(lineDate);
        }
        bufferedReader.close();
        if(buffer.toString().indexOf("\"error_code\":0")>=0 ) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            sendCode("18452502161","54321");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
