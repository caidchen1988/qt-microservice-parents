package com.qtdbp.feign.service;

import com.qtdbp.feign.service.impl.FileUploadClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: 浩
 * Date: 2017/4/13
 * Time: 23:21
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(value = "PRO-SERVICE", fallback = FileUploadClientHystrix.class)
public interface FileUploadClient {

    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    String upload(@RequestParam MultipartFile file, @RequestParam HttpServletRequest request, @RequestParam HttpServletResponse response) throws Exception ;
}
