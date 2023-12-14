package racingcar.dto;

import java.util.List;
import racingcar.vo.ResultPosition;

public record FinalResult(ResultPosition resultPosition, List<String> winners) {
}
