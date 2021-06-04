package RGR.Gallery.dashboard;

import RGR.Gallery.service.interfaces.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "DashboardController")
public class DashboardController {
    private final DashboardService dashboardService;
    private final UserService userService;
    private final AlbumService albumService;
    private final PublicationService publicationService;
    private final CommentService commentService;


    public DashboardController(DashboardService dashboardService, UserService userService, AlbumService albumService, PublicationService publicationService, CommentService commentService) {
        this.dashboardService = dashboardService;
        this.userService = userService;
        this.albumService = albumService;
        this.publicationService = publicationService;
        this.commentService = commentService;
    }
//    public String loadTodoPage() {
//
//        return "/todo.xhtml";
//    }
}
