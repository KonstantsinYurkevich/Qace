package modals;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseStatus {
    boolean status;
    String errorMessage;
    List<ErrorFields> errorFields;
    Result result;
}
