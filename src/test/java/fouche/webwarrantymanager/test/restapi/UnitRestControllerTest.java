/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fouche.webwarrantymanager.test.restapi;

import com.fouche.webwarrantymanager.domain.Unit;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author foosh
 */
public class UnitRestControllerTest {
    private RestTemplate restTemplate = new RestTemplate();
    private final static String URL = "http://localhost:8084/fouche/";
    
   

    //@Test
    public void testCreate(){
        Unit unit =new Unit.Builder()
                .setPurchaseDate("08-07-1991")
                .setSn("123A323")
                .build();
        HttpEntity<Unit> requestEntity = new HttpEntity<>(unit, getContentType());
//        Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> responseEntity = restTemplate.
                exchange(URL+"api/unit/create", HttpMethod.POST, requestEntity, String.class);
        System.out.println(" THE RESPONSE BODY " + responseEntity.getBody());
        System.out.println(" THE RESPONSE STATUS CODE " + responseEntity.getStatusCode());
        System.out.println(" THE RESPONSE IS HEADERS " + responseEntity.getHeaders());
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }
    @Test
    public void testgetAllUnits() {
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Unit[]> responseEntity = restTemplate.exchange(URL + "api/unit/clubs", HttpMethod.GET, requestEntity, Unit[].class);
        Unit[] units = responseEntity.getBody();
        for (Unit unit : units) {
            System.out.println("The Unit serial number is " + unit.getSn());

        }

        Assert.assertTrue(units.length > 0);
    }
    
    private HttpEntity<?> getHttpEntity(){
         HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application","json")));
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return requestEntity;
    }
    
    private HttpHeaders getContentType() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;

    }
}
