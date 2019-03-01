/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package designtelasfx;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
/**
 *
 * @author victor-sued
 */
public class restAPI {
  private String server = "https://api.magicthegathering.io/v1";
  private RestTemplate rest;
  private HttpHeaders headers;
  private HttpStatus status;

  public restAPI() {
    this.rest = new RestTemplate();
    this.headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    headers.add("Accept", "*/*");
    headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
  }

  public String get(String uri) {
    HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
    ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.GET, requestEntity, String.class);
    this.setStatus(responseEntity.getStatusCode());
    return responseEntity.getBody();
  }

  public String post(String uri, String json) {   
    HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
    ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.POST, requestEntity, String.class);
    this.setStatus(responseEntity.getStatusCode());
    return responseEntity.getBody();
  }
  
  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }     
    
}
