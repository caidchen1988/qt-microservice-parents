package com.qtbdp.provider.controller;

import com.qtbdp.provider.service.FastDFSClientWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: 浩
 * Date: 2017/4/13
 * Time: 22:58
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class FileUploadController {

    @Autowired
    private FastDFSClientWrapper dfsClient;

    // 上传图片
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam MultipartFile file, @RequestParam HttpServletRequest request, @RequestParam HttpServletResponse response) throws Exception {
        // 省略业务逻辑代码。。。
        // String imgUrl = dfsClient.uploadFile(file);
        // 。。。。
        return "http://static.youku.com/youku/dist/img/find/yk-logo-1220.png";

    }
}
