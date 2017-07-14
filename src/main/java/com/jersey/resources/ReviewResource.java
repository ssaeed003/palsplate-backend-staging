package com.jersey.resources;

import com.jersey.persistence.ReviewDao;
import com.jersey.representations.Review;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/reviews")
@Component
@Transactional
@Produces(MediaType.APPLICATION_JSON)
public class ReviewResource {

    private static final Logger log = LogManager.getLogger(ReviewResource.class);

    private final ReviewDao reviewDao;

    @Inject
    public ReviewResource(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @GET
    public List<Review> getAll(){
        return this.reviewDao.findAll();
    }

    @GET
    @Path("{id}")
    public Review getCook(@PathParam("id")long id) {
        Review review = reviewDao.findOne(id);
        if (review == null) {
            throw new WebApplicationException((Response.Status.NOT_FOUND));
        }
        return review;
    }

    /**
     * Create new Review
     * @param review
     * @return new review
     */
    @POST
    public Review save(@Valid Review review ) {
        return reviewDao.save(review);
    }


    /**
     * Update existing Review
     * @param id
     * @param review
     * @return updated review
     */
    @PUT
    @Path("{id}")
    public Review update(@PathParam("id")long id, @Valid Review review) {
        if(reviewDao.findOne(id) == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            review.setId(id);
            return reviewDao.save(review);
        }
    }

    /**
     * Delete review
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")long id) {
        Review review = reviewDao.findOne(id);
        if(review == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            reviewDao.delete(review);
        }
    }
}