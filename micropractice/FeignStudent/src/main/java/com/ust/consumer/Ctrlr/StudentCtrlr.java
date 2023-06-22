package com.ust.consumer.Ctrlr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.consumer.interfaces.StudentIface;
import com.ust.consumer.model.Book;

@RestController
@RequestMapping("/consumer")
public class StudentCtrlr {
	@Autowired
	StudentIface stud;
	
	@GetMapping("/fetch/all")
	public List<Book> getAll(){
		return stud.getBooks();	
	}
	
	@GetMapping("/fetch/{id}")
	public Book getById(@PathVariable ("id") long id) {
		   System.out.println(id);
		   return stud.getBookByid(id);
	 }
	
//@PutMapping("/update/{id}")
//public ResponseEntity<List<Book>> getProductsById(@PathVariable("id") long id,@RequestBody Book book){
//	
//	return ResponseEntity.ok().body(stud.getBook(id));
//
//}

}
