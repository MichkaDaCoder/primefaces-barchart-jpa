
package primefacesbarchartjpa.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import primefacesbarchartjpa.dao.IPopulationDAO;
import primefacesbarchartjpa.dao.PopulationJob;
import primefacesbarchartjpa.model.Population;
import primefacesbarchartjpa.utils.JsfUtils;

/**
 * PopulationController.java: backing-bean or the controller of the <b>Population</b> module.
 * Implements <b>Serializable</b> and contains some methods and attributes. Some of them are
 * used for populating the PrimeFaces <b>chart</b> component from the table <b>population</b>
 * @author MichkaDaCoder
 */
public class PopulationController implements Serializable{

    Population Population=new Population();
    IPopulationDAO iPopulationDAO=new PopulationJob();
    private BarChartModel barChartModel;
    
    private final String PARAM_CHART_TITLE="Population Chart";
    private final String PARAM_CHART_LABEL="Population";
    private final String PARAM_CHART_LEGEND_POSITION="nw";
    private final String PARAM_CHART_X_LABEL="Years";
    private final String PARAM_CHART_Y_LABEL="Number";
    private final boolean PARAM_CHART_ANIMATE=true;
    private final int PARAM_CHART_YAXIS_MIN=0;
    private final int PARAM_CHART_YAXIS_MAX=500;
    
    public PopulationController() {
    }

    @PostConstruct
    public void init() {
        JsfUtils.showInfoMessage("Info", "Loading the chart...");
       createBarModel();
       JsfUtils.showErrorMessage("Success", "Successfully loaded Chart !");
    }
    
    /**
     * Creates the BarChartModel 
     */
    private void createBarModel() {
        this.barChartModel=initBarModel();
        
        this.barChartModel.setTitle(PARAM_CHART_TITLE);
        this.barChartModel.setLegendPosition(PARAM_CHART_LEGEND_POSITION);
        this.barChartModel.setAnimate(PARAM_CHART_ANIMATE);
        
        Axis xAxis = barChartModel.getAxis(AxisType.X);
        xAxis.setLabel(PARAM_CHART_X_LABEL);
         
        Axis yAxis = barChartModel.getAxis(AxisType.Y);
        yAxis.setLabel(PARAM_CHART_Y_LABEL);
        yAxis.setMin(PARAM_CHART_YAXIS_MIN);
        yAxis.setMax(PARAM_CHART_YAXIS_MAX);
    }
    
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries series = new ChartSeries();
        series.setLabel(PARAM_CHART_LABEL);
        for(Population pop:this.getiPopulationDAO().ListPopulation()) {
            series.set(pop.getYear(), pop.getNumber());
        }
        model.addSeries(series);
        return model;
    }
    
    public Population getPopulation() {
        return Population;
    }

    public IPopulationDAO getiPopulationDAO() {
        return iPopulationDAO;
    }

    public void setPopulation(Population Population) {
        this.Population = Population;
    }

    public BarChartModel getBarChartModel() {
        return barChartModel;
    }

    public void setBarChartModel(BarChartModel barChartModel) {
        this.barChartModel = barChartModel;
    }
    
    
    
}
