package SpringBoot.Entity;
/**
 * This is an Entity class
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="Reservations")  //@Table is used to Create and Declare the table name

public class TicketEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) // @GeneratedValue is used to generate the values automatically
    private int TicketId;
    
	@NotEmpty(message="Name should have atleast 2 charcters")
    @Size(min=2)
    private String PassengerName;
    
    @NotEmpty(message="Email should not be empty")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String EmailId;
    
    @NotNull
    @Min(value=1000,message="Ticket Number must be greater than 1000")
    private int TicketNumber;
    
    @NotEmpty(message="Sourse Station should not be Empty")
    private String SourseStation;
    
    @NotEmpty(message="Destination Station should not be Empty")
    private String DestinationStation;
    
    @NotNull
    @Min(value=45, message="Ticket Price must be greater than 45")
    private int TicketPrice;
    
    //Getting the values using Getter and Setter
    public String getPassengerName() {
		return PassengerName;
	}
	public void setPassengerName(String passengerName) {
		PassengerName = passengerName;
	}
    public int getTicketPrice() {
		return TicketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		TicketPrice = ticketPrice;
	}
    public int getTicketId() {
		return TicketId;
	}
	public void setTicketId(int ticketId) {
		TicketId = ticketId;
	}
	public String getSourseStation() {
        return SourseStation;
    }
    public void setSourseStation(String SourseStation) {
        this.SourseStation = SourseStation;
    }
    public String getDestinationStation() {
        return DestinationStation;
    }
    public void setDestinationStation(String DestinationStation) {
        this.DestinationStation = DestinationStation;
    }
    public int getTicketNumber() {
        return TicketNumber;
    }
    public void setTicketNumber(int TicketNumber) {
        this.TicketNumber = TicketNumber;
    }
    public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	
}