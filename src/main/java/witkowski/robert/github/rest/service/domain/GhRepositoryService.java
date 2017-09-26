package witkowski.robert.github.rest.service.domain;

import witkowski.robert.github.rest.service.domain.dto.GhRepositoryDto;

import java.io.IOException;
import java.util.Collection;

public interface GhRepositoryService {

    /**
     * Get repository list from selected user. If user not exists or user has not repos - this method return empty list.
     * @param username - owner
     * @return
     */
    Collection<GhRepositoryDto> findAllBy(String username) throws IOException;

    /**
     * Find information about repository name in selected user repository list.
     * If repository not exists in selected user repository list - this method return empty dto (Null Object Pattern).
     * @param username - owner
     * @param repositoryName - repository name
     * @return
     */
    GhRepositoryDto findOne(String username, String repositoryName) throws IOException;
}
