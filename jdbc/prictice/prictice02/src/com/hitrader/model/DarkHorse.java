package com.hitrader.model;

public class DarkHorse {
	private long id;
	private int role;
	private int aid;
	private String nick_name;
	private String head;
	private String national_name;
	private String national_us_name;
	private String national_tw_name;
	private String national_by_name;
	private int commodity_id;
	private String commodity_name;
	private long strategy_id;
	private double next_win_rate;
	private String crsc;
	
	public DarkHorse() {
		super();
	}

	public DarkHorse(long id, int role, int aid, String nick_name, String head, String national_name,
			String national_us_name, String national_tw_name, String national_by_name, int commodity_id,
			String commodity_name, long strategy_id, double next_win_rate, String crsc) {
		super();
		this.id = id;
		this.role = role;
		this.aid = aid;
		this.nick_name = nick_name;
		this.head = head;
		this.national_name = national_name;
		this.national_us_name = national_us_name;
		this.national_tw_name = national_tw_name;
		this.national_by_name = national_by_name;
		this.commodity_id = commodity_id;
		this.commodity_name = commodity_name;
		this.strategy_id = strategy_id;
		this.next_win_rate = next_win_rate;
		this.crsc = crsc;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getNational_name() {
		return national_name;
	}

	public void setNational_name(String national_name) {
		this.national_name = national_name;
	}

	public String getNational_us_name() {
		return national_us_name;
	}

	public void setNational_us_name(String national_us_name) {
		this.national_us_name = national_us_name;
	}

	public String getNational_tw_name() {
		return national_tw_name;
	}

	public void setNational_tw_name(String national_tw_name) {
		this.national_tw_name = national_tw_name;
	}

	public String getNational_by_name() {
		return national_by_name;
	}

	public void setNational_by_name(String national_by_name) {
		this.national_by_name = national_by_name;
	}

	public int getCommodity_id() {
		return commodity_id;
	}

	public void setCommodity_id(int commodity_id) {
		this.commodity_id = commodity_id;
	}

	public String getCommodity_name() {
		return commodity_name;
	}

	public void setCommodity_name(String commodity_name) {
		this.commodity_name = commodity_name;
	}

	public long getStrategy_id() {
		return strategy_id;
	}

	public void setStrategy_id(long strategy_id) {
		this.strategy_id = strategy_id;
	}

	public double getNext_win_rate() {
		return next_win_rate;
	}

	public void setNext_win_rate(double next_win_rate) {
		this.next_win_rate = next_win_rate;
	}

	public String getCrsc() {
		return crsc;
	}

	public void setCrsc(String crsc) {
		this.crsc = crsc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aid;
		result = prime * result + commodity_id;
		result = prime * result + ((commodity_name == null) ? 0 : commodity_name.hashCode());
		result = prime * result + ((crsc == null) ? 0 : crsc.hashCode());
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((national_by_name == null) ? 0 : national_by_name.hashCode());
		result = prime * result + ((national_name == null) ? 0 : national_name.hashCode());
		result = prime * result + ((national_tw_name == null) ? 0 : national_tw_name.hashCode());
		result = prime * result + ((national_us_name == null) ? 0 : national_us_name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(next_win_rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nick_name == null) ? 0 : nick_name.hashCode());
		result = prime * result + role;
		result = prime * result + (int) (strategy_id ^ (strategy_id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DarkHorse other = (DarkHorse) obj;
		if (aid != other.aid)
			return false;
		if (commodity_id != other.commodity_id)
			return false;
		if (commodity_name == null) {
			if (other.commodity_name != null)
				return false;
		} else if (!commodity_name.equals(other.commodity_name))
			return false;
		if (crsc == null) {
			if (other.crsc != null)
				return false;
		} else if (!crsc.equals(other.crsc))
			return false;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		if (id != other.id)
			return false;
		if (national_by_name == null) {
			if (other.national_by_name != null)
				return false;
		} else if (!national_by_name.equals(other.national_by_name))
			return false;
		if (national_name == null) {
			if (other.national_name != null)
				return false;
		} else if (!national_name.equals(other.national_name))
			return false;
		if (national_tw_name == null) {
			if (other.national_tw_name != null)
				return false;
		} else if (!national_tw_name.equals(other.national_tw_name))
			return false;
		if (national_us_name == null) {
			if (other.national_us_name != null)
				return false;
		} else if (!national_us_name.equals(other.national_us_name))
			return false;
		if (Double.doubleToLongBits(next_win_rate) != Double.doubleToLongBits(other.next_win_rate))
			return false;
		if (nick_name == null) {
			if (other.nick_name != null)
				return false;
		} else if (!nick_name.equals(other.nick_name))
			return false;
		if (role != other.role)
			return false;
		if (strategy_id != other.strategy_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DarkHorse [id=" + id + ", role=" + role + ", aid=" + aid + ", nick_name=" + nick_name + ", head=" + head
				+ ", national_name=" + national_name + ", national_us_name=" + national_us_name + ", national_tw_name="
				+ national_tw_name + ", national_by_name=" + national_by_name + ", commodity_id=" + commodity_id
				+ ", commodity_name=" + commodity_name + ", strategy_id=" + strategy_id + ", next_win_rate="
				+ next_win_rate + ", crsc=" + crsc + "]";
	}
	

	

}
