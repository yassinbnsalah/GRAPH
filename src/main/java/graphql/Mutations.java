package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entity.Logement;
import entity.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

public class Mutations implements GraphQLRootResolver {
    public RendezVousRepository rendezVousRepository ;
    public LogementRepository logementRepository;

    public Mutations(RendezVousRepository rendezVousRepository, LogementRepository logementRepository){
        this.rendezVousRepository = rendezVousRepository ;
        this.logementRepository = logementRepository;
    }
    public boolean createRendezVous(int id , String date , String heure , int refLog , String num){

        Logement l =logementRepository.getLogementsByReference(refLog);
        return  this.rendezVousRepository.addRendezVous(new RendezVous(id,date , heure , l , num));
    }

    public boolean createLogement(int reference , String adresse){
        Logement l = new Logement(reference , adresse);
        return logementRepository.saveLogement(l);
    }

    public boolean updateRendezVous(int id , String date , String heure , String numTel){
        Logement l = rendezVousRepository.getLogementByRDV(id);
        RendezVous r = new RendezVous(id,date,heure , l,numTel);
        return rendezVousRepository.updateRendezVous(r);
    }


    public String deleteRendezVous(int id){
        if(rendezVousRepository.deleteRendezVous(id)){
            return "deleted";
        }else {
            return "failed" ;
        }
        //return rendezVousRepository.deleteRendezVous(id);
    }




}
