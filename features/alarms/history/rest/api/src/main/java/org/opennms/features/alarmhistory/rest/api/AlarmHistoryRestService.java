package org.opennms.features.alarmhistory.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/alarmhistory")
public class AlarmHistoryRestService {

    @POST
    @Path("/situations")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSituation(SituationCreationRequest request) {
        // In a real application, you would process the request here,
        // for example, by saving the situation to a database.
        // For now, we'll just return a success response.
        System.out.println("Received situation creation request for alarm ID: " + request.getAlarmId());
        System.out.println("Situation details: " + request.getSituationDetails());
        return Response.status(Response.Status.CREATED).entity(request).build();
    }
}
