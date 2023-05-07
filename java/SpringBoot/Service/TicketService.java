package SpringBoot.Service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import SpringBoot.Entity.TicketEntity;
import SpringBoot.Repository.TicketRepository;


@Service  // @Service is used to declare the service Class
public class TicketService {
    
    @Autowired
    TicketRepository ticketRepository;
    
    public List<TicketEntity> getAllticketentity() {
    	return ticketRepository.findAll();
    }
 
	 public TicketEntity getticketentityById(int TicketNumber) 
	 {
		 return ticketRepository.findById(TicketNumber).get(); 
		}
	
    // This method is used to save(POST) the entities to the DB
    public TicketEntity save(TicketEntity ticket) {
        return ticketRepository.save(ticket);  
    }
    
    // This method is used to Update(PUT) the Entities in DB
    public TicketEntity update(int TicketNumber , TicketEntity ticketentity ) {
        
        TicketEntity updatedticketentity = new TicketEntity();
        updatedticketentity.setTicketId(ticketentity.getTicketId());
        updatedticketentity.setTicketNumber(ticketentity.getTicketNumber());
        updatedticketentity.setSourseStation(ticketentity.getSourseStation());
        updatedticketentity.setTicketPrice(ticketentity.getTicketPrice());
        updatedticketentity.setDestinationStation(ticketentity.getDestinationStation());
        ticketRepository.save(ticketentity);
        return ticketentity;
    }
    // This method is used to delete(DELETE) the entities from DB
    public void  DeleteByTicketNumber(int TicketNumber)   
    {  
    List<TicketEntity> ticket = new ArrayList<TicketEntity>();  
    ticket=ticketRepository.findAll();
    for(TicketEntity tickets:ticket)
    {
        if(tickets.getTicketNumber()==TicketNumber)
        {
            ticketRepository.delete(tickets);    

        }
    }
  }
}