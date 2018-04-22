package PlayCode.三十三道题.三十三02员工建模;package ��ʮ��02Ա����ģ;

public class Manager extends Employee {
	private double bonus;

	public Manager() {
		super();
	}

	public Manager(String name, int id, double salary, double bonus) {
		super(name, id, salary);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		//return "Manager [bonus=" + bonus + ",nam"]";
		return "Manager [name ="+getName()+",id="+getId()+",salary="+getSalary()+",bonus="+bonus+"]";
	}
	
	

}
