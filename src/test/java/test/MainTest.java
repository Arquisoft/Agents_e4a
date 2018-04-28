package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import asw.Application;
import asw.agents.webService.CsvReader;
import asw.dbManagement.impl.GetAgentImpl;
import asw.dbManagement.model.Agent;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainTest {

	@Autowired
    private WebApplicationContext wac;
 
    private MockMvc mockMvc;
    
    @SuppressWarnings("rawtypes")
	private HttpMessageConverter mappingJackson2HttpMessageConverter;

//	private URL base;
//	private TestRestTemplate template;
    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    private MediaType JSONContentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

	@Autowired
	private GetAgentImpl getAgent;

	@Before
	public void setUp() throws Exception {
//		this.base = new URL("http://localhost:" + port + "/");
//		template = new TestRestTemplate();
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		Application.instancia=CsvReader.getInstance("src/main/resources/maestro.csv");

	}
	
	@Test
    public void T01getUserJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
		payload.put("login", "13864928P");
		payload.put("password", "123456");
		payload.put("kind", "Person");
             
		Agent a = getAgent.getAgent("13864928P");
        mockMvc.perform(post("/user")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$['email']", is(a.getEmail())));
    }
	
	@Test
    public void T02incorrectLoginJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
		payload.put("login", "13864928888888P");
		payload.put("password", "123456");
		payload.put("kind", "Person"); 
             
        mockMvc.perform(post("/user")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isNotFound());
    }
	
	@Test
    public void T03incorrectPasswordJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
		payload.put("login", "13864928P");
		payload.put("password", "1234566666666");
		payload.put("kind", "Person"); 
             
        mockMvc.perform(post("/user")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isNotFound());
    }
	
	@Test
    public void T04incorrectKindJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
		payload.put("login", "13864928P");
		payload.put("password", "123456");
		payload.put("kind", "Personnnnnnnn"); 
             
        mockMvc.perform(post("/user")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isNotFound());
    }
	
	@Test
    public void T05kindNotMatchsJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
		payload.put("login", "13864928P");
		payload.put("password", "123456");
		payload.put("kind", "Sensor"); 
             
        mockMvc.perform(post("/user")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isNotFound());
    }
	
	@Test
    public void T06changePasswordJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
		payload.put("login", "13864928P");
		payload.put("password", "123456");
		payload.put("newPassword", "654321"); 
             
		Agent a = getAgent.getAgent("13864928P");
		assertEquals(a.getPassword(), "123456");
        mockMvc.perform(post("/changePassword")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isOk());
        a = getAgent.getAgent("13864928P");
        assertEquals(a.getPassword(), "654321");
    }
	
	@Test
    public void T07incorectChangePasswordJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
		payload.put("login", "13864928P");
		payload.put("password", "654321");
		payload.put("newPassword", "654321"); 
             
		Agent a = getAgent.getAgent("13864928P");
		assertEquals(a.getPassword(), "654321");
        mockMvc.perform(post("/changePassword")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isNotFound());      
    }
	
	@Test
    public void T08incorectChangePasswordEmptyJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
		payload.put("login", "13864928P");
		payload.put("password", "654321");
		payload.put("newPassword", ""); 
             
		Agent a = getAgent.getAgent("13864928P");
		assertEquals(a.getPassword(), "654321");
        mockMvc.perform(post("/changePassword")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isNotFound());      
    }
	
	@Test
    public void T09changeEmailJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
        payload.put("login", "13864928P");
		payload.put("email", "paco@hotmail.com");
		payload.put("password", "654321");
		payload.put("newEmail", "pacoypaca@hotmail.com"); 
             
		Agent a = getAgent.getAgent("13864928P");
		assertEquals(a.getEmail(), "paco@hotmail.com");
        mockMvc.perform(post("/changeEmail")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isOk());
        a = getAgent.getAgent("13864928P");
        assertEquals(a.getEmail(), "pacoypaca@hotmail.com");
    }
	
	@Test
    public void T10incorrectChangeEmailRepeatedJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
        payload.put("login", "13864928P");
		payload.put("email", "pacoypaca@hotmail.com");
		payload.put("password", "654321");
		payload.put("newEmail", "pacoypaca@hotmail.com"); 
             
		Agent a = getAgent.getAgent("13864928P");
		assertEquals(a.getEmail(), "pacoypaca@hotmail.com");
        mockMvc.perform(post("/changeEmail")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isNotFound());
    }
	
	@Test
    public void T11incorrectChangeEmailJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
        payload.put("login", "13864928P");
		payload.put("email", "pacoypaca@hotmail.com");
		payload.put("password", "654321");
		payload.put("newEmail", "pacoypaca@"); 
             
		Agent a = getAgent.getAgent("13864928P");
		assertEquals(a.getEmail(), "pacoypaca@hotmail.com");
        mockMvc.perform(post("/changeEmail")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isNotFound());
    }
	
	@Test
    public void T12incorrectChangeEmailEmptyJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
        payload.put("login", "13864928P");
		payload.put("email", "pacoypaca@hotmail.com");
		payload.put("password", "654321");
		payload.put("newEmail", ""); 
             
		Agent a = getAgent.getAgent("13864928P");
		assertEquals(a.getEmail(), "pacoypaca@hotmail.com");
        mockMvc.perform(post("/changeEmail")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isNotFound());
    }
	
	@Test
    public void T13changeNombreJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
        payload.put("login", "13864928P");
		payload.put("nombre", "Paco Gómez");
		payload.put("password", "654321");
		payload.put("nuevoNombre", "Paca Fernanada"); 
             
		Agent a = getAgent.getAgent("13864928P");
		assertEquals(a.getNombre(), "Paco Gómez");
        mockMvc.perform(post("/changeNombre")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isOk());
        a = getAgent.getAgent("13864928P");
        assertEquals(a.getNombre(), "Paca Fernanada");
    }
	
	@Test
    public void T14incorrectChangeNombreJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
        payload.put("login", "13864928P");
		payload.put("nombre", "Paca Fernanada");
		payload.put("password", "654321");
		payload.put("nuevoNombre", "Paca Fernanada"); 
             
		Agent a = getAgent.getAgent("13864928P");
		assertEquals(a.getNombre(), "Paca Fernanada");
        mockMvc.perform(post("/changeNombre")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isNotFound());
    }
	
	@Test
    public void T15incorrectChangeNombreEmptyJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
        payload.put("login", "13864928P");
		payload.put("nombre", "Paca Fernanada");
		payload.put("password", "654321");
		payload.put("nuevoNombre", ""); 
             
		Agent a = getAgent.getAgent("13864928P");
		assertEquals(a.getNombre(), "Paca Fernanada");
        mockMvc.perform(post("/changeNombre")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isNotFound());
    }
	
	@Test
    public void T16changeLocalizacionJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
        payload.put("login", "13864928P");
		payload.put("localizacion", "-3.7339100,40.4416800");
		payload.put("password", "654321");
		payload.put("nuevaLocalizacion", "6.5859,7.7879"); 
             
		Agent a = getAgent.getAgent("13864928P");
		assertEquals(a.getLocalizacion(), "-3.7339100,40.4416800");
        mockMvc.perform(post("/changeLocalizacion")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isOk());
        a = getAgent.getAgent("13864928P");
        assertEquals(a.getLocalizacion(), "6.5859,7.7879");
    }
	
	@Test
    public void T17incorrectChangeLocalizacionNotCorrectJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
        payload.put("login", "13864928P");
		payload.put("localizacion", "-3.7339100,40.4416800");
		payload.put("password", "654321");
		payload.put("nuevaLocalizacion", ""); 
             
		Agent a = getAgent.getAgent("13864928P");
		assertEquals(a.getLocalizacion(), "6.5859,7.7879");
        mockMvc.perform(post("/changeLocalizacion")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isNotFound());
    }
	
	@Test
    public void T18changeLocalizacionCanBeEmptyJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
        payload.put("login", "13864928P");
		payload.put("localizacion", "6.5859,7.7879");
		payload.put("password", "654321");
		payload.put("nuevaLocalizacion", ""); 
             
		Agent a = getAgent.getAgent("13864928P");
		assertEquals(a.getLocalizacion(), "6.5859,7.7879");
        mockMvc.perform(post("/changeLocalizacion")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isOk());
        a = getAgent.getAgent("13864928P");
        assertEquals(a.getLocalizacion(), "");
    }
	
	@Test
    public void T19incorrectChangeLocalizacionNotValidJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
        payload.put("login", "13864928P");
		payload.put("localizacion", "");
		payload.put("password", "654321");
		payload.put("nuevaLocalizacion", "Oviedo"); 
             
		Agent a = getAgent.getAgent("13864928P");
		assertEquals(a.getLocalizacion(), "");
        mockMvc.perform(post("/changeLocalizacion")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isNotFound());
    }
	
	@Test
    public void T20incorrectChangeLocalizacionJSON() throws Exception {
        Map<String, String> payload = new HashMap<>();
        payload.put("login", "13864928P");
		payload.put("localizacion", "");
		payload.put("password", "654321");
		payload.put("nuevaLocalizacion", ""); 
             
		Agent a = getAgent.getAgent("13864928P");
		assertEquals(a.getLocalizacion(), "");
        mockMvc.perform(post("/changeLocalizacion")
                .content(this.json(payload))
                .contentType(JSONContentType))
                .andExpect(status().isNotFound());
    }

	@Test
	public void T1domainModelEqualsTest() {
		Agent participant1 = getAgent.getAgent("13864928P");
		assertFalse(participant1.equals(4));
		assertTrue(participant1.equals(participant1));
	}
	
	@Test
	public void T2domainModelToString() {
		Agent participant1 = getAgent.getAgent("13864928P");
		assertEquals(participant1.toString(),
				"Agent [id=" + participant1.getIdentificador() + ", nombre=" + participant1.getNombre()
						+ ", email=" + participant1.getEmail() + ", localizacion="
						+ participant1.getLocalizacion() + ", tipo=" + participant1.getKind() + ", type="
						+ participant1.getTipoCode() + ", password=" + participant1.getPassword() + "]");
	}


	@Test
	public void T3domainModelHashCodeTest() {
		Agent participant1 = getAgent.getAgent("13864928P");
		Agent participant3 = getAgent.getAgent("13864928P");
		assertEquals(participant1.hashCode(), participant3.hashCode());
	}

	
	/*
	@Test
	public void emailChangeCorrect() {
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		String userURI = base.toString() + "/changeEmail";
		
		String correctChange = "{\"participant\":\"pac@hotmail.com\",\"message\":\"email actualizado correctamente\"}";
		response = template.postForEntity(userURI, new PeticionChangeEmailREST("paco@hotmail.com", "123456", "pac@hotmail.com"),
				String.class);
		assertThat(response.getBody(), equalTo(correctChange));

		correctChange = "{\"participant\":\"pepe@hotmail.com\",\"message\":\"email actualizado correctamente\"}";
		response = template.postForEntity(userURI, new PeticionChangeEmailREST("pepe@gmail.com", "123456", "pepe@hotmail.com"),
				String.class);
		assertThat(response.getBody(), equalTo(correctChange));

		correctChange = "{\"participant\":\"fhfyg@hotmail.com\",\"message\":\"email actualizado correctamente\"}";
		response = template.postForEntity(userURI, new PeticionChangeEmailREST("carmen@yahoo.com", "123456", "fhfyg@hotmail.com"),
				String.class);
		assertThat(response.getBody(), equalTo(correctChange));
	}
	
	@Test
	public void correctPasswordChange() {
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		String userURI = base.toString() + "/changePassword";
		String correctPassword = "{\"participant\":\"isabel@gmail.com\",\"message\":\"contraseña actualizada correctamente\"}";

		response = template.postForEntity(userURI,
				new PeticionChangePasswordREST("isabel@gmail.com", "123456", "djfhr"), String.class);
		assertThat(response.getBody(), equalTo(correctPassword));
	}
	
	@Test
	public void correctPasswordChangeXML() {
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		String userURI = base.toString() + "/changePassword";
		String correctChange = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<ChangeInfoResponse><message>contraseÃ±a actualizada correctamente</message>"
				+ "<participant>isabel@gmail.com</participant></ChangeInfoResponse>";

		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new AcceptInterceptor());

		template.setInterceptors(interceptors);

		response = template.postForEntity(userURI,
				new PeticionChangePasswordREST("isabel@gmail.com", "djfhr", "123456"), String.class);
		assertThat(response.getBody(), equalTo(correctChange));
	}
	
	@Test
	public void emailChangeCorrectXML() {
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		String userURI = base.toString() + "/changeEmail";
		String correctChange = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<ChangeInfoResponse><message>email actualizado correctamente</message>"
				+ "<participant>carmen@yahoo.com</participant></ChangeInfoResponse>";

		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new AcceptInterceptor());

		template.setInterceptors(interceptors);

		response = template.postForEntity(userURI, new PeticionChangeEmailREST("fhfyg@hotmail.com", "123456", "carmen@yahoo.com"),
				String.class);
		assertThat(response.getBody(), equalTo(correctChange));
	}
	*/
	

	// Cabecera HTTP para pedir respuesta en XML
	/*public class AcceptInterceptor implements ClientHttpRequestInterceptor {
		@Override
		public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
				throws IOException {
			HttpHeaders headers = request.getHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
			return execution.execute(request, body);
		}
	}*/
	/**
     * Transforma un objeto en un string JSON
      * @param o objeto a convertir
     * @return string conteniendo el JSON
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
	private String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
