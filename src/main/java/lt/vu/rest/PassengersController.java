package lt.vu.rest;

import lombok.*;
import lt.vu.entities.Passenger;
import lt.vu.persistence.PassengersDAO;
import lt.vu.rest.contracts.PassengerDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/passenger")
public class PassengersController {
    @Inject
    @Setter @Getter
    private PassengersDAO passengersDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Passenger passenger = passengersDAO.getById(id);
        if (passenger == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        PassengerDto passengerDto = new PassengerDto();
        passengerDto.setFirstName(passenger.getFirstName());
        passengerDto.setLastName(passenger.getLastName());

        return Response.ok(passengerDto).build();
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(PassengerDto passengerDto) {
        Passenger passenger = new Passenger();
        passenger.setFirstName(passengerDto.getFirstName());
        passenger.setLastName(passengerDto.getLastName());
        passengersDAO.create(passenger);
        return Response.ok().build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer playerId, PassengerDto passengerDto) {
        try {
            Passenger existingPassenger = passengersDAO.getById(playerId);
            if (existingPassenger == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingPassenger.setFirstName(passengerDto.getFirstName());
            existingPassenger.setLastName(passengerDto.getLastName());
            passengersDAO.update(existingPassenger);
            return Response.ok().build();
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
