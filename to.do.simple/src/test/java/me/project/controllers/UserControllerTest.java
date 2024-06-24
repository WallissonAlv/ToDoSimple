package me.project.controllers;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import me.project.models.User;
import me.project.services.UserService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	@MockBean
	private UserService userService;
	@Autowired
	private MockMvc mockMvc;
	
	// TESTS SUCESS ---------------------------------------
	@Test
	public void testFindAllUsersSucess() throws Exception{
		// Step 1 : Arrange
		//User user1 = new User(1L, "Wallisson", "Estoque");
		//User user2 = new User(2L, "Wesley", "Vendas");

		// Step 2 : Act
		//Mockito.when(userService.findAllUsers()).thenReturn(Arrays.asList(user1, user2));
		
		// Step 3 : Assert
		mockMvc.perform(get("/users"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].name").value("Wallisson"))
			.andExpect(jsonPath("$[0].sector").value("Estoque"))
			.andExpect(jsonPath("$[1].name").value("Wesley"))
			.andExpect(jsonPath("$[1].sector").value("Vendas"));
								
	}
	
	@Test
	public void testFindUserByIdSucess() throws Exception{
		
		// Step 1 : Arrange
		// User user1 = new User(1L, "Wallisson", "Estoque");

		// Step 2 : Act
		//given(userService.findUserById(1L)).willReturn(user1);
		
		// Step 3 : Assert
		mockMvc.perform(get("/users/1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value(1L))
			.andExpect(jsonPath("$.name").value("Wallisson"))
			.andExpect(jsonPath("$.sector").value("Estoque"));
	}

	// TESTS FAILURE --------------------------------------
	
}


