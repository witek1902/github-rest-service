package witkowski.robert.github.rest.service.endpoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import witkowski.robert.github.rest.service.domain.GhRepositoryService;
import witkowski.robert.github.rest.service.domain.dto.GhRepositoryDto;
import witkowski.robert.github.rest.service.endpoint.exception.RepositoryNotFoundException;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping("repositories")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class GitHubEndpoint {

    private final GhRepositoryService ghRepositoryService;

    @RequestMapping(value = "/{owner:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Collection<GhRepositoryDto> findAllRepositoriesForOwner(@PathVariable String owner) throws IOException {
        log.info("findAllRepositoriesForOwner > start. Params: owner = " + owner);
        Collection<GhRepositoryDto> repos = ghRepositoryService.findAllBy(owner);
        return repos;
    }

    @RequestMapping(value = "/{owner}/{repositoryName:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    GhRepositoryDto findRepositoryForOwner(@PathVariable String owner, @PathVariable String repositoryName) throws IOException {
        log.info("findRepositoryForOwner > start. Params: owner = " + owner + ", repositoryName = " + repositoryName);
        GhRepositoryDto repo = ghRepositoryService.findOne(owner, repositoryName);
        if (repo.isEmpty()) {
            throw new RepositoryNotFoundException(owner, repositoryName);
        }
        return repo;
    }
}
