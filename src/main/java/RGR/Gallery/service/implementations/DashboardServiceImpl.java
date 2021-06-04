package RGR.Gallery.service.implementations;

import RGR.Gallery.model.Dashboard;
import RGR.Gallery.model.User;
import RGR.Gallery.service.interfaces.DashboardService;
import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.stereotype.Service;

@Service
@Join(path = "/", to = "/dashboard.jsf")
public class DashboardServiceImpl implements DashboardService {
    private Dashboard dashboard;
    private final UserServiceImpl userServiceImpl;
    private final AlbumServiceImpl albumServiceImpl;
    private final PublicationServiceImpl publicationServiceImpl;
    private final DocumentServiceImpl documentServiceImpl;
    private final CommentServiceImpl commentServiceImpl;

    private Boolean showProfile = false;
    private Boolean showSearch = false;

    public DashboardServiceImpl(UserServiceImpl userServiceImpl, AlbumServiceImpl albumServiceImpl, CommentServiceImpl commentServiceImpl, PublicationServiceImpl publicationServiceImpl, DocumentServiceImpl documentServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.albumServiceImpl = albumServiceImpl;
        this.commentServiceImpl = commentServiceImpl;
        this.publicationServiceImpl = publicationServiceImpl;
        this.documentServiceImpl = documentServiceImpl;
    }

    public void init(Long userId) {
        User user = userServiceImpl.loadUser(userId);
        dashboard = new Dashboard(user);
        dashboard.setAlbums(albumServiceImpl.loadAlbums(userId));
        dashboard.setDocuments(documentServiceImpl.loadDocuments(userId));
        dashboard.setPublications(publicationServiceImpl.loadPublications(userId));

    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public Boolean getShowProfile() {
        return showProfile;
    }

    public void setShowProfile(Boolean showProfile) {
        this.showProfile = showProfile;
    }

    public Boolean getShowSearch() {
        return showSearch;
    }

    public void setShowSearch(Boolean showSearch) {
        this.showSearch = showSearch;
    }
}
