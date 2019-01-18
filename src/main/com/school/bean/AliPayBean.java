package school.bean;

public class AliPayBean {

	/** 商户订单号，需要保证不重复 */
	private String out_trade_no;

	/** 订单金额 */
	private String total_amount;
	// 订单的要求
	private String quest;
	/** 交易超时时间 */
	private String timeout_express;

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public String getQuest() {
		return quest;
	}

	public void setQuest(String quest) {
		this.quest = quest;
	}

	public String getTimeout_express() {
		return timeout_express;
	}

	public void setTimeout_express(String timeout_express) {
		this.timeout_express = timeout_express;
	}

}
