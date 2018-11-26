package com.writer0713;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestTemplateTest {

  private RestTemplate restTemplate;

  private Unmarshaller unmarshaller;

  @Before
  public void init() {
    this.restTemplate = new RestTemplate();
  }

  @Test
  public void getRSS() throws URISyntaxException {
    URI uri = new URI("https://rss.blog.naver.com/writer0713.xml");
    Rss responseString = restTemplate.getForObject(uri, Rss.class);

    System.out.println(responseString);




  }
}

@XmlRootElement(name = "rss")
class Rss {

  @XmlElement(name = "channel")
  private Blog blog;

  @Override
  public String toString() {
    return "Rss{" +
            "blog=" + blog +
            '}';
  }
}

class Blog {

  private String title;
  private String link;
  private Image image;
  private String description;
  private String language;
  private String generator;
  private Date pubDate;

  @XmlElementWrapper(name = "items")
  @XmlElement(name = "item")
  private List<Item> items = new ArrayList<>();

  private Item item;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getGenerator() {
    return generator;
  }

  public void setGenerator(String generator) {
    this.generator = generator;
  }

  public Date getPubDate() {
    return pubDate;
  }

  public void setPubDate(Date pubDate) {
    this.pubDate = pubDate;
  }

//  public List<Item> getItems() {
//    return items;
//  }
//
//  public void setItems(List<Item> items) {
//    this.items = items;
//  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.items.add(item);
  }

  @Override
  public String toString() {
    return "Blog{" +
            "title='" + title + '\'' +
            ", link='" + link + '\'' +
            ", image=" + image +
            ", description='" + description + '\'' +
            ", language='" + language + '\'' +
            ", generator='" + generator + '\'' +
            ", pubDate=" + pubDate +
            ", items=" + items +
            ", item=" + item +
            '}';
  }
}

class Image {
  private String url;
  private String title;
  private String link;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  @Override
  public String toString() {
    return "Image{" +
            "url='" + url + '\'' +
            ", title='" + title + '\'' +
            ", link='" + link + '\'' +
            '}';
  }
}

@XmlRootElement(name = "item")
class Item {
  private String author;
  private String category;
  private String title;
  private String link;
  private String guid;
  private String description;
  private Date pubDate;
  private String tag;

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getPubDate() {
    return pubDate;
  }

  public void setPubDate(Date pubDate) {
    this.pubDate = pubDate;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  @Override
  public String toString() {
    return "Item{" +
            "author='" + author + '\'' +
            ", category='" + category + '\'' +
            ", title='" + title + '\'' +
            ", link='" + link + '\'' +
            ", guid='" + guid + '\'' +
            ", description='" + description + '\'' +
            ", pubDate=" + pubDate +
            ", tag='" + tag + '\'' +
            '}';
  }
}