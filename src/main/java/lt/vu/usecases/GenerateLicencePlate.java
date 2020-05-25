package lt.vu.usecases;

import lt.vu.services.ILicencePlateGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateLicencePlate implements Serializable {
    @Inject
    ILicencePlateGenerator licencePlateGenerator;

    private CompletableFuture<String> licencePlateGenerationTask = null;

    public String generateNewJerseyNumber() {
        licencePlateGenerationTask = CompletableFuture.supplyAsync(() -> licencePlateGenerator.generateLicencePlate());
        return "/vehicles.xhtml?faces-redirect=true";
    }

    public boolean isLicencePlateGenerationRunning() {
        return licencePlateGenerationTask != null && !licencePlateGenerationTask.isDone();
    }

    public String getJerseyGenerationStatus() throws ExecutionException, InterruptedException {
        if (licencePlateGenerationTask == null) {
            return null;
        } else if (isLicencePlateGenerationRunning()) {
            return "Licence plate generation in progress";
        }
        return "Suggested licence plate: " + licencePlateGenerationTask.get();
    }

    private void reload()  {
        try {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(((HttpServletRequest) externalContext.getRequest()).getRequestURI());
        } catch (IOException e) {
        }
    }
}
