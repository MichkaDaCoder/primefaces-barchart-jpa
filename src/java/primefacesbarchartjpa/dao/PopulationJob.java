package primefacesbarchartjpa.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import primefacesbarchartjpa.model.Population;

/**
 * PopulationJob.java: contains the implementation of the List method of getting
 * <b>Population</b> records. Implements <b>IPopulationDAO</b> interface.
 *
 * @author MichkaDaCoder
 */
public class PopulationJob implements IPopulationDAO {

    IDatabase iDatabase = new DatabaseJob();

    public PopulationJob() {
        this.getiDatabase().connect();
    }

    public IDatabase getiDatabase() {
        return iDatabase;
    }

    @Override
    public List<Population> ListPopulation() {
        CriteriaQuery cq = getiDatabase().getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Population.class));
        return getiDatabase().getEntityManager().createQuery(cq).getResultList();
    }

}
