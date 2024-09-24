package allliveyoung.allliveinbound.domain;

import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InboundInspection {
    private Long id;
    private Member member;
    private Boolean isFault;
    private String rejectionNote;
    private String code;
}
