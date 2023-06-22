package com.ust.consumer.interfaces;
//consumer can get and may update the producers data
//endpoints of producer ctrlr
//can have different names and it is referred by autowiring in ctrlr and by endpoints pointing to bookctrlr
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ust.consumer.model.Book;

@FeignClient(name="book-service")
public interface StudentIface {
	
	@RequestMapping(method=RequestMethod.GET, value="/book/get/{id}",produces="application/json")
	public Book getBookByid(@PathVariable ("id") long id);
	
	@RequestMapping(method=RequestMethod.PUT, value="book/update/{id}", produces="application/json")
	public List<Book> getBook(@PathVariable ("id") long id);
	
	@RequestMapping(method=RequestMethod.GET, value="book/get/all")
	public List<Book> getBooks();
}
