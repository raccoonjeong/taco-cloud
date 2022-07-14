package tacos;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomeController.class) 
// 스프링 부트에서 제공하는 특별한 애노테이션. 
// 스프링 MVC 애플리케이션의 형태로 테스트가 실행되도록 한다.
// 또한 스프링 지원을 설정함.
public class HomeControllerTest {
	@Autowired
	private MockMvc mockMvc;
	// 실제 서버를 시작하는 대신 모의 매커니즘을 사용한다.
	
	@Test
	public void testHomePage() throws Exception {
		mockMvc.perform(get("/"))
		.andExpect(status().isOk()) // 응답은 반드시 HTTP 200이어야.
		.andExpect(view().name("home")) // 뷰의 이름은 반드시 home이어야.
		.andExpect(content().string(
				containsString("Welcome to..."))); // 뷰에는 이 텍스트가 포함되어야.
	}
}