package sl.aboutteamservice.bll;

import sl.aboutteamservice.bll.blo.AboutTeamObject;
import sl.aboutteamservice.dal.AboutTeamDataAccess;
import sl.aboutteamservice.dal.AboutTeamDataAccessManager;
import sl.aboutteamservice.dal.dao.AboutTeamDataAccessObject;

public class AboutTeamBusinessLogic {
    private AboutTeamDataAccessManager aboutTeamDataAccessManager;
    private AboutTeamDataAccess aboutTeamDataAccess;

    public AboutTeamBusinessLogic() {
        aboutTeamDataAccessManager = new AboutTeamDataAccessManager();
        aboutTeamDataAccess = new AboutTeamDataAccess();
    }

    public AboutTeamObject getAboutTeamObject() {
        AboutTeamDataAccessObject aboutTeamDataAccessObject = aboutTeamDataAccess.getAboutTeamDataAccessObject();
        AboutTeamObject aboutTeamObject = aboutTeamDataAccessManager.getAboutTeamObject(aboutTeamDataAccessObject);
        aboutTeamObject = filterAboutTeamObject(aboutTeamObject);
        return aboutTeamObject;
    }

    private AboutTeamObject filterAboutTeamObject(AboutTeamObject aboutTeamObject) {
        AboutTeamObject filteredAboutTeamObject = aboutTeamObject;
        return filteredAboutTeamObject;
    }
}