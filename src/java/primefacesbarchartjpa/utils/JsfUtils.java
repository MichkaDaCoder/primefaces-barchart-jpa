package primefacesbarchartjpa.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * JsfUtils.java: Utility class for GUI. Contains 2 methods for showing message dialog.
 * @author MichkaDaCoder
 */
public class JsfUtils {
    
    /**
     * Shows an info message.
     * @param title
     * @param text 
     */
    public static void showInfoMessage(String title, String text) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, text, title);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

    /**
     * Shows an error message
     * @param title
     * @param text 
     */
    public static void showErrorMessage(String title, String text) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, text);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
}
}
