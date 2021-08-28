package bean;

public class Tariff {
    private int tariffId;     //资费ID
	private String tariffName;     //资费名称
	private int timeLong;       //资费时长
	private int timeTariff;     //单位费用
	private double tariff;      //资费金额
	private String createTime;      //资费创建时间
	private String openTime;      //资费开启时间
	private String status;     //资费状态（开通或暂停）
	private String tariffType;  //资费类型
	private String tariffExplain; //资费说明
    public Tariff() {
	}
   
    public Tariff(int tariffId, String traiffName, int timeLong, int timeTariff, double tariff,
			 String status, String tariffType, String tariffExplain) {
		this.tariffId = tariffId;
		this.tariffName = traiffName;
		this.timeLong = timeLong;
		this.timeTariff = timeTariff;
		this.tariff = tariff;
		this.tariffType = tariffType;
		this.tariffExplain = tariffExplain;
	}

	public Tariff(String traiffName, int timeLong, double tariff,
    		int timeTariff,String status,String tariffType, String tariffExplain) {
    	this.tariffName = traiffName;
		this.timeLong = timeLong;
		this.tariff = tariff;
		this.status = status;
		this.tariffType = tariffType;
		this.tariffExplain = tariffExplain;
		this.timeTariff = timeTariff;
    }

	public int getTariffId() {
		return tariffId;
	}
	public void setTariffId(int tariffId) {
		this.tariffId = tariffId;
	}
	public String getTariffName() {
		return tariffName;
	}
	public void setTariffName(String traiffName) {
		this.tariffName = traiffName;
	}
	public int getTimeLong() {
		return timeLong;
	}
	public void setTimeLong(int timeLong) {
		this.timeLong = timeLong;
	}
	public double getTariff() {
		return tariff;
	}
	public void setTariff(double tariff) {
		this.tariff = tariff;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getTariffType() {
		return tariffType;
	}

	public void setTariffType(String tariffType) {
		this.tariffType = tariffType;
	}

	public String getTariffExplain() {
		return tariffExplain;
	}

	public void setTariffExplain(String tariffExplain) {
		this.tariffExplain = tariffExplain;
	}

	public int getTimeTariff() {
		return timeTariff;
	}

	public void setTimeTariff(int timeTariff) {
		this.timeTariff = timeTariff;
	}

}
