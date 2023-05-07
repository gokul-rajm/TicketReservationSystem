package SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBoot.Entity.TicketEntity;


@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {

}