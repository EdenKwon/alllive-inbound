package allliveyoung.allliveinbound.web.dto;

import allliveyoung.allliveinbound.domain.InboundRequest;
import allliveyoung.allliveinbound.domain.Member;
import allliveyoung.allliveinbound.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InboundProductDTO {
    private Long id;
    private int palletQuantity;
    private int boxQuantity;
    private String manufactureNum;
    private String expirationDate;
    private InboundRequest inboundRequest;
    private Product product;
    private Member member;
}
