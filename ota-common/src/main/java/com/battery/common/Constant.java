/**
 * 
 */
package com.battery.common;

/**
 * @author zdm
 *
 */
public class Constant {

	// session 标示
	public final static String SESSION_INN_ID = "inn_id";
	public final static String SESSION_USER_CODE = "user_code";
	public final static String SESSION_LOGIN_USER = "loginUser";

	// 返回json格式
	public final static String RS_MSG_SUCCESS = "操作成功";
	public final static String RS_MSG_ERROR = "操作错误";
	public final static String RS_CODE_SUCCESS = "0000";
	public final static String RS_CODE_ERROR = "0001";

	public static final String PREFIX_DELETED_ROOMTYPE = "已删除_";

	public final static String MEDIA_APPLICATION_JSON = "application/json;charset=UTF-8";

	public final static String STATUS_NORMAL = "0";
	public final static String STATUS_FORBIDEN = "1";
	public final static String STATUS_DEL = "2";

	public final static String ERROR_REQUEST = "ajaxResponse";

	public final static String TEMPLETE_PATH = Constant.class.getClassLoader().getResource("").getPath() + "template/";
	//算平均内阻的保存在redis 中的key+stationId
	public final static String AVGRESIST_PATH = "srv_battery_stationDetaile_resist_";
	//获取5条内阻值
	public final static String CELLRESIST_PATH = "srv_battery_stationDetaile_cellResist5_";
	// 放电历史记录redis缓存的key前缀
	public final static String DISHISTORY_KEY_PREFIX = "srv_battery_station_dishistory_";
	//放电数据缓存stationid.
	public final static String DISCHARGE_KEY_PATH = "srv_battery_station_discharge_stationIds";
	//数据网关和后台关联gprsid和sationid
	public final static String STATIONID_GPRSID = "srv_battery_station_gatewayAndBackground_";
	//自动特征测试保存stationid;
	public final static String AUTO_PULSE_STATIONIDS_KEY = "srv_battery_autoPulseSend_ids";
    //开始自动特征测试时间
	public final static String AUTO_PULSE_INSERTTIME_KEY = "srv_battery_autoPulseSend_insertTime";
	//记录自动放电数据各个设备的上次检测结束的时间key;保存的是一个key,里面是map
	public final static String AUTO_DISCHARGE_KEY = "srv_battery_station_discharge_key";
	//最新的pack_data_cellInfo_latest数据集合保存在redis中的key
	public final static String PDCIL_KEY="srv_station_packDataCellInfoLatest_";
	//最新均衡从机信息pack_data_balance_info_latest 数据保存在redis中的key
	public final static String PDBIL_KEY="srv_station_packDataBalanceInfoLatest_";
    
	//拦截器request属性带有的用户信息名称
	public final static String REQUEST_USER_ID = "_userId";
	public final static String REQUEST_USER_TYPE = "_userType";
	
	//token属性带有的用户信息名称
	public final static String TOKEN_USER_ID = "aud";
	public final static String TOKEN_USER_TYPE = "type";
}
