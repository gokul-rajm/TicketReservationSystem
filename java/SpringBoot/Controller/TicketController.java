package SpringBoot.Controller;
/*
 * This is an Controller class
 */

import java.util.List;

import javax.validation.Valid;
import javax.xml.ws.Response;

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

import SpringBoot.Entity.TicketEntity;
import SpringBoot.Service.TicketService;


@RestController
@RequestMapping("/HappyJourney")
public class TicketController {
    
    @Autowired // @Autowired is used to autowire the Controller and Service Class
    TicketService ticketservice;
      
    // @PostMapping is used to control the post method in service class
    @PostMapping("/TicketReserves")
    public ResponseEntity<Object> ticketentity(@Valid @RequestBody TicketEntity ticketEntity) {
    	ticketservice.save(ticketEntity);
        return new ResponseEntity<Object>("Created Successfully",HttpStatus.CREATED);
    }
    
    // @GetMapping is used to get the All stored entities in DB
    @GetMapping("/TicketReserves")
    public List<TicketEntity> getAllticketentity(){
        return ticketservice.getAllticketentity();
    }
    
    // @GetMapping is used to get the entity by Id
    @GetMapping("/TicketReserves/{id}")
    public TicketEntity getticketEntity(@PathVariable("id") int id) {
        return ticketservice.getticketentityById(id);
    }
    
    // @PutMapping is used to Update the entity by TicketNumber
    @PutMapping("/TicketReserves/{TicketNumber}")
   public ResponseEntity<Object>update(@PathVariable int TicketNumber , @RequestBody TicketEntity ticketentity) {
        ticketservice.update(TicketNumber , ticketentity);
        return new ResponseEntity<Object>("\nUpdated Successfully",HttpStatus.OK);
    }
   
    // @DeleteMapping is used to Delete the entity by TicketNumber
    @DeleteMapping("/TicketReserves/{TicketNumber}")
    public ResponseEntity<Object>  deleteTicketEntity(@PathVariable("TicketNumber") int TicketNumber) {
        ticketservice.DeleteByTicketNumber(TicketNumber);
    	return new ResponseEntity<Object>("\nDeleted Successfully",HttpStatus.OK);
    }
    
    
}