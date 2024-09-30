package allliveyoung.allliveinbound.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pallet {
    private Long id;
    private InboundRequestProduct inboundRequestProduct;
    private Section section;
}
