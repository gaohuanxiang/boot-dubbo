package api.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ShowBookDto implements Serializable {
    private Integer pageNo;
    private Integer pageSize;
    private String bookName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate minTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate maxTime;
}
