package primefacesbarchartjpa.dao;

import java.util.List;
import primefacesbarchartjpa.model.Population;

/**
 * IPopulationDAO.java: Interface that contains the declarations of the CRUD
 * methods. Implemented by the class PopulationJob.
 * @author MichkaDaCoder
 */
public interface IPopulationDAO {
    /**
     * Gets all the records of <b>Population</b> table.
     * @return <b>list of Population</b>
     */
    List<Population> ListPopulation();
}
