package allliveyoung.allliveinbound.service;

import allliveyoung.allliveinbound.domain.InboundInspection;
import allliveyoung.allliveinbound.domain.InboundRequest;

import java.util.List;

public interface InboundInspectionService {
    List<InboundInspection> findInboundInspections();

    InboundInspection findInboundInspection(Long id);

    void updateInboundStatus(Long id, String status);
}
