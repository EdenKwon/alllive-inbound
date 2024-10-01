package allliveyoung.allliveinbound.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Long memberId;
    private String storeTemperature;
    private String type;
    @DateTimeFormat(pattern = "yyyy. MM. dd. a hh:mm")
    private LocalDateTime licenseDate;
    private int licenseNum;
}
