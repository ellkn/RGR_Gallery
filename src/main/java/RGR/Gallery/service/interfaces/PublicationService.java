package RGR.Gallery.service.interfaces;

import RGR.Gallery.model.Publication;

import java.util.List;

public interface PublicationService {
    List<Publication> loadPublications(Long userId);
}
