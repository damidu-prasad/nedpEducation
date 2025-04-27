package lk.exon.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lk.exon.dao.StreamDAO;
import lk.exon.dao.SubjectDAO;
import lk.exon.models.Stream;
import lk.exon.models.Subject;

import java.util.List;
import java.util.Map;

@Path("/timetable")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimetableController {
    private final SubjectDAO subjectDAO = new SubjectDAO();
    private final StreamDAO streamDAO = new StreamDAO();

    @GET
    @Path("/subjects")
    public Response getSubjects() {
        List<Subject> subjects = subjectDAO.getAllSubjects();
        return Response.ok(subjects)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                .build();
    }

    @GET
    @Path("/streams")
    public Response getStream() {
        List<Stream> streams = streamDAO.getAllStreams();
        return Response.ok(streams)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                .build();
    }

    @POST
    @Path("/save")
    public Response saveTimetable(Map<String, Object> payload) {
        // Log the received payload for debugging purposes
        System.out.println("Received timetable payload:");
        System.out.println(payload);
        return Response.ok(Map.of("message", "Timetable saved successfully"))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                .build();
    }


    @OPTIONS
    @Path("/save")
    public Response preflightSave() {
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                .build();
    }

    // This handles the CORS preflight request for all paths under /timetable
    @OPTIONS
    @Path("{any: .*}")
    public Response preflight(@PathParam("any") String any) {
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                .build();
    }
}
