package witkowski.robert.github.rest.service.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import witkowski.robert.github.rest.service.integration.github.dto.IntegrationGhRepository;

import java.io.Serializable;

@Builder
@Getter
public class GhRepositoryDto implements Serializable {

    private final Long id;
    private final String fullName;
    private final String description;
    private final String cloneUrl;
    private final int stars;
    private final String createdAt;

    /**
     * Map entity from integration module to DTO
     *
     * @param repo - integration entity
     * @return
     */
    public static GhRepositoryDto createFromIntegrationEntity(IntegrationGhRepository repo) {
        if (repo == null) {
            return empty();
        }
        return GhRepositoryDto.builder()
                .id(repo.getId())
                .fullName(repo.getFullName())
                .description(repo.getDescription())
                .cloneUrl(repo.getCloneUrl())
                .stars(repo.getStars())
                .createdAt(repo.getCreatedAt())
                .build();
    }

    /**
     * Empty DTO (Null Object Pattern)
     *
     * @return
     */
    public static GhRepositoryDto empty() {
        return GhRepositoryDto.builder().build();
    }

    @JsonIgnore
    public boolean isEmpty() {
        return id == null;
    }
}
