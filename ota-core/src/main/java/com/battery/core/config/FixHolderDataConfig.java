package com.battery.core.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import com.battery.core.commons.DeviceTypeHolder;
import com.battery.core.models.GprsDeviceType;
import com.battery.core.service.GprsDeviceTypeService;

/**
 * 服务启动后加载数据库中参数表到服务内存中,方便后续程序中快速调用
 * @author zhangjia
 *
 */
@Configuration
@ConditionalOnProperty(name = "load.fixholderdata", havingValue="true")
public class FixHolderDataConfig implements ApplicationRunner{

	@Autowired
	GprsDeviceTypeService gprsDeviceTypeService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		//加载GprsDeviceType数据
		loadGprsDeviceTypes();
		
	}
	
	/**
	 * 1.从grps_device_type 表中获取所有GprsDeviceType数据
	 * 2.存储在服务内存中,存储结构为Map<键:gprsDeviceTypeCode,值:GprsDeviceType>
	 */
	private void loadGprsDeviceTypes() {
		GprsDeviceType query_gprsDeviceType = new GprsDeviceType();
		List<GprsDeviceType> gprsDeviceTypes = gprsDeviceTypeService.selectListSelective(query_gprsDeviceType);
		for (GprsDeviceType gprsDeviceType : gprsDeviceTypes) {
			DeviceTypeHolder.updateGprsType(gprsDeviceType.getDeviceTypeCode(), gprsDeviceType);
		}
	}
}
