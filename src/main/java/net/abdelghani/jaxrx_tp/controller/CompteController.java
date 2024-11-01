package net.abdelghani.jaxrx_tp.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import net.abdelghani.jaxrx_tp.entities.Compte;
import net.abdelghani.jaxrx_tp.repositry.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/banque")
public class CompteController {
    @Autowired
    private CompteRepository compteRepo;

    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Compte> getComptes() {
        return compteRepo.findAll();
    }


    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Compte getCompte(@PathParam("id") Long id) {
        return compteRepo.findById(id).orElse(null);
    }

    @Path("/comptes")
    @POST
    @Consumes({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Compte addCompte(Compte compte) {
        return compteRepo.save(compte);
    }


    @Path("/comptes/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Compte updateCompte(@PathParam("id") Long id, Compte compte) {
        Compte existingCompte = compteRepo.findById(id).orElse(null);
        if (existingCompte != null) {
            existingCompte.setPrix(compte.getPrix());
            existingCompte.setDateCreation(compte.getDateCreation());
            existingCompte.setType(compte.getType());
            return compteRepo.save(existingCompte);
        }
        return null;
    }

    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void deleteCompte(@PathParam("id") Long id) {
        compteRepo.deleteById(id);
    }
}
