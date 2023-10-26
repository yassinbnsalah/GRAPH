package graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.LogementRepository;
import repository.RendezVousRepository;

import javax.servlet.annotation.WebServlet;

@WebServlet("/graphql")
public class GraphqlEndpoint extends SimpleGraphQLServlet {

    public GraphqlEndpoint(){
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        RendezVousRepository r = new RendezVousRepository();
        LogementRepository l = new LogementRepository();
        return SchemaParser.newParser()
                .file("schema.graphql")
                .resolvers(new Queries(r,l),new Mutations(r,l))
                .build()
                .makeExecutableSchema();
    }


}
