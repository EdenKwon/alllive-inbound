package allliveyoung.allliveinbound.mapper;

import allliveyoung.allliveinbound.domain.InboundInspection;
import allliveyoung.allliveinbound.domain.InboundRequest;

import java.util.List;
import java.util.Optional;

public interface InboundInspectionMapper {
    List<InboundInspection> findAll();

    Optional<InboundInspection> findById(Long id);

    void updateStatus(Long id, String status);
}
