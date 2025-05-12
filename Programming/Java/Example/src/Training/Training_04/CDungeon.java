package Training.Training_04;

/**
 * 던전
 */
public class CDungeon {
	/** 던전에 입장한다 */
	public void enter(CPlayer a_oPlayer) {
		CMonster oMonster = this.createMonster(a_oPlayer);
		
		try {
			do {
				a_oPlayer.attack(oMonster);
				
				System.out.println("\n=====> 플레이어 공격 후 <=====");
				System.out.printf("플레이어 체력 : %d\n", a_oPlayer.getHp_Standard());
				System.out.printf("몬스터 체력 : %d\n", oMonster.getHp_Standard());
				
				// 몬스터가 사망했을 경우
				if(oMonster.getHp_Standard() <= 0) {
					System.out.println("\n플레이어가 이겼습니다.");
					break;
				}
				
				Thread.sleep(1000);
				oMonster.attack(a_oPlayer);
				
				System.out.println("\n=====> 몬스터 공격 후 <=====");
				System.out.printf("플레이어 체력 : %d\n", a_oPlayer.getHp_Standard());
				System.out.printf("몬스터 체력 : %d\n", oMonster.getHp_Standard());
				
				// 플레이어가 사망했을 경우
				if(a_oPlayer.getHp_Standard() <= 0) {
					System.out.println("\n플레이어가 사망했습니다.");
					break;
				}
				
				Thread.sleep(1000);
			} while(true);
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
	
	/** 몬스터를 생성한다 */
	private CMonster createMonster(CPlayer a_oPlayer) {
		CMonster oMonster = new CMonster(a_oPlayer.getHp_Standard() / 2,
				a_oPlayer.getAtk_Standard(), a_oPlayer.getDef_Standard() / 2);
		
		return oMonster;
	}
}
