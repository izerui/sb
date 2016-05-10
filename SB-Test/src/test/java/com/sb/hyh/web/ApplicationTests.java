package com.sb.hyh.web;

import static org.hamcrest.Matchers.equalTo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ApplicationTests {
	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new HelloController(), new UserController()).build();
	}

	@Test
	public void testHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(equalTo("Hello Spring-Boot")));
	}

	@Test
	public void testUserController() throws Exception {
		RequestBuilder request = null;

		// get查一下user列表，应该为空
		request = MockMvcRequestBuilders.get("/users/");
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(equalTo("[]")));

		// post提交一个user
		request = MockMvcRequestBuilders.post("/users/").param("id", "1").param("name", "测试大师").param("age", "20");
		mvc.perform(request)
				// .andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.content().string(equalTo("success")));

		// get获取user列表，应该有刚才插入的数据
		request = MockMvcRequestBuilders.get("/users/");
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(
				MockMvcResultMatchers.content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));

		// put修改id为1的user
		request = MockMvcRequestBuilders.put("/users/1").param("name", "测试终极大师").param("age", "30");
		mvc.perform(request).andExpect(MockMvcResultMatchers.content().string(equalTo("success")));

		// get一个id为1的user
		request = MockMvcRequestBuilders.get("/users/1");
		mvc.perform(request).andExpect(
				MockMvcResultMatchers.content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));

		// del删除id为1的user
		request = MockMvcRequestBuilders.delete("/users/1");
		mvc.perform(request).andExpect(MockMvcResultMatchers.content().string(equalTo("success")));

		// get查一下user列表，应该为空
		request = MockMvcRequestBuilders.get("/users/");
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(equalTo("[]")));
	}
}
