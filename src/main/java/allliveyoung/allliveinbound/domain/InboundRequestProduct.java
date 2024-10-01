package allliveyoung.allliveinbound.domain;

import lombok.*;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InboundRequestProduct {
    private Long id;
    @NumberFormat(pattern = "#,###")
    private int palletQuantity;
    @NumberFormat(pattern = "#,###")
    private int boxQuantity;
    private String manufactureNum;
    @DateTimeFormat(pattern = "yyyy. MM. dd. a hh:mm")
    private LocalDateTime expirationDate;
    private InboundRequest inboundRequest;
    private Product product;
}
