package allliveyoung.allliveinbound.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InboundStatusUpdateDTO {
    private Long id;
    private String status;
    private String rejectionNote;
}
