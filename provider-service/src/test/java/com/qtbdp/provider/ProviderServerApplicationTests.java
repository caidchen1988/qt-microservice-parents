package com.qtbdp.provider;

import com.qtbdp.provider.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created with IntelliJ IDEA.
 * User: ��
 * Date: 2017/4/9
 * Time: 21:39
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {ProviderServiceApplication.class,MockServletContext.class})
@WebAppConfiguration
public class ProviderServerApplicationTests {

   /* @Autowired
    private UserMapper userMapper ;

    @Test
    @Rollback
    public void findByName() {
        userMapper.insert("AAA", 20) ;
        User user = userMapper.findByName("AAA");

        Assert.assertEquals(20, user.getAge().intValue());
    }*/

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception {
        // ����UserController
        RequestBuilder request = null;

        // 1��get��һ��user�б�Ӧ��Ϊ��
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        // 2��post�ύһ��user
        request = post("/users/")
                .param("id", "1")
                .param("name", "���Դ�ʦ")
                .param("age", "20");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        // 3��get��ȡuser�б�Ӧ���иղŲ��������
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"���Դ�ʦ\",\"age\":20}]")));

        // 4��put�޸�idΪ1��user
        request = put("/users/1")
                .param("name", "�����ռ���ʦ")
                .param("age", "30");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 5��getһ��idΪ1��user
        request = get("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"�����ռ���ʦ\",\"age\":30}")));

        // 6��delɾ��idΪ1��user
        request = delete("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 7��get��һ��user�б�Ӧ��Ϊ��
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }
}
