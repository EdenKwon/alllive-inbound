package allliveyoung.allliveinbound.service;

import allliveyoung.allliveinbound.domain.InboundInspection;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class InboundInspectionServiceImpl implements InboundInspectionService{
    @Override
    public List<InboundInspection> findInboundInspections() {
        return null;
    }

    @Override
    public InboundInspection findInboundInspection(Long id) {
        return null;
    }

    @Override
    public void updateInboundStatus(Long id, String status) {

    }
}
