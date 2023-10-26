package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entity.Logement;
import entity.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Queries implements GraphQLRootResolver {
    RendezVousRepository rendezVousRepository ;
    LogementRepository logementRepository;

    public Queries(RendezVousRepository rendezVousRepository, LogementRepository logementRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.logementRepository = logementRepository;
    }

    public List<RendezVous> listRendezVous(){
        return  rendezVousRepository.getListeRendezVous();
    }
    public RendezVous getRendezVousById(int id){
        return rendezVousRepository.getRendezVousByID(id);
    }
    public List<Logement> listLogement(){
        return logementRepository.getAllLogements();
    }

    public List<Logement> listLogementByType(Logement.Type t){
        return logementRepository.getLogementsByType(t);
    }

}
