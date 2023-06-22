package com.ust.book.Ctrlr;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.book.Model.Book;
import com.ust.book.Repo.BookRepo;

import antlr.collections.List;

@RestController
@RequestMapping("/book")
public class ProducerCtrlr {
	@Autowired
	BookRepo repo;
	
	//create 
	@PostMapping("/create")
	public ResponseEntity<?> createProduct(@RequestBody Book book){
		return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(book));}
	
	//retrieve by id
	@GetMapping("/get/{id}")
	  public ResponseEntity<?> retrieve(@PathVariable long id) {
	  Optional<Book>opt=repo.findById(id); 
	  if(opt.isPresent())
	    {
		  return ResponseEntity.ok().body(opt.get());
		  } 
	  else {
		  return ResponseEntity.noContent().build();
		  }
	  }
	 
		

	@GetMapping("/get/all")
	public ResponseEntity<?>fetchall(){
		return ResponseEntity.ok().body(repo.findAll());
		}
	//update

	@PutMapping("/update/{id}")
	public ResponseEntity<?>update(@PathVariable long id,@RequestBody Book book){
		Optional<Book>opt=repo.findById(id);
	    Book b=null;
	    if(opt.isPresent()) {
	    	b=opt.get();
	    	b.setId(book.getId());
	    	b.setBookname(book.getBookname());
	    	b.setPrice(book.getPrice());
	    	return ResponseEntity.ok().body(repo.save(b));
	    }
	    else {
	    	return null;
		}
	}

	//delete 
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>delete(@PathVariable long id ){
		Optional<Book>opt=repo.findById(id);
		if(opt.isPresent())
		{
		     repo.deleteById(id);
			return ResponseEntity.ok().body(null);
		}
		else
			return ResponseEntity.notFound().build();
			
				
				
		
	}
		
}
