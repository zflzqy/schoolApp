package school.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeCancelModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradeCancelRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;

public class AliPayKit {

	private String serverUrl;

	private String appId;

	private String privateKey;

	private String format;

	private String charset;

	private String alipayPulicKey;

	private String signType;

	private AlipayClient alipayClient;

	public AliPayKit() {
		super();
		this.serverUrl = "https://openapi.alipaydev.com/gateway.do";
		this.appId = "2016092300576097";
		this.privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCHomhh1pi++of7o6tlAeFmoQkKGjkFXWWXHl58UjHyQNyi6ZVAXfpNbS3r86Bf9jtDxnTn271rqyhcvXV0wRc5qxP10lz1x2mauB1pTtmoIZXJS/dYb6bbxZEccitKvt0RnaNiOwrFIr9rqLQeP0BgptXQTFj/LU9fRrR7ZaVEM8RIptpK7u1vrc7SQLLBxidY0os/K0DLkbQZT5wMY3mr8nnjE0wuqpJkGtaRCFI/bs4avcHzD4pzTAeQySeDDv2oOqC8xyGwRbJlu4YddBJY+6Ms/MTxKkqDWPpRbgy32yWytaA2XkJBxsgE5S4wLDsm7BcnBxcnIlb/s9M4xOIBAgMBAAECggEABGqfZ4ArXRyfTOxZamKTSlo4ByIvdSNDaZZNkVLD2ZWPGabtezkUK21Ar4wxTq6f42cU62/WTSk3mT16E6Et9mzBq6F78Wza3XTdUE6G+9iMHg/hL/oCvulB/mEhU7+/RxGQ/mPZx+2HuiO2Kb35hKwqDixOQZDiIsIUomf+56eTr9Q2fn0gnWZUkDjVxGzm/n7JOLEd5NAc2JwPG5EceWGt+Tl73XpIwcQFoq78m4XlYChtK7x2Wx6+8LM+dk5r4/JQc6U2p/fmgbPubQIUiysbqiG+rQ0ubQspyBPkXEJY3N6+VMfuMR7fCw/Pv9IP0W5x+yRGtvBQVuQZuU7+2QKBgQDLlT04+6qIAsHL5OmuuQXylzBEVr4DqkTSmv1//GDE5A118GaaoQDsfh8Ys/1g6ToaBYIh5uBAgM7uauVMN5/lSyZyUr63oSuxr5BHuRO089fSrkStgO6GwpmZAsSfueAj2/KYThLreWXq05jBEwgO7vfAvd6/BT21B1b5ic+ZFwKBgQCqjnnoANtqo/3FMzryIOckwPDENh8xYdbg7UwlOX3IZURX0DDC89pTHkW13Hz9/dpiQxUT6XCJk9N2yQRY1FM9ggCzGPp2ZLAjjF6SfjpFQLaMco3EkZmjVge9DLi6eEHj8TNpX77dvAPA47NBu0ZJEgPDYuOAxh5NIdEj5CKcpwKBgF35aeVf5nwaKbMg2+3XYrN0rscc82Flu5csDFCEA3dffgcvDW3bXD3OijQxAYk2n6dbW5KirGmaC+tqVKY2Fw0U/45OO9MwBqdiz0sMV9hzpvCNmQ4uMezq71P+Px0sBBcJdJZxk7I2u6EGQ8D8NAAQtzS1cJjkpnNmC/PsdXPJAoGAY7vK13rg05wvwgfyGTJaV6inYeVQGj1fPMomc8IJpoxpCXyJdwbHjUEvfGgBgzjVYg5eHfWsxBZ4Woazjwoh3t7Nb+1UULUSNsdXagx8IJD17mzyL5cAo32kKs1snEXEKfmamazOXLUb8Mh1wyMyt3ncT33dESlJAMuck4NNJhMCgYAFklobFDkeMf5i5dTiB/UNDkyNVxYwaFJRD8XUMoTC/Z77CChTwGwWm5UROLgIh+psuRKE/cVFsDv5hjkij028mTs2YKsZkeBHeTJbYJ5ms1pVQEbaYwTsUadm/d3B4MBiw1zpfwm6eo2kGzhPlvGnoQb1x21WvUxE/1N4ww79fA==";
		this.format = "json";
		this.charset = "utf-8";
		this.alipayPulicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAthdkwSmorGj2CEh1pvT75DL+/JcBId6gZUKWZ8FbMjjNnroCNLfijtj6ddJr/d5p7NDVGE3oSiCZmvpyhIYWhn3rdqTrEBV8QBHCxQnzN3ZjbFUeD/D1sTDvutsBEywRgjthOuILREyyI46UfJ3sgfOwCP7DFHFe9oddnRREyNovKhGrg9uw4F6V2ba3N97C1BwPFWZ8gO2XpdqtMA9IuXa44j6kmUETaf0mNnGoISA/YoWTeOv4eaa8wUu0dO0Bbg3aY6b1gGFgV0qfZtwHvFOkW/N50U6lhcz2DFgmcsmAIClgpnkqww3PaLKWyXwkM8hyKiBK//1mJ/iEUahISwIDAQAB";
		this.signType = "RSA2";

		alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, alipayPulicKey, signType);

	}

	public AliPayKit(String serverUrl, String appId, String privateKey, String format, String charset,
			String alipayPulicKey, String signType) {
		super();
		this.serverUrl = serverUrl;
		this.appId = appId;
		this.privateKey = privateKey;
		this.format = format;
		this.charset = charset;
		this.alipayPulicKey = alipayPulicKey;
		this.signType = signType;

		alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, alipayPulicKey, signType);

	}

	public AlipayTradePrecreateResponse ScanCodepayment(AliPayBean aBean) {

		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();// 创建预支付订单

		request.setBizContent(JSONObject.toJSONString(aBean));

		try {

			return alipayClient.execute(request);

		} catch (AlipayApiException e) {

			e.printStackTrace();
		}

		return null;

	}

	public AlipayTradeQueryResponse alipayTradeQueryResponse(String out_trade_no) {

		AlipayTradeQueryRequest aRequest = new AlipayTradeQueryRequest(); // 查询订单

		AlipayTradeQueryModel aModel = new AlipayTradeQueryModel();

		aModel.setOutTradeNo(out_trade_no);

		aRequest.setBizModel(aModel);

		try {

			return alipayClient.execute(aRequest);

		} catch (AlipayApiException e) {

			e.printStackTrace();
		}

		return null;

	}
	
	public AlipayTradeCancelResponse alipayTradeCancelResponse(String out_trade_no) {

		AlipayTradeCancelRequest aRequest = new AlipayTradeCancelRequest(); // 查询订单

		AlipayTradeCancelModel aModel = new AlipayTradeCancelModel();

		aModel.setOutTradeNo(out_trade_no);

		aRequest.setBizModel(aModel);

		try {

			return alipayClient.execute(aRequest);

		} catch (AlipayApiException e) {

			e.printStackTrace();
		}

		return null;

	}

}
