package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.pojo.Setmeal;
import com.obs.services.ObsClient;
import com.obs.services.model.ObjectMetadata;
import com.obs.services.model.PutObjectResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 体检套餐管理
 */
@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    //文件上传
    @RequestMapping("/upload")
    public Result upload(@RequestParam("imgFile") MultipartFile imgFile)  {
        String endPoint = "obs.cn-north-1.myhuaweicloud.com";
        String ak = "R2YOJVQHVACJQX027NOW";
        String sk = "LMg7vhKI0CiCi79kj3rIEYS0SZ76BdoXMgIr7sA1";
        String originalFilename = imgFile.getOriginalFilename();//获得原始文件名
        int index = originalFilename.lastIndexOf(".");
        String extention = originalFilename.substring(index - 1);//.jpg
        String fileName = UUID.randomUUID().toString() + extention;//随机分配一个字符串
        //创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);
        System.out.println(fileName);
        try {
            InputStream inputStream = imgFile.getInputStream();
            //将文件上传到华为云
            ObjectMetadata meta = new ObjectMetadata();
            PutObjectResult putObjectResult = obsClient.putObject("bucket02-144e",fileName, inputStream,meta);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.PIC_UPLOAD_FAIL);
        }
        return new Result(true,MessageConstant.PIC_UPLOAD_SUCCESS,fileName);
    }
    //新增套餐
    @RequestMapping("/add")
    public Result add(@RequestBody Setmeal setmeal, Integer[] checkgroupIds)  {
        return null;
    }
}
