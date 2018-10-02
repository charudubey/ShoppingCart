package com.yash.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.yash.model.Customer;
import com.yash.service.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTests {

	@Autowired 
	private MockMvc mockMvc;
	
	@MockBean
	CustomerServiceImpl customerServicesImpl;
	

 String exampleCourseJson = "{\"customerId\":\"1\",\"customerName\":\"charu\",\"address\":\"pune\",\"contactNumber\":\"9876543210\"}";

	@Test
	public void shouldReturnCustomerAndHTTPStatusOKifAvailableWhenPassCustomerId() throws Exception {
		
		Customer mockCustomer = new Customer(1,"charu", "pune", 9876543210l);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/customers/1").accept(
				MediaType.APPLICATION_JSON); 
		
		String expected = "{ customerId:1, customerName:charu, address:pune, contactNumber:9876543210 }";
		
		when(customerServicesImpl.getCustomer(anyInt())).thenReturn(mockCustomer);
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
		assertEquals(new Integer(HttpStatus.OK.value()), new Integer( result.getResponse().getStatus())
				);
	
		System.out.println("getContentAsString: "+result.getResponse().getContentAsString());
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
	}
	
/*	@Test
	public void shouldNotReturnCustomerAndHTTPStatusNOCONTENTifAvailableWhenPassCustomerId() throws Exception {

		
		Customer mockCustomer = new Customer(1,"vishal", "k", "pune");
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/customers/1").accept(
				MediaType.APPLICATION_JSON);
		
		String expected = "{ customerId:1, firstName:vishal, lastName:k,  city:pune }";
		
		when(customerServicesImpl.getCustomer(anyInt())).thenReturn(mockCustomer);
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
		assertEquals(new Integer(HttpStatus.OK.value()), new Integer( result.getResponse().getStatus())
				);//.getContentAsString(), false
	
		System.out.println("getContentAsString: "+result.getResponse().getContentAsString());
		
		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		JSONAssert.assertNotEquals(expected, result.getResponse().getContentAsString(), false);
	
	}
	
	@Test
	public void shouldAddCustomerWhenAppropriateDataPassed() throws Exception {
		
		Customer mockCustomer = new Customer(1,"vishal", "k", "pune");

		//when(customerServicesImpl.addCustomer(any(Customer.class))).thenReturn(mockCustomer);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customers").accept(MediaType.APPLICATION_JSON).content(exampleCourseJson).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());

		MockHttpServletResponse  httpResponse = result.getResponse(); 
		
		assertEquals(HttpStatus.CREATED.value(), httpResponse.getStatus());
		
		assertEquals("http://localhost/customers/1",
				httpResponse.getHeader(HttpHeaders.LOCATION));
											
	}
	
	@Test// validation Layer
	public void shouldNotAddCustomerAndReturnBadRequestWhenAppropriateDataNotPassed() {
		
	}
	
	@Test // exception Should handled : ControllerAdvice 
	public void shouldNotAddCustomerWhenAlreadyExist() {
		
	}
	
	@Test
	public void shouldDeleteCustomerWhenCustomerIdPassed() throws Exception {
		

		Customer mockCustomer = new Customer(1,"vishal", "k", "pune");
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("http://localhost/customers/1").accept(MediaType.APPLICATION_JSON);

	//	when(customerServicesImpl.removeCustomer(anyInt())).thenReturn(mockCustomer);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());

		MockHttpServletResponse  httpResponse = result.getResponse(); 
		
		assertEquals(HttpStatus.OK.value(), httpResponse.getStatus());

	}
	
	@Test
	public void shouldReturnNOTFOUNDWhenPassedCustomerIdNotAvailable() throws Exception {
	Customer mockCustomer = new Customer(1,"vishal", "k", "pune");
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("http://localhost/customers/2").accept(MediaType.APPLICATION_JSON);

		//when(customerServicesImpl.removeCustomer(anyInt())).thenReturn(mockCustomer);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());

		MockHttpServletResponse  httpResponse = result.getResponse(); 
		
		assertEquals(HttpStatus.NO_CONTENT.value(), httpResponse.getStatus());

	}*/

}
