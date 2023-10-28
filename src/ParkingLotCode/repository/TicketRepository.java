package ParkingLotCode.repository;

import ParkingLotCode.exception.TicketNotFoundException;
import ParkingLotCode.models.Ticket;

import java.util.HashMap;

public class TicketRepository {
    HashMap<Integer, Ticket> TicketMap;

    public TicketRepository() {
        this.TicketMap = new HashMap<>();
    }

    public Ticket get(int TicketId) throws TicketNotFoundException {
        Ticket Ticket = TicketMap.get(TicketId);

        if(Ticket == null){
            throw new TicketNotFoundException("Ticket Not Found" + TicketId);
        }

        return Ticket;
    }

    public Ticket put(Ticket Ticket){
        TicketMap.put(Ticket.getId(), Ticket);
        return Ticket;
    }
}

