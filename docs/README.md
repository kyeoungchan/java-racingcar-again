# 레이싱카 프로젝트

## 기능 목록
- [x] 각 라운드별로 자동차들의 위치가 변한다. => 핵심 비즈니스
  - [x] 위치가 변하는 기준은 `pickNumberInRange()`을 돌렸을 때 0~9 중 값이 4 이상일 때 움직인다.
- [x] 마지막 결과물을 보고 최종 우승자가 누구누구인지 판별한다.
- [ ] 입력받은 자동차의 이름을 분리한다.
  - [ ] 쉼표를 기준으로 공백은 자동으로 제거해준다.
- [ ] 분리한 자동차 이름을 검증한다.
  - [ ] 이름이 5자 이하인지 검증한다.
  - [ ] 중복된 이름이 입력되면, 뒤에 숫자를 붙여서 반환한다.(숫자까지 포함하면 6자를 허용한다.)
- [ ] 시도할 횟수를 입력받고 검증한다.
  - [ ] 1 이상의 자연수인지 검증한다.
  - [ ] 최대 라운든느 20 라운드 이하로 제한한다.(요구 사항에는 없지만, 현실적으로 20라운드 이상 진행할 것 같지는 않다.)

## 도메인 모델
### Car
1. status
   - String name
   - int position
2. behavior
   - void validateName(String name)
   - CarInfo playOneRound(int round, boolean movingStatus)
   - CarInfo generateCarInfo(int round)

### RandomEngine
1. status
2. behavior
   - boolean ifMove()
   - int generateEngine()

### CarInfo
1. status
   - String name
   - int currentPosition
   - int currentRound
2. behavior

### SingleRoundPosition
1. status
   - Map<String, Integer> carsPositions
2. behavior
   - int getPosition(String carName)
   - List<String> getCarNames()
   - void writeNewCarPosition(String carName, int position)

### ResultPosition
1. status
   - Map<Integer, SingleRoundPosition> positionsPerRound
2. behavior
   - SingleRoundPosition getPositionsByRound(int round)
   - void addNewPositions(CarInfo carInfo)
   - boolean isThisRound(int round)

### WinnersCalculator
1. status
2. behavior
   - List<String> calculateWinners(SingleRoundPosition finalPositions)

### Record
1. status
   - ResultPosition positions
   - int finalRound
2. behavior
   - void writePosition(CarInfo carInfo)
   - ResultPosition getAllPositions()
   - boolean isFinalRound()

### CarNames
1. status
   - List<String> carNames
2. behavior
   - List<String> getCarNames()

### Rounds
1. status
   - int finalRound
2. behavior
   - int getFinalRound()