### MVC x OOP 미니프로젝트
README - 박동석

[내용]

- 상속, 예외처리 필수 구현

- 설명 
	- 플레이어가 몬스터를 해치우는 턴제 게임

- 캐릭터 클래스를 플레이어와 몬스터 클래스가 상속받는다.

- Chartacters
	- long charId; - 고유식별id
	- String name; - 이름
	- int health; - 체력
	- int level; - 레벨
	- int damage; - 데미지
	- int exp; - 경험치
	- 자식 Player
		- int cure; - 회복력
		- int mana; - 마나
		- List<Skill> skill; - 스킬목록
	- 자식 Monster
		- int count - 처치된 횟수
- Skill
	- int skillId; - 고유식별id
	- String name; - 이름
	- int cost; - 마나소모량
	- int level; - 사용가능레벨
	- int damageRatio - 데미지 비율



3. 기능

- CharactersService
	- List<Characters> getAllCharacters(char charType); - 모든 캐릭터 목록 조회
	- Characters getCharaterById(long id); - 해당 캐릭터 목록 조회
	- Player getPlayerById(long id) - 아이디로 player만 조회
	- void insertCharactersCharacters characters); - 캐릭터 추가
	- void deleteCharacters(long id) - 캐릭터 삭제
	- void updateSkill(Player player , Skill skill) - 캐릭터의 스킬 수정(추가만)


	- int attack(Characters attacker, Characters defender, Skill skill) - 캐릭터 간의 공격 이벤트 처리
	- void dead(Characters kill, Characters dead) - 누군가 죽었을 시에 대한 처리


	- void runAway(Player player) - 플레이어가 도망쳤을때에 대한 처리
	- int heal(Player player , int health) - 플레이어의 회복 시도 처리


- SkillService
	- List<Skill> getAllSkill() - 모든 스킬정보 리턴
	- Skill getSkillByName(String name) - 스킬이름으로 스킬찾기


-----


- PlayableInterface
	- 플레이어가 **가진** 기능
		- 회복 하다
		- 레벨업 하다
	- Player 에만 implements 하여 사용
- PropertyInterface
	- 속성 초기화를 위한 Characters 의 자식들이 **가진** 기능
	
	
- InvalidRequestException
	- 사용자의 잘못된 요청으로 응답해줄 수없음을 나타내는 예외 EX) 자기 레벨보다 높은 레벨의 스킬을 배우려고 시도할 떄
- NotExistException
	- 요청한 데이터가 존재하지 않을 떄



4. 실행

- StartView.java의 main 메소드에서 실행
	-StartView
		- 캐릭터 조회
		- 캐릭터 생성
		- 캐릭터 선택
			- PlayerView - 플레이어 정보를 입력해 게임할 수 있는 뷰로 이동
				- 내 캐릭터 조회
				- 전투시작
					- PlayerView.gameView() - 플레이어와 몬스터 둘 중 하나가 죽거나 플레이어가 도망가면 게임이 종료된다.
						- 공격하기
							- 스킬 이름을 입력해 스킬 공격을 할 수 있다.
						- 회복하기
						- 도망가기
				- 스킬관리
					- SkillView
						- 보유한 스킬을 확인하고 배우고 싶은 스킬을 선택한다.(미완성)
				- 메인메뉴로
		- 캐릭터 삭제
		- 시스템 종료
	- EndView 
		- controller에서 요청에 대한 응답을 할 때 보여줘야 할 뷰가 있다면 호출되는 응답성공뷰
	- FailView
		- controller에서 요청에 대한 응답으로 예외가 발생했을 때 보여주는 예외 뷰
		


