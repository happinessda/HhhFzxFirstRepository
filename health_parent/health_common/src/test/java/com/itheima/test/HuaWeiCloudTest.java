package com.itheima.test;

import org.junit.Test;
import com.obs.services.ObsClient;

import java.io.File;

public class HuaWeiCloudTest {
    //使用华为云提供的SDK实现将本地图片上传到华为云服务器
    @Test
    public void test1(){
        String endPoint = "https://obs.cn-north-1.myhuaweicloud.com";
        String ak = "R2YOJVQHVACJQX027NOW";
        String sk = "LMg7vhKI0CiCi79kj3rIEYS0SZ76BdoXMgIr7sA1";
        //创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);
        //localfile为待上传的本地文件路径，需要指定到具体的文件名
        obsClient.putObject("itcasthealth-space-1","objectname",new File("C:\\Users\\kuangzhuaixiangge\\Desktop\\屏幕截图 2022-01-12 203910.png"));
        //obsClient.deleteObject("itcasthealth-space-1", "objectname");

    }
}
