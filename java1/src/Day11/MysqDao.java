package Day11;

public class MysqDao implements DataAccessObject {

	@Override
	public void select() {
		System.out.println("MYSQL DB에서 검색");
	}
	@Override
	public void insert() {
		System.out.println("MYSQL DB에 삽입");
	}
	@Override
	public void update() {
		System.out.println("MYSQL DB를 수정");
	}
	@Override
	public void delete() {
		System.out.println("MYSQL DB에서 삭제");
	}
}
