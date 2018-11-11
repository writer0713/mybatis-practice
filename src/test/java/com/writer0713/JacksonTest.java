package com.writer0713;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonTest {


  @Test
  public void getJSONTest() throws JsonProcessingException {

    Person person = new Person();
    person.setName("kim");

    person.setStock("samsung", 3000);
    person.setStock("apple", 2000);

    // items
//    person.setItems(new Item("iceCream", "2000"));
//    person.setItems(new Item("bread", "3000"));


    // alpha
//    Item item = new Item("hoy", "1000");
//    String jsonValue = new ObjectMapper().writeValueAsString(item);
//
//    person.setAlpha(jsonValue);

    ObjectMapper mapper = new ObjectMapper();
//    mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    String result = mapper.writeValueAsString(person);

    System.out.println(result);

  }

  @Test
  public void useEnum() throws JsonProcessingException {

    String result = new ObjectMapper().writeValueAsString(TypeEnumWithValue.TYPE1);

    System.out.println(result);

  }

  @Test
  public void deserializeTest() throws IOException {

    ObjectMapper mapper = new ObjectMapper();
    Person person = mapper.readerFor(Person.class).readValue("{\"username\":\"kim\",\"items\":[],\"alpha\":null,\"hobby\":null,\"job\":null,\"apple\":2000,\"samsung\":3000}");

    System.out.println(person.getName());
    System.out.println(person.getStock());
    System.out.println(person.getItems().size());

  }

}

enum TypeEnumWithValue {
  TYPE1(1, "Type A"),
  TYPE2(2, "Type B");

  private Integer id;
  private String name;

  TypeEnumWithValue(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

//  @JsonValue
  public String getName() {
    return name;
  }
}

@JsonRootName("person")
@JsonPropertyOrder(value = {"username", "stock", "items"}, alphabetic = true)
class Person {

  private String name;

  private String hobby;

  private String job;

  @JsonRawValue
  private String alpha;

  private List<Item> items = new ArrayList<>();

  private Map<String, Integer> stock = new HashMap<>();


  @JsonGetter("username")
  public String getName() {
    return name;
  }

  @JsonSetter("username")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("items")
  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public String getHobby() {
    return hobby;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getAlpha() {
    return alpha;
  }

  public void setAlpha(String alpha) {
    this.alpha = alpha;
  }

  @JsonAnyGetter
  public Map<String, Integer> getStock() {
    return stock;
  }

  @JsonAnySetter
  public void setStock(String key, Integer price) {
    this.stock.put(key, price);
  }
}

class Item {

  private String name;
  private String price;

  public Item() {
  }

  public Item(String name, String price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }
}